package com.gokartgiftmind.nsc.util;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ASUS-PC on 7/11/2560.
 */

public class ValueUserTravelListView implements Parcelable{
    private String location,destination,time,seat;
    private int numberSeat;

    public ValueUserTravelListView(){

    }

    protected ValueUserTravelListView(Parcel in) {
        location = in.readString();
        destination = in.readString();
        time = in.readString();
        seat = in.readString();
        numberSeat = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(location);
        dest.writeString(destination);
        dest.writeString(time);
        dest.writeString(seat);
        dest.writeInt(numberSeat);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ValueUserTravelListView> CREATOR = new Creator<ValueUserTravelListView>() {
        @Override
        public ValueUserTravelListView createFromParcel(Parcel in) {
            return new ValueUserTravelListView(in);
        }

        @Override
        public ValueUserTravelListView[] newArray(int size) {
            return new ValueUserTravelListView[size];
        }
    };

    public void setLocationText(String text){
        location=text;
    }

    public String getLocationText(){
        return location;
    }

    public void setDestination(String text) { destination=text; }

    public String getDestination() { return destination; }

    public void setTimeText(String text){
        time=text;
    }

    public String getTimeText(){
        return time;
    }

    public void setSeatText(String text){
        seat=text;
    }

    public String getSeatText(){
        return seat;
    }

    public void setNumberSeat(int numberSeat){
        this.numberSeat = numberSeat;
    }

    public int getNumberSeat(){
        return numberSeat;
    }
}
