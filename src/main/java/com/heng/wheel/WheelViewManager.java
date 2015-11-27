package com.heng.wheel;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

import java.util.ArrayList;


/**
 * Created by heng on 15/11/27.
 */
public class WheelViewManager extends SimpleViewManager<LoopView> {

    public static final String REACT_CLASS = "RCTWheelView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected LoopView createViewInstance(ThemedReactContext reactContext) {
        return new LoopView(reactContext);
    }

    @ReactProp(name = "values")
    public void setItems(LoopView view,ReadableArray values){
        ArrayList<String> items = new ArrayList<>();
        for(int i=0;i<values.size();i++){
            String type = values.getType(i).name();
            if("String".equals(type)){
                items.add(values.getString(i));
            }
        }
        view.setItems(items);
    }

    @ReactProp(name = "isLoop",defaultBoolean = true)
    public void isLoop(LoopView view, boolean isLoop){
        view.isLoop(isLoop);
    }

    @ReactProp(name = "initPosition",defaultInt = 0)
    public void setInitPosition(LoopView view,int initPosition){
        view.setInitPosition(initPosition);
    }

    @ReactProp(name = "textSize",defaultFloat = 16f)
    public void setTextSize(LoopView view, float textSize){
        view.setTextSize(textSize);
    }

}
