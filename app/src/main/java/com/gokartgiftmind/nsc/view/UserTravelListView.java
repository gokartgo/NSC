package com.gokartgiftmind.nsc.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;


import com.gokartgiftmind.nsc.R;
import com.inthecheesefactory.thecheeselibrary.view.BaseCustomViewGroup;
import com.inthecheesefactory.thecheeselibrary.view.state.BundleSavedState;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class UserTravelListView extends BaseCustomViewGroup {

    TextView tvLocation;
    TextView tvDestination;
    TextView tvTime;
    TextView tvSeat;
    int seat;

    public UserTravelListView(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public UserTravelListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public UserTravelListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public UserTravelListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.user_travel, this);
    }

    private void initInstances() {
        // findViewById here
        tvLocation = (TextView) findViewById(R.id.tvLocation);
        tvDestination = (TextView) findViewById(R.id.tvDestination);
        tvSeat = (TextView) findViewById(R.id.tvSeat);
        tvTime = (TextView) findViewById(R.id.tvTime);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        /*
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.StyleableName,
                defStyleAttr, defStyleRes);

        try {

        } finally {
            a.recycle();
        }
        */
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

    public void setTvLocationText(String text){
        tvLocation.setText(text);
    }

    public String getTvLocationText(){
        return tvLocation.getText().toString();
    }

    public void setTvDestination(String text) {
        tvDestination.setText(text);
    }

    public String getTvDestination() {
        return tvDestination.getText().toString();
    }

    public void setTvTimeText(String text){
        tvTime.setText(text);
    }

    public String getTvTimeText(){
        return tvTime.getText().toString();
    }

    public void setTvSeatText(String text){
        tvSeat.setText(text);
    }

    public String getTvSeatText(){
        return tvSeat.getText().toString();
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getSeat() {
        return seat;
    }

}
