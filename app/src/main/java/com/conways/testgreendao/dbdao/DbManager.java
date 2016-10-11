package com.conways.testgreendao.dbdao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.conways.testgreendao.dbentity.Person;

import java.util.List;

/**
 * Created by John on 2016/10/11.
 */
public class DbManager {
    private static DbManager ourInstance;
    private String dbName = "test_greendao";
    private DaoSession daoSession;


    public static DbManager getInstance() {
        if (ourInstance == null) {
            synchronized (DbManager.class) {
                if (ourInstance == null) {
                    ourInstance = new DbManager();
                }
            }
        }
        return ourInstance;
    }


    public void init(Context context) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, dbName);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        daoSession = daoMaster.newSession();
    }


    private DbManager() {
    }


    public List<Person> getPersons() {

        PersonDao personDao = daoSession.getPersonDao();
        return personDao.loadAll();
    }

    public boolean insertPerson(Person person) {
        PersonDao personDao = daoSession.getPersonDao();
        return personDao.insert(person) != -1;
    }


}
