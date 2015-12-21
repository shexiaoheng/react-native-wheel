# react-native-wheel
the android wheel view for react-native component

## Installation and How to use

#### Step 1 - NPM Install

```shell
npm install --save react-native-wheel
```
#### Step 2 - Update Gradle Settings

```gradle
// file: android/settings.gradle
...

include ':reactwheelview', ':app' 
project(':reactwheelview').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-wheel')
 // if there are more library
 // include ':app' , ':libraryone' , ':librarytwo' , 'more...'
 // project(':libraryonename').projectDir = new File(rootProject.projectDir, '../node_modules/libraryonemodule')
 // project(':librarytwoname').projectDir = new File(rootProject.projectDir, '../node_modules/librarytwomodule')
 // more..
```

#### Step 3 - Update app Gradle Build

```gradle
// file: android/app/build.gradle
...

dependencies {
    ...
    compile project(':reactwheelview')
}
```

#### Step 4 - Register React Package

```java
...
import com.heng.wheel.WheelPackage;

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {

    private ReactInstanceManager mReactInstanceManager;
    private ReactRootView mReactRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .addPackage(new WheelPackage()) // register wheel package
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, "AwesomeProject", null);
        setContentView(mReactRootView);
    }
...

```

#### Step 5 - Require and use in Javascript

```js
// file: index.android.js

'use strict';

var React = require('react-native');
var {
  AppRegistry,
  StyleSheet,
  Text,
  ToastAndroid,
  View,
} = React;

var WheelView = require('react-native-wheel');

var Dimensions = require('Dimensions');


var SCREEN_WIDTH = Dimensions.get('window').width;
var SCREEN_HEIGHT = Dimensions.get('window').height;


var wheelData = ['one','two','three','four','five','six','seven','eight','nine','ten'];

var currentIndex;

var AwesomeProject = React.createClass({
  previous(){
    this.refs.wheel.previous();
  },
  next(){
    this.refs.wheel.next();
  },
  finish(){
    ToastAndroid.show('select item : ' + wheelData[currentIndex] ,ToastAndroid.LONG);
  },
  onItemChange(index){
    currentIndex = index;
  },
  render: function() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome} onPress={this.previous} >
          上一个
        </Text>
        <Text style={styles.instructions} onPress={this.next} >
          下一个
        </Text>
        <Text style={styles.instructions} onPress={this.finish} >
          完成
        </Text>
        <WheelView
          style={styles.wheelview}
          onItemChange={this.onItemChange}
          values={wheelData}
          isLoop={false}
          selectedIndex={0}
          textSize={20}
          ref='wheel'
        />
      </View>
    );
  }
});

var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'flex-end',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  previous: {
    margin: 20,
    fontSize: 22,
    color: '#000000',
  },
  next: {
    margin: 20,
    color: '#000000',
    fontSize: 22,
  },
  finish: {
    margin: 20,
    color: '#000000',
    fontSize: 22,
  },
  wheelview: {
    width: SCREEN_WIDTH,
    height: SCREEN_HEIGHT/5*2,
  },
});

AppRegistry.registerComponent('AwesomeProject', () => AwesomeProject);

```


## Notes

- Only in the following versions tested , other versions do not guarantee success
```gradle
// file: react-native-wheel/build.gradle

android {
    compileSdkVersion 23  //@
    buildToolsVersion "23.0.1"  //@

    defaultConfig {
        minSdkVersion 16 
        targetSdkVersion 22  //@
    }
}

dependencies {
    compile 'com.facebook.react:react-native:0.16.1'  //@
}


```

## Reference
https://github.com/weidongjian/androidWheelView

## Run Renderings
<center>
    <img src="https://github.com/shexiaoheng/react-native-wheel/blob/master/Screenshot/wheel.gif"
    width="300" height="450"/>
</center>
