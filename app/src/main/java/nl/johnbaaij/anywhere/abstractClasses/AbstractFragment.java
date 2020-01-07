package nl.johnbaaij.anywhere.abstractClasses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public abstract class AbstractFragment extends Fragment {

    protected void setToolbarTitle(String title) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);

    }



}
