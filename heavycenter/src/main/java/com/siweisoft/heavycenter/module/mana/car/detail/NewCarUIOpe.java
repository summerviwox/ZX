package com.siweisoft.heavycenter.module.mana.car.detail;

//by summer on 2018-03-14.

import android.view.View;

import com.android.lib.util.StringUtil;
import com.siweisoft.heavycenter.base.AppUIOpe;
import com.siweisoft.heavycenter.databinding.FragManaCarDetailBinding;

public class NewCarUIOpe extends AppUIOpe{

    FragManaCarDetailBinding fragManaCarDetailBinding;
        @Override
        public void initUI() {
        super.initUI();
        fragManaCarDetailBinding = (FragManaCarDetailBinding) bind;
    }

    public void init(String type){
        fragManaCarDetailBinding.content.setVisibility(View.INVISIBLE);
        fragManaCarDetailBinding.bindcartip.setVisibility(View.GONE);
        fragManaCarDetailBinding.top.setVisibility(View.VISIBLE);
        fragManaCarDetailBinding.tvY.setText("重新输入");
        fragManaCarDetailBinding.title.getMidTV().setText("新建车辆");
        fragManaCarDetailBinding.tvY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(StringUtil.equals(fragManaCarDetailBinding.tvY.getText().toString(),"重新输入")){
                    fragManaCarDetailBinding.etName.setText("");
                    fragManaCarDetailBinding.tvY.setText("确定");
                }else{
                    fragManaCarDetailBinding.tvY.setText("重新输入");
                }

            }
        });
    }
}
