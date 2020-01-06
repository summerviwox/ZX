package com.siweisoft.heavycenter.module.test;

import android.content.Intent;
import android.view.View;
import butterknife.OnClick;
import com.android.lib.util.IntentUtil;
import com.android.lib.util.LogUtil;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppFrag;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends AppFrag<TestUIOpe,TestDAOpe> implements View.OnClickListener{


    @Override
    public void initdelay() {
        super.initdelay();
    }

    @OnClick({R.id.tv_txt})
    public void onClick(View v) {
        IntentUtil.getInstance().photoShowFromphone(this,01);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtil.E("fdfdfdfdfdfd");
    }
}
