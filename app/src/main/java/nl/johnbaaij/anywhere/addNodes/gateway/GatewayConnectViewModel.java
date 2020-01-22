package nl.johnbaaij.anywhere.addNodes.gateway;

/*

Gemaakt door Android studio
*/


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GatewayConnectViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<String> mText;

   public GatewayConnectViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");

    }



    public LiveData<String> getText() {
        return mText;
    }

}
