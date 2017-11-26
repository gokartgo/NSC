package com.gokartgiftmind.nsc.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.gokartgiftmind.nsc.view.UserName;
import com.gokartgiftmind.nsc.view.UserTravelListView;

import java.util.Random;

/**
 * Created by ASUS-PC on 2/11/2560.
 */

public class UserNameListAdapter extends BaseAdapter {

    int count = 0;

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
        UserName item;
        if(convertView != null){
            item = (UserName) convertView;
        }
        else{
            item = new UserName(parent.getContext());
        }

        return item;
    }
}
