package nl.johnbaaij.anywhere.addNodes.gateway;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import nl.johnbaaij.anywhere.addNodes.QRCodeScannerActivity;
import nl.johnbaaij.anywhere.R;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class GatewayConnect extends Fragment {

    private GatewayConnectViewModel mViewModel;





    public static GatewayConnect newInstance() {
        return new GatewayConnect();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel =
                ViewModelProviders.of(this).get(GatewayConnectViewModel.class);

        View root = inflater.inflate(R.layout.gateway_connect_fragment, container, false);

        final Button button = root.findViewById(R.id.buttonProgress);
        button.setText("Connection found");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Gateway connect called");
                openQrCodeScanner();

            }
        });



        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GatewayConnectViewModel.class);
        // TODO: Use the ViewModel
    }

    private void openQrCodeScanner(){
        // TODO: build universal method with paramater -> class
        Log.d(TAG, "openQrScanner called");
        Intent intent = new Intent(getActivity(), QRCodeScannerActivity.class);
        Log.d(TAG, "created intent");
        startActivity(intent);
        Log.d(TAG, "Started intent");
    }




}
