package com.example.db;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class adapter extends ArrayAdapter {

    List list=new ArrayList();

    public adapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    static class layout{
        TextView id,name,email,number,deg,skill;
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        layout ly;
        if(row==null){
            LayoutInflater lay= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ly=new layout();
            row=lay.inflate(R.layout.list,parent,false);
            ly.id=(TextView)row.findViewById(R.id.t1);
            ly.name=(TextView)row.findViewById(R.id.t2);
            ly.email=(TextView)row.findViewById(R.id.t3);
            ly.number=(TextView)row.findViewById(R.id.t4);
            ly.deg=(TextView)row.findViewById(R.id.t5);
            ly.skill=(TextView)row.findViewById(R.id.t6);

            row.setTag(ly);
        }
        else{
            ly=(layout)row.getTag();
        }

        data da=(data) this.getItem(position);
        ly.id.setText(da.getId());
        ly.name.setText(da.getName());
        ly.email.setText(da.getEmail());
        ly.number.setText(da.getNumber());
        ly.deg.setText(da.getDegree());
        ly.skill.setText(da.getSkill());

        return row;
    }
}
