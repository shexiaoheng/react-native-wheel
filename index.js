var React = require('react-native');

var { NativeModules,requireNativeComponent,PropTypes} = React;

var iface = {
    name: 'RCTWheelView',
    propTypes: {
        onItemChange: PropTypes.func,
        values: PropTypes.array,
        isLoop: PropTypes.bool,
        initPosition: PropTypes.number,
        textSize: PropTypes.number,
    },
};

var NativeWheelView = requireNativeComponent('RCTWheelView',iface);

var MyWheelView = React.createClass({

    handleOnChange(event){
        if(this.props.onItemChange){
            this.props.onItemChange(event.nativeEvent.index);
        }
    },
    render(){
        return <NativeWheelView {...this.props} onChange = {this.handleOnChange} />;
    }
});

module.exports = MyWheelView;