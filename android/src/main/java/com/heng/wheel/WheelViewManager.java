package com.heng.wheel;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.ArrayList;

/**
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
    public void setItems(LoopView view, ReadableArray values) {
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            String type = values.getType(i).name();
            switch (type) {
                case "Boolean":
                    items.add(String.valueOf(values.getBoolean(i)));
                    break;
                case "Number":
                    try {
                        items.add(String.valueOf(values.getInt(i)));
                    } catch (Exception e) {
                        items.add(String.valueOf(values.getDouble(i)));
                    }
                    break;
                case "String":
                    items.add(values.getString(i));
                    break;
            }
        }
        view.setItems(items);
    }

    @ReactProp(name = "isLoop")
    public void isLoop(LoopView view, boolean isLoop) {
        view.isLoop(isLoop);
    }

    @ReactProp(name = "itemsVisible")
    public void setItemsVisible(LoopView view, int itemsVisible) {
        view.setItemsVisible(itemsVisible);
    }

    @ReactProp(name = "velocityFling")
    public void setVelocityFling(LoopView view, int velocityFling) {
        view.setVelocityFling(velocityFling);
    }

    @ReactProp(name = "selectedIndex")
    public void setSelectedIndex(LoopView view, int selectedIndex) {
        view.setSelectedIndex(selectedIndex);
    }

    @ReactProp(name = "textSize", defaultFloat = 16f)
    public void setTextSize(LoopView view, float textSize) {
        view.setTextSize(textSize);
    }

    @ReactProp(name = "onItemChange", defaultBoolean = true)
    public void setOnItemChange(final LoopView view, Boolean value) {
        view.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                view.onReceiveNativeEvent(index);
            }
        });
    }
}
