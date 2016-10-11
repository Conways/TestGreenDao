package com.conways.testgreendao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.conways.testgreendao.R;
import com.conways.testgreendao.dbdao.DbManager;
import com.conways.testgreendao.dbentity.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btInsert;
    private ListView lvShow;
    private MyAdapter myAdapter;
    private List<Person> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        update();
    }


    private void init() {
        btInsert = (Button) this.findViewById(R.id.button);
        btInsert.setOnClickListener(this);
        lvShow = (ListView) this.findViewById(R.id.listView);
    }


    private void update(){
        if (null==list){
            list=new ArrayList<>();
        }
        list.clear();
        list.addAll(DbManager.getInstance().getPersons());
        if (null==myAdapter){
            myAdapter=new MyAdapter(list,this);
            lvShow.setAdapter(myAdapter);
        }else{
            myAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onClick(View view) {

        Person person=new Person();
        person.setName(names[(int)(System.currentTimeMillis()%4)]);
        person.setAge((int)(Math.random()*100));
        person.setSex(0);


        if (DbManager.getInstance().insertPerson(person)){
            update();
        }else{
            Toast.makeText(this,"insert failed!",Toast.LENGTH_SHORT).show();
        }



    }


    private String[] names={"Tom","John","Conways","李四"};
}
