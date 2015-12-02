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
        previous: PropTypes.func,
        next: PropTypes.func,
        getSelectedItem: PropTypes.func,
        getSelectedIndex: PropTypes.func,
    },
};

var NativeWheelView = requireNativeComponent('RCTWheelView',iface);

var MyWheelView = React.createClass({

    handleOnChange(event){
        if(this.props.onItemChange){
            this.props.onItemChange(event.nativeEvent.index);
        }
        if(this.props.previous){
            this.props.previous();
        }
        if(this.props.next){
            this.props.next();
        }
        if(this.props.getSelectedItem){
            this.props.getSelectedItem();
        }
        if(this.props.getSelectedIndex){
            this.props.getSelectedIndex();
        }
    },
    render(){
        return <NativeWheelView {...this.props} onChange = {this.handleOnChange} />;
    }
});

module.exports = MyWheelView;