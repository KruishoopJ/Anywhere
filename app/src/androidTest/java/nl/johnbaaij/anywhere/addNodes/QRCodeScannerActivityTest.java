package nl.johnbaaij.anywhere.addNodes;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import nl.johnbaaij.anywhere.MainToolbarActivity;
import nl.johnbaaij.anywhere.R;

import static org.junit.Assert.*;

public class QRCodeScannerActivityTest {

    @Rule
    public ActivityTestRule<QRCodeScannerActivity> mActivityTestRule = new ActivityTestRule<QRCodeScannerActivity>(QRCodeScannerActivity.class);

    private QRCodeScannerActivity mActivity = null;




    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testLaunch(){

    }

    @Test
    public void nodeConfirmed() {
        assertTrue(mActivity.nodeConfirmed("hallo"));
    }

    @Test
    public void checkValid(){

    }
}