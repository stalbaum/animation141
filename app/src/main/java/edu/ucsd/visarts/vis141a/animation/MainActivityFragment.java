package edu.ucsd.visarts.vis141a.animation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;


/**
 * Fragment where the action is
 */
public class MainActivityFragment extends Fragment {

    private AbstractView abView = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout v =  (RelativeLayout)inflater.inflate(R.layout.fragment_main, container, false);
        abView = new ConcreteSampleView(getActivity()); // for testing, change this to your own concrete subclass of AbstractView
        v.addView(abView);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(
                getActivity(),
                abView.getName() + "\n" + abView.getTitle() + "\n" + abView.getDescription(),
                Toast.LENGTH_LONG)
                .show();
        abView.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        abView.stop();
    }
}
