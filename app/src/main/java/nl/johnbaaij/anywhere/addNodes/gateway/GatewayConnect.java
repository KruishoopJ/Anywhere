package nl.johnbaaij.anywhere.addNodes.gateway;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nl.johnbaaij.anywhere.R;

public class GatewayConnect extends Fragment {

    private GatewayConnectViewModel mViewModel;

    public static GatewayConnect newInstance() {
        return new GatewayConnect();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.gateway_connect_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GatewayConnectViewModel.class);
        // TODO: Use the ViewModel
    }

}
