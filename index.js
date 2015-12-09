var React = require('react-native');

var { NativeModules,requireNativeComponent,PropTypes,View} = React;

var UIManager = NativeModules.UIManager;

var NativeWheelView = requireNativeComponent('RCTWheelView',WheelView);

var WHEELVIEW_REF = 'wheel';

var WheelView = React.createClass({
    propTypes: {
        ...View.propTypes,
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
    previous: function(){
        UIManager.dispatchViewManagerCommand(
            React.findNodeHandle(this.refs.wheel),
            UIManager.RCTWheelView.Commands.previous,
            null,
        );
    },
    next: function(){
        UIManager.dispatchViewManagerCommand(
            React.findNodeHandle(this.refs.wheel),
            UIManager.RCTWheelView.Commands.next,
            null,
        );
    },
    render(){
        return <NativeWheelView {...this.props} onChange={this.handleOnChange} ref={WHEELVIEW_REF}/>;
    }
});

module.exports = WheelView;
