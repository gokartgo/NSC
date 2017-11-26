package com.gokartgiftmind.nsc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gokartgiftmind.nsc.R;
import com.gokartgiftmind.nsc.util.ValueUserTravelListView;



@SuppressWarnings("unused")
public class StatusUserMainFragment extends Fragment {

    public interface StatusUserMainFragmentListener{
        void onButtonClick();
    }

    ValueUserTravelListView valueUser;
    TextView tvLocation;
    TextView tvDestination;
    TextView tvTime;
    TextView tvSeat;
    Button btnJoin;
    int seat;

    public StatusUserMainFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static StatusUserMainFragment newInstance(ValueUserTravelListView valueUser) {
        StatusUserMainFragment fragment = new StatusUserMainFragment();
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
        View rootView = inflater.inflate(R.layout.status_user_main_fragment, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        tvLocation = (TextView) rootView.findViewById(R.id.tvLocation);
        tvDestination = (TextView) rootView.findViewById(R.id.tvDestination);
        tvTime = (TextView) rootView.findViewById(R.id.tvTime);
        tvSeat = (TextView) rootView.findViewById(R.id.tvSeat);
        btnJoin = (Button) rootView.findViewById(R.id.btnJoin);

        tvLocation.setText(valueUser.getLocationText());
        tvDestination.setText(valueUser.getDestination());
        tvTime.setText(valueUser.getTimeText());
        tvSeat.setText(valueUser.getSeatText());
        btnJoin.setOnClickListener(buttonOnClick);
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

    /***************
     * Listener Zone
     ***************/

    View.OnClickListener buttonOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view == btnJoin){
                StatusUserMainFragmentListener fragmentListener =
                        (StatusUserMainFragmentListener) getActivity();
                fragmentListener.onButtonClick();
            }
        }
    };

}
