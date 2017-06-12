package com.example.tanvi.notes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context  context;
    String sbnm=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        final String sub [] = {"data structures","c++","java"};
        final Spinner sp =(Spinner)findViewById(R.id.sp);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sub);
        sp.setAdapter(adp);
        /*sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sbnm = sp.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
        Button bt = (Button)findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(context,Questions.class);
                Bundle bn = new Bundle();
                bn.putString("subnm",sp.getSelectedItem().toString());
                bn.putInt("subno", sp.getSelectedItemPosition());
                in.putExtras(bn);
                startActivity(in);
            }
        });

    }
    /*private class spi {

        String sub;
        private  String gatdata()
        { return sub;}
        private  void setdata(String s)
        {
           s = this.sub;

        }

    }
     public class listadp extends ArrayAdapter<spi>
     {
        private ArrayList<spi> list;
         private Context cnt;

         public listadp(Context cnt , ArrayList<spi> list) {
             super(cnt,R.layout.secind, list);
             this.cnt = cnt;
             this.list = list;

         }
         public View getView(int posiation,View convertView,ViewGroup parent )
         {
             LayoutInflater li =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             View view = li.inflate(R.layout.secind, null, true);
             TextView tv= (TextView)findViewById(R.id.tvsb);
             tv.setText(list.get(posiation).gatdata());
             return view;*/
         }





