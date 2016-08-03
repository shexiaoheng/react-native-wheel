# react-native-wheel
the android wheel view for react-native

## Installation and How to use

#### Step 1 - NPM Install

```shell
npm install --save react-native-wheel
```
#### Step 2 - Update Gradle Settings

```gradle
// file: android/settings.gradle
...

include ':react-native-wheel', ':app' 
project(':react-native-wheel').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-wheel')
```

#### Step 3 - Update app Gradle Build

```gradle
// file: android/app/build.gradle
...

dependencies {
    ...
    compile project(':react-native-wheel')
}
```

#### Step 4 - Register React Package

```java
...
import com.heng.wheel.WheelPackage;


    @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
            new MainReactPackage(),
            new WheelPackage()      // Added there
        );
    }
...

```

#### Step 5 - Require and use in Javascript

```js

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  ToastAndroid
} from 'react-native';

import WheelView from './wheel';

import Dimensions from 'Dimensions';

let SCREEN_WIDTH = Dimensions.get('window').width;
let SCREEN_HEIGHT = Dimensions.get('window').height;


let wheelData = [1,'two',false,0.10,'six','seven','eight','nine','ten'];

let currentIndex;

class AwesomeProject extends Component {
  ok(){
    ToastAndroid.show('select index : ' + currentIndex +' select item : ' + wheelData[currentIndex] ,ToastAndroid.SHORT);
  }
  _onItemChange(index){
    currentIndex = index;
  }
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.ok} onPress={this.ok.bind(this)} >
          确定
        </Text>
        <WheelView
          style={styles.wheelview}
          onItemChange={this._onItemChange.bind(this)}
          values={wheelData}
          isLoop={false}
          selectedIndex={0}
          textSize={20}
          velocityFling={20}
        />
      </View>
    );
  }
};

var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'flex-end',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  ok: {
    margin: 5,
    color: '#000000',
    fontSize: 18,
  },
  wheelview: {
    width: SCREEN_WIDTH,
    height: SCREEN_HEIGHT/5*2,
  },
});

AppRegistry.registerComponent('AwesomeProject', () => AwesomeProject);

```


## Reference
https://github.com/weidongjian/androidWheelView

## Run Renderings
![1](/img/1.jpg)
![2](/img/2.jpg)
![3](/img/3.jpg)
