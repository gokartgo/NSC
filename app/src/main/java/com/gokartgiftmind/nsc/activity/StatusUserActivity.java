package com.gokartgiftmind.nsc.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.gokartgiftmind.nsc.R;
import com.gokartgiftmind.nsc.fragment.StatusUserFragment;
import com.gokartgiftmind.nsc.fragment.StatusUserMainFragment;
import com.gokartgiftmind.nsc.util.ValueUserTravelListView;

public class StatusUserActivity extends AppCompatActivity implements StatusUserMainFragment.StatusUserMainFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_user);

        ValueUserTravelListView valueUser = getIntent().getParcelableExtra("valueUser");

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, StatusUserFragment.newInstance(valueUser),"StatusUserFragment")
                    .commit();
        }

    }


    @Override
    public void onButtonClick() {
        finish();
        Toast.makeText(StatusUserActivity.this,"Thank You",Toast.LENGTH_SHORT).show();
    }
}
