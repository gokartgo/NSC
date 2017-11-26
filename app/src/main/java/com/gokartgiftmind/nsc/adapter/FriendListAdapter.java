package com.gokartgiftmind.nsc.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.gokartgiftmind.nsc.view.UserTravelListView;

import java.util.Random;

/**
 * Created by ASUS-PC on 2/11/2560.
 */

public class FriendListAdapter extends BaseAdapter {

    private int count = 0;
    private String start = "";
    private String destination = "";

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserTravelListView item;
        if(convertView != null){
            item = (UserTravelListView) convertView;
        }
        else{
            item = new UserTravelListView(parent.getContext());
        }

        item.setTvLocationText(start);
        item.setTvDestination(destination);
        item = setTime(item);
        item = setSeat(item);
        return item;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    private UserTravelListView setTime(UserTravelListView item) {
        int hour,minute;
        String time;
        Random rand = new Random();
        hour = rand.nextInt(24);
        minute = rand.nextInt(4)*15;
        if(hour<10 && minute<10){
            time = "0"+hour+" : "+"0"+minute;
        }
        else if(minute < 10){
            time = hour+" : "+"0"+minute;
        }
        else if(hour<10){
            time = "0"+hour+" : "+minute;
        }
        else{
            time = hour+" : "+minute;
        }
        item.setTvTimeText(time);
        return item;
    }

    public UserTravelListView setSeat(UserTravelListView item) {
        int numberUser;
        String seat;
        Random rand = new Random();
        numberUser = rand.nextInt(3)+1;
        seat = "Remain "+numberUser+" Seat";
        item.setSeat(numberUser);
        item.setTvSeatText(seat);
        return item;
    }

}
