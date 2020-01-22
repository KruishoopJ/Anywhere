package nl.johnbaaij.anywhere.addNodes;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LightConfigActivityTest {

    @Rule
    public ActivityTestRule<LightConfigActivity> mActivityTestRule = new ActivityTestRule<LightConfigActivity>(LightConfigActivity.class);

    private LightConfigActivity mActivity = null;


    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testLaunch(){

        assertNotNull(mActivity.authencicate());
    }

    @Test
    public void checkObject(){
        ArrayList<String> test= new ArrayList<>();
        assertNotNull(mActivity.createGroup("name", "hallo", test,true, true, true));
    }
}