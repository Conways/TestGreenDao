package com.conways.testgreendao;

import android.app.Application;

import com.conways.testgreendao.dbdao.DbManager;

/**
 * Created by John on 2016/10/11.
 */
public class App extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        initGreenDao();
    }


    private void initGreenDao(){
        DbManager.getInstance().init(this);
    }

}
