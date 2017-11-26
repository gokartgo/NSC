package com.gokartgiftmind.nsc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gokartgiftmind.nsc.R;
import com.gokartgiftmind.nsc.adapter.UserNameListAdapter;
import com.gokartgiftmind.nsc.util.ValueUserTravelListView;


@SuppressWarnings("unused")
public class StatusUserNameMainFragment extends Fragment {

    ValueUserTravelListView valueUser;
    ListView listView;
    UserNameListAdapter listAdapter;
    int seat;

    public StatusUserNameMainFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static StatusUserNameMainFragment newInstance(ValueUserTravelListView valueUser) {
        StatusUserNameMainFragment fragment = new StatusUserNameMainFragment();
        Bundle args = new Bundle();
        args.putParcelable("valueUser",valueUser);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        valueUser = getArguments().getParcelable("valueUser");

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.status_another_user_main_fragment, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        listView = (ListView) rootView.findViewById(R.id.listView);
        listAdapter = new UserNameListAdapter();
        listAdapter.setCount(3-valueUser.getNumberSeat());
        listView.setAdapter(listAdapter);

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
    }

}
