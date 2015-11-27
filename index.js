var React = require('react-native');

var { requireNativeComponent,PropTypes} = React;

var NativeWheelView = requireNativeComponent('RCTWheelView',iface);

var iface = {
    values: PropTypes.array,
    isLoop: PropTypes.boolean,
    initPosition: PropTypes.number,
    textSize: PropTypes.float,
}