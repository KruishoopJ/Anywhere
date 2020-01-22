package nl.johnbaaij.anywhere.main.nodes;


/*

Created by android studio
*/

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NodeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NodeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}