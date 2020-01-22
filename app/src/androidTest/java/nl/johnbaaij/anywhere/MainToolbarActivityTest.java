package nl.johnbaaij.anywhere;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainToolbarActivityTest {

    @Rule
    public ActivityTestRule<MainToolbarActivity> mActivityTestRule = new ActivityTestRule<MainToolbarActivity>(MainToolbarActivity.class);

    private MainToolbarActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        View view = mActivity.findViewById(R.id.nav_view);

        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
    }
}