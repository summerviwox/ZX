package com.siweisoft.heavycenter.module.test;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.*;
import android.widget.ImageView;

import com.siweisoft.heavycenter.R;

/**
 * Created by lgvalle on 05/09/15.
 */
public class SharedElementFragment1 extends Fragment {

    private static final String EXTRA_SAMPLE = "sample";

    public int iid ;

    public static SharedElementFragment1 newInstance() {

        Bundle args = new Bundle();

        SharedElementFragment1 fragment = new SharedElementFragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postponeEnterTransition();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sharedelement_fragment1, container, false);

        final ImageView squareBlue = (ImageView) view.findViewById(R.id.square_blue);

        view.findViewById(R.id.sample2_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNextFragment( squareBlue, false);
            }
        });

        view.findViewById(R.id.sample2_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNextFragment( squareBlue, true);
            }
        });


        squareBlue.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        squareBlue.getViewTreeObserver().removeOnPreDrawListener(this);
                        startPostponedEnterTransition();
                        return true;
                    }
                });

        return view;
    }

    private void addNextFragment(ImageView squareBlue, boolean overlap) {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            SharedElementFragment2 sharedElementFragment2 = SharedElementFragment2.newInstance();

            Slide slideTransition = new Slide(Gravity.RIGHT);
            slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_medium));

            ChangeBounds changeBoundsTransition = new ChangeBounds();
            changeBoundsTransition.setDuration(getResources().getInteger(R.integer.anim_duration_medium));

            sharedElementFragment2.setEnterTransition(slideTransition);
            sharedElementFragment2.setAllowEnterTransitionOverlap(overlap);
            sharedElementFragment2.setAllowReturnTransitionOverlap(overlap);
            sharedElementFragment2.setSharedElementEnterTransition(changeBoundsTransition);

            getFragmentManager().beginTransaction()
                    .add(iid, sharedElementFragment2)
                    .hide(this)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .addSharedElement(squareBlue, getString(R.string.square_blue_name))
                    .commit();
        }

    }

}
