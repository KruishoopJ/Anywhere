package nl.johnbaaij.anywhere.main.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import nl.johnbaaij.anywhere.AddNodesActivity;
import nl.johnbaaij.anywhere.QRCodeScannerActivity;
import nl.johnbaaij.anywhere.R;
import nl.johnbaaij.anywhere.addNodes.QRCodeScanner.QRCodeScanner;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class DashboardFragment extends Fragment implements View.OnClickListener{

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        super.onCreate(savedInstanceState);

        Button qrCodeButton = root.findViewById(R.id.buttonQrCode);
        qrCodeButton.setText("QR scanner");
        qrCodeButton.setOnClickListener(this);

        final Button button = root.findViewById(R.id.buttonDashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                button.setText(R.string.app_name);
            }
        });
        return root;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.buttonQrCode: {
                openQrCodeScanner();
                break;
            }
        }
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