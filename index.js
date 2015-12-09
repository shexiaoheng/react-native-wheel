var React = require('react-native');

var {requireNativeComponent,PropTypes} = React;

var WheelView = React.createClass({

    propTypes: {
        onItemChange: PropTypes.func,
        values: PropTypes.array,
        isLoop: PropTypes.bool,
        selectedIndex: PropTypes.number,
        textSize: PropTypes.number,
    },
    handleOnChange(event){
        if(this.props.onItemChange){
            this.props.onItemChange(event.nativeEvent.index);
        }
    },
    render(){
        return(
            <NativeWheelView
                {...this.props}
                onChange = {this.handleOnChange}
            />
        );
    },
});

var NativeWheelView = requireNativeComponent('RCTWheelView',WheelView);

module.exports = WheelView;