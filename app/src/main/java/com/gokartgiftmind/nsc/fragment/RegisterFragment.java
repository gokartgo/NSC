package com.gokartgiftmind.nsc.fragment;

import android.content.ContentValues;
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
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gokartgiftmind.nsc.R;
import com.gokartgiftmind.nsc.manager.DatabaseUser;


@SuppressWarnings("unused")
public class RegisterFragment extends Fragment {

    EditText edName,edSurname,edEmail,edStudentId,edMobile,edUsername,edPassword,edRePassword;
    RadioGroup rgSex;
    Button btnRegisterOk;
    DatabaseUser databaseUser;
    SQLiteDatabase database;
    Cursor cursor;

    public RegisterFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_register, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        edName = (EditText) rootView.findViewById(R.id.edName);
        edSurname = (EditText) rootView.findViewById(R.id.edSurname);
        edEmail = (EditText) rootView.findViewById(R.id.edEmail);
        edStudentId = (EditText) rootView.findViewById(R.id.edStudentId);
        edMobile = (EditText) rootView.findViewById(R.id.edMobile);
        edUsername = (EditText) rootView.findViewById(R.id.edUsername);
        edPassword = (EditText) rootView.findViewById(R.id.edPassword);
        edRePassword = (EditText) rootView.findViewById(R.id.edRePassword);
        rgSex = (RadioGroup) rootView.findViewById(R.id.rgSex);
        btnRegisterOk = (Button) rootView.findViewById(R.id.btnRegisterOk);
        databaseUser = new DatabaseUser(getContext());
        database = databaseUser.getWritableDatabase();
        btnRegisterOk.setOnClickListener(buttonClickRegister);
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

    final View.OnClickListener buttonClickRegister = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view == btnRegisterOk){
                // button to register
                addUser();
            }
        }
    };

    private void addUser() {
        String sex = "";
        switch (rgSex.getCheckedRadioButtonId()){
            case R.id.rbMale : sex = "ชาย";
                break;
            case R.id.rbFemale : sex = "หญิง";
                break;
            default: break;
        }

        if(edName.length()>0&&edSurname.length()>0
                &&edEmail.length()>0 &&edStudentId.length()>0
                &&edMobile.length()>0 &&edUsername.length()>0
                &&edPassword.length()>0&&edRePassword.length()>0){
            if(edPassword.getText().toString().equals(edRePassword.getText().toString()) ) {
                String sql = "SELECT username,password FROM user WHERE username = " + "'"+edUsername.getText().toString()+"'"
                        + " OR password = " +"'"+edPassword.getText().toString()+"'";
                cursor = database.rawQuery(sql, null);
                if (!cursor.moveToNext()) {
                    ContentValues values = new ContentValues();
                    values.put("name", edName.getText().toString());
                    values.put("surname", edSurname.getText().toString());
                    values.put("sex", sex);
                    values.put("email", edEmail.getText().toString());
                    values.put("idStudent", edStudentId.getText().toString());
                    values.put("mobile", edMobile.getText().toString());
                    values.put("username", edUsername.getText().toString());
                    values.put("password", edPassword.getText().toString());
                    database.insert("user", null, values);
                    Toast.makeText(getContext(), "Register Complete", Toast.LENGTH_SHORT).show();
                    getFragmentManager().popBackStack();
                }
                else{
                    Toast.makeText(getContext(), "Username or Password Already use", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(getContext(),"Password Not Match",Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getContext(), "Please Input Data", Toast.LENGTH_SHORT).show();
        }

    }
}
