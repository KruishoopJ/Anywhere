package nl.johnbaaij.anywhere.addNodes.gateway;

/*

Dit fragment faked het zoeken naar een gateway door middel van een timer
Als deze timer afloopt wordt de buttom beschikbaar om naar het volgende scherm te gaan.

Auteur: John Baaij
*/


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.Timer;
import java.util.TimerTask;

import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.addNodes.QRCodeScannerActivity;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class GatewayConnect extends Fragment {

    // Declare globally
    private int position = -1;
    private int countGatewayAnimations = 0;
    ImageView MyImageView;
    Timer mTimer = new Timer();
    int[] imageArray = { R.drawable.gateway, R.drawable.gateway_zend };
    Button button;

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

        button = root.findViewById(R.id.buttonProgress);
        button.setEnabled(false);


        // TODO: add delay to mock internet connection setup

        // Set image view
        MyImageView = root.findViewById(R.id.gatewayImage);

        /**
        * This timer will call each of the seconds.
        **/
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
//                // Timer is not a Main/UI thread need to do all UI task on runOnUiThread
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run()
                    {
                        // increase your position
                        position++;
                        countGatewayAnimations ++;
                        if (position >= imageArray.length) {
                            position = 0;
                        }

                        if (countGatewayAnimations == 5)
                        {
                            //Cancel and purge timer so code doesn't continue in QR-Code scanner
                            mTimer.cancel();
                            mTimer.purge();
                            button.setEnabled(true);
                            button.setCompoundDrawablesWithIntrinsicBounds( null, null, getActivity().getDrawable(R.drawable.ic_arrow_forward_white_24dp) ,null);

                            Toast toast = Toast.makeText(getContext(),"Connection found", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, -180);
                            toast.show();
                        }
                        //Set text and image
                        MyImageView.setImageResource(imageArray[position]);
                    }
                });
            }
        }, 0, 1000);


        return root;
    }

    public void onStart() {
        super.onStart();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Gateway connect called");
                //Cancel and purge timer so code doesn't continue in QR-Code scanner
                mTimer.cancel();
                mTimer.purge();
                openQrCodeScanner();
            }
        });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
