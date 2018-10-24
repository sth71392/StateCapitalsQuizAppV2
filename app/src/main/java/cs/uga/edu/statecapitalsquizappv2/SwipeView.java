package cs.uga.edu.statecapitalsquizappv2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SwipeView extends FragmentStatePagerAdapter {

    public SwipeView(FragmentManager fragmentManager){
        super (fragmentManager);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragmentManger = new FragmentManagerPage();
        Bundle bundle = new Bundle();
        bundle.putInt("questionNumber", i + 1);
        fragmentManger.setArguments(bundle);

        return fragmentManger;
    }

    @Override
    public int getCount() {
        return 7;
    }

}
