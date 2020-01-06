package com.siweisoft.heavycenter.module.test;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;

import com.siweisoft.heavycenter.R;


public class TransitionActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getEnterTransition().setDuration(getResources().getInteger(R.integer.anim_duration_long));




            Slide slideTransition = new Slide(Gravity.LEFT);
            slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
            // Create fragment and define some of it transitions
            SharedElementFragment1 sharedElementFragment1 = SharedElementFragment1.newInstance();
            sharedElementFragment1.setReenterTransition(slideTransition);
            sharedElementFragment1.setExitTransition(slideTransition);
            sharedElementFragment1.setSharedElementEnterTransition(new ChangeBounds());

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.lll, sharedElementFragment1)
                    .commit();





        }





    }
}
