package com.gokartgiftmind.nsc.fragment;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.gokartgiftmind.nsc.MainApplication;
import com.gokartgiftmind.nsc.R;
import com.gokartgiftmind.nsc.adapter.FriendListAdapter;
import com.gokartgiftmind.nsc.view.UserTravelListView;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;
import com.kbeanie.multipicker.api.ImagePicker;
import com.kbeanie.multipicker.api.Picker;
import com.kbeanie.multipicker.api.callbacks.ImagePickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenImage;

import java.io.File;
import java.util.List;
import java.util.Random;



@SuppressWarnings("unused")
public class MainFragment extends Fragment {

    public interface MainFragmentListener{
        void onUserItemClick(UserTravelListView view);
    }

    private final int SELECTED_PICTURE = 0;
    ImageView ivProfile;
    ImagePicker imagePicker;
    ImagePickerCallback imagePickerCallback;

    ListView listView;
    FriendListAdapter listAdapter;
    Button btnSearch;
    EditText edStart;
    EditText edDestination;



    public MainFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        ivProfile = (ImageView) rootView.findViewById(R.id.ivProfile);
        edStart = (EditText) rootView.findViewById(R.id.edStart);
        edDestination = (EditText) rootView.findViewById(R.id.edDestination);
        btnSearch = (Button) rootView.findViewById(R.id.btnSearch);
        ivProfile.setOnClickListener(buttonClick);
        btnSearch.setOnClickListener(buttonClick);
        listView = (ListView) rootView.findViewById(R.id.listView);
        listAdapter = new FriendListAdapter();
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(listViewItemClickListener);

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

    final AdapterView.OnItemClickListener listViewItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            UserTravelListView item = (UserTravelListView) view;
            MainFragmentListener fragmentlistener = (MainFragmentListener) getActivity();
            fragmentlistener.onUserItemClick(item);
        }
    };

    final View.OnClickListener buttonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view == ivProfile){
                imagePicker = new ImagePicker(MainFragment.this);
                imagePicker.setImagePickerCallback(new ImagePickerCallback() {
                    @Override
                    public void onImagesChosen(List<ChosenImage> list) {
                        // get path and create file.
                        String path = list.get(0).getOriginalPath();
                        Uri uri = Uri.parse(path);
                         File file = new File(path);
                        // convert file to bitmap and set to imageView.
                        if(file.exists()){
                            Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                            ivProfile.setImageBitmap(myBitmap);
                        }
                    }

                    @Override
                    public void onError(String s) {
                        // Do error handling
                    }
                });

                imagePicker.pickImage();
            }

            if(view == btnSearch){
                String start = edStart.getText().toString();
                String destination = edDestination.getText().toString();
                if(!(start.isEmpty()||destination.isEmpty())) {
                    Random rand = new Random();
                    int count = rand.nextInt(50) + 1;
                    listAdapter.setCount(count);
                    listAdapter.setStart(edStart.getText().toString());
                    listAdapter.setDestination(edDestination.getText().toString());
                    Toast.makeText(getActivity(), "find " + count + " people", Toast.LENGTH_SHORT).show();
                    listAdapter.notifyDataSetChanged();
                    listView.setSelectionFromTop(0, 0);
                }
                else{
                    Toast.makeText(getContext(),"Please input Start or Destination",Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == Picker.PICK_IMAGE_DEVICE) {
                if(imagePicker == null) {
                    imagePicker = new ImagePicker(MainFragment.this);
                    imagePicker.setImagePickerCallback(imagePickerCallback);
                }
                imagePicker.submit(data);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}
