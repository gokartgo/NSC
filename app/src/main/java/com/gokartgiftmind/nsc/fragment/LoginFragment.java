package com.gokartgiftmind.nsc.fragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gokartgiftmind.nsc.R;
import com.gokartgiftmind.nsc.activity.MainActivity;
import com.gokartgiftmind.nsc.manager.DatabaseUser;


@SuppressWarnings("unused")
public class LoginFragment extends Fragment{


    public interface FragmentListener{
        void onButtonLoginClick();
    }

    Button btnLogin;
    Button btnRegister;
    EditText edUsername;
    EditText edPassword;
    DatabaseUser databaseUser;
    SQLiteDatabase database;
    Cursor cursor;

    public LoginFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        edUsername = (EditText) rootView.findViewById(R.id.edUsername);
        edPassword = (EditText) rootView.findViewById(R.id.edPassword);
        btnLogin = (Button) rootView.findViewById(R.id.btnLogin);
        databaseUser = new DatabaseUser(getContext());
        database = databaseUser.getReadableDatabase();
        btnLogin.setOnClickListener(buttonClick);
        btnRegister = (Button) rootView.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(buttonClick);
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

    final View.OnClickListener buttonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view == btnLogin){
                checkUser();
            }
            if(view == btnRegister){
                getFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer,RegisterFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        }
    };

    private void checkUser() {
        String sql = "SELECT * FROM user WHERE username = " + "'"+edUsername.getText().toString()+"'"
                + " AND password = " +"'"+edPassword.getText().toString()+"'";
        cursor = database.rawQuery(sql,null);
        if (cursor.moveToNext()) {
            FragmentListener listener = (FragmentListener) getActivity();
            listener.onButtonLoginClick();
        }
        else{
            Toast.makeText(getContext(),"Username or Password not true",Toast.LENGTH_SHORT).show();
        }
    }

}
