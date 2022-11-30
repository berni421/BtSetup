package com.elbourn.android.btsetup;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class BtSetupFragment extends Fragment {

    static String APP = BuildConfig.APPLICATION_ID;
    static String TAG = Fragment.class.getSimpleName();
    View view = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_btsetup, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "start onViewCreated");
        startBtSetup(view);
        Log.i(TAG, "end onViewCreated");
    }

    void startBtSetup(View view) {
        TextView textView = view.findViewById(R.id.textview01);
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            textView.setText("Missing bluetooth device.");
            return;
        }
        Intent intentBluetooth = new Intent();
        intentBluetooth.setAction(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
        startActivity(intentBluetooth);
        Intent intent = new Intent(getActivity(), MainActivity.class);
        getActivity().finish();
    }
}
