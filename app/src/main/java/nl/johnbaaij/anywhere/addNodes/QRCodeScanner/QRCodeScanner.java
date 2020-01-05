package nl.johnbaaij.anywhere.addNodes.QRCodeScanner;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.vision.CameraSource;

import nl.johnbaaij.anywhere.R;

public class QRCodeScanner extends Fragment {

    private QrcodeScannerViewModel mViewModel;

    public static QRCodeScanner newInstance() {
        return new QRCodeScanner();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.qrcode_scanner_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(QrcodeScannerViewModel.class);
        // TODO: Use the ViewModel
    }

}
