package com.gokartgiftmind.nsc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gokartgiftmind.nsc.R;
import com.gokartgiftmind.nsc.fragment.LoginFragment;
import com.gokartgiftmind.nsc.fragment.MainFragment;



public class LoginRegisterActivity extends AppCompatActivity implements LoginFragment.FragmentListener{

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        initInstance();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, LoginFragment.newInstance(),"LoginFragment")
                    .commit();
        }
    }

    private void initInstance() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onButtonLoginClick() {
        Intent intent = new Intent(LoginRegisterActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
