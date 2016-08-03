import React,{
    Component,
    PropTypes
} from 'react';

import ReactNative,{
    requireNativeComponent
} from 'react-native';


let NativeWheelView = requireNativeComponent('RCTWheelView',WheelView);


export default class WheelView extends React.Component{
    static propTypes = {
        onItemChange: PropTypes.func,
        values: PropTypes.array,
        isLoop: PropTypes.bool,
        selectedIndex: PropTypes.number,
        textSize: PropTypes.number,
        itemsVisible: PropTypes.number,
        velocityFling: PropTypes.number,
    };

    _onItemChange(event) {
        if(this.props.onItemChange){
            this.props.onItemChange(event.nativeEvent.index);
        }
    };

    render(){
        return <NativeWheelView {...this.props} onChange={this._onItemChange.bind(this)} />;
    }
};

