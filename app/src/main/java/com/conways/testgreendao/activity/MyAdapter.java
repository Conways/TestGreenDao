package com.conways.testgreendao.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.conways.testgreendao.R;
import com.conways.testgreendao.dbentity.Person;

import java.util.List;

/**
 * Created by John on 2016/10/11.
 */
public class MyAdapter extends BaseAdapter {

    private List<Person> list;
    private Context context;


    public MyAdapter(List<Person> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Person getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Holder holder;
        if (null==view){
            view= LayoutInflater.from(context).inflate(R.layout.item_test,viewGroup,false);
            holder=new Holder();
            holder.tvName=(TextView)view.findViewById(R.id.textView);
            holder.tvSex=(TextView)view.findViewById(R.id.textView2);
            holder.tvId=(TextView)view.findViewById(R.id.textView3);
            holder.tvAge=(TextView)view.findViewById(R.id.textView4);
            view.setTag(holder);
        }else {
            holder= (Holder) view.getTag();
        }

        Person person=getItem(i);
        holder.tvName.setText(person.getName());
        holder.tvSex.setText(person.getSex()==0?"男":"女");
        holder.tvAge.setText(person.getAge()+"");
        holder.tvId.setText(person.getId()+"");

        return view;
    }


    class Holder{
        TextView tvId;
        TextView tvName;
        TextView tvSex;
        TextView tvAge;
    }
}
