package com.siweisoft.heavycenter.module.main.store.news;

//by summer on 2017-12-11.

import android.content.Context;

import com.android.lib.base.ope.BaseDAOpe;

import java.util.ArrayList;

public class NewDAOpe extends BaseDAOpe {


    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        for(int i=0;i<100;i++){
            data.add(""+i);
        }
        return data;
    }
}
