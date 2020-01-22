package nl.johnbaaij.anywhere.abstractClasses;

/*
Dit fragment vervangt de standaard fragment Fragment

Er word gebruik gemaakt van een custom toolbar die hierin wordt gedefineerd
Auteur: John Baaij
*/

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public abstract class AbstractFragment extends Fragment {

    protected void setToolbarTitle(String title) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);

    }


}
