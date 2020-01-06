package com.siweisoft.heavycenter.module.acct.role;

//by summer on 2017-12-18.

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.lib.util.fragment.two.FragManager2;
import com.siweisoft.heavycenter.R;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.data.netd.user.usertype.UserTypeReqBean;
import com.siweisoft.heavycenter.databinding.FragAcctRoleBinding;
import com.siweisoft.heavycenter.module.acct.acct.AcctAct;
import com.siweisoft.heavycenter.module.view.center.DiaLogCenterFrag;

public class RoleUIOpe extends AppUIOpe<FragAcctRoleBinding> {

    UserTypeReqBean userTypeReqBean = new UserTypeReqBean();



    public void showTip(boolean dirver,View.OnClickListener onClickListener){
        DiaLogCenterFrag diaLogCenterFrag = new DiaLogCenterFrag();
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.frag_acct_role_tip,null);
        TextView textView = view.findViewById(R.id.tv_type);
        if(dirver){
            textView.setText("驾驶员");
        }else{
            textView.setText("非驾驶员");
        }
        diaLogCenterFrag.setCustomView(view);
        diaLogCenterFrag.setOnClickListener(onClickListener,R.id.tv_sure,R.id.tv_close);
        FragManager2.getInstance().setStartAnim(R.anim.fade_in,R.anim.fade_out,R.anim.fade_in,R.anim.fade_out).setFinishAnim(R.anim.fade_in,R.anim.fade_out).start(getActivity(),AcctAct.账号,AcctAct.账号界面根布局,diaLogCenterFrag);
    }

    public UserTypeReqBean getUserTypeReqBean() {
        //userTypeReqBean.setId(LocalValue.get登录返回信息());
        return userTypeReqBean;
    }
}
