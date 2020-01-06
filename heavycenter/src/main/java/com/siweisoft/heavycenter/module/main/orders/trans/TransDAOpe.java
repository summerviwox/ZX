package com.siweisoft.heavycenter.module.main.orders.trans;

//by summer on 2017-12-19.

import com.siweisoft.heavycenter.base.AppDAOpe;

import java.util.ArrayList;

public class TransDAOpe extends AppDAOpe {

    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        for(int i=0;i<100;i++){
            data.add(""+i);
        }
        return data;
    }
}
