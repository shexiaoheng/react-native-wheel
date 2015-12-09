var React = require('react-native');

var {NativeModules,requireNativeComponent,PropTypes} = React;

var RCTUIManager = NativeModules.UIManager;

var WheelView = React.createClass({

    propTypes: {
        onItemChange: PropTypes.func,
        values: PropTypes.array,
        isLoop: PropTypes.bool,
        selectedIndex: PropTypes.number,
        textSize: PropTypes.number,
    },
    previous: function(){
        RCTUIManager.dispatchViewManagerCommand(
            React.findNodeHandle(this),
            RCTUIManager.RCTWheelView.Commands.previous,
            null,
        );
    },
    next: function(){
        RCTUIManager.dispatchViewManagerCommand(
            React.findNodeHandle(this),
            RCTUIManager.RCTWheelView.Commands.next,
            null,
        );
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