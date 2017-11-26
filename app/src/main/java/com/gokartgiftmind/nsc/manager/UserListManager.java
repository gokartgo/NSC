package com.gokartgiftmind.nsc.manager;

import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class UserListManager {

    private static UserListManager instance;

    public static UserListManager getInstance() {
        if (instance == null)
            instance = new UserListManager();
        return instance;
    }

    private Context mContext;

    private UserListManager() {
        mContext = Contextor.getInstance().getContext();
    }

}
