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
var React = require('react-native');
var WheelView = require('react-native-wheel');

var { AppRegistry,StyleSheet,Text,View,ToastAndroid } = React;

var wheelData = ['one','two','three','four','five','six','seven','eight','nine','ten'];

var AwesomeProject = React.createClass({

    onItemChange(index){
      ToastAndroid.show('select item : ' + wheelData[index],ToastAndroid.SHORT);
    },
    render: function() {
        return (
            <View style={styles.container}>
               <WheelView
                  style={styles.wheelview}
                  onItemChange={this.onItemChange}
                  values={wheelData}
                  isLoop={true}
                  selectedIndex={0}
                  textSize={17}
                  />
            </View>
        );
    }
});


var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  wheelview: {
    width: 120,
    height: 300
  },
});

AppRegistry.registerComponent('AwesomeProject', () => AwesomeProject);

```


## Notes
- if has error , please check build.gradle config
- you can modify this library (react-native-wheel/build.gradle)
```gradle

android {
    compileSdkVersion 23  //@
    buildToolsVersion "23.0.1"  //@

    defaultConfig {
        minSdkVersion 16 
        targetSdkVersion 23  //@
    }
}

dependencies {
    compile 'com.facebook.react:react-native:0.15.+'  //@
}

// modify the above @ value not higher than you project value

```

##Reference
https://github.com/weidongjian/androidWheelView

## Run Renderings
<center>
    <img src="https://github.com/shexiaoheng/react-native-wheel/blob/master/Screenshot/result.png"
    width="300" height="450"/>
</center>
