package com.gokartgiftmind.nsc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gokartgiftmind.nsc.R;
import com.gokartgiftmind.nsc.util.ValueUserTravelListView;
import com.inthecheesefactory.thecheeselibrary.view.SlidingTabLayout;


@SuppressWarnings("unused")
public class StatusUserFragment extends Fragment {

    ValueUserTravelListView valueUser;
    ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;

    public StatusUserFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static StatusUserFragment newInstance(ValueUserTravelListView valueUser) {
        StatusUserFragment fragment = new StatusUserFragment();
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
        View rootView = inflater.inflate(R.layout.status_user_fragment, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0 :
                        return StatusUserMainFragment.newInstance(valueUser);
                    case 1 :
                        return StatusUserNameMainFragment.newInstance(valueUser);
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {

                switch(position){
                    case 0:
                        return "User";
                    case 1:
                        return "Another";
                    default:
                        return null;
                }
            }
        });

        slidingTabLayout = (SlidingTabLayout) rootView.findViewById(R.id.slidingTabLayout);
        slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return 0xff00b5b7; // set color indicator
            }
        });
        slidingTabLayout.setViewPager(viewPager);
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
