package com.heng.wheel;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.util.ArrayList;


/**
 * Created by heng on 15/11/27.
 * Edited by heng on 15/12/03
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

    @ReactProp(name = "selectedIndex",defaultInt = 0)
    public void setSelectedIndex(LoopView view,int selectedIndex){
        view.setSelectedIndex(selectedIndex);
    }

    @ReactProp(name = "textSize",defaultFloat = 16f)
    public void setTextSize(LoopView view, float textSize){
        view.setTextSize(textSize);
    }

    @ReactProp(name = "onItemChange", defaultBoolean = true)
    public void setOnItemChange(final LoopView view, Boolean value) {
        view.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                WritableMap event = Arguments.createMap();
                event.putInt("index", index);
                ReactContext reactContext = (ReactContext) view.getContext();
                reactContext.getJSModule(RCTEventEmitter.class)
                        .receiveEvent(view.getId(), "topChange", event);
            }
        });
    }

}
