package com.example.tanvi.notes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanvi on 04/01/17.
 */

public class Questions extends AppCompatActivity {
    Context context;
    ArrayList<listass> list;
    listadp  adp;
    int sbno;
    String sbnm;

        String ds[] = {"what is data structurs ?", "types of data structures ?", "Define link list", "what is a stack", "what is queue"
                , "what is tree", "what is graph"};
        String c[] = {"what is oops", "what is an object", "what is a constructor",
                "define function overloading", "deind function over riding", "what is a class"};
        String java[]={"what is jvm","what is jdk","why java is robust","why java is pure object orinted"};
    @Override
    protected void onCreate(Bundle bndl)
    {
        super.onCreate(bndl);
        context = this;
        list = new ArrayList<>();
        setContentView(R.layout.secind);
        Bundle bn = getIntent().getExtras();
        String sub = bn.getString("subnm");
        int sbn = bn.getInt("subno");
        TextView tv = (TextView) findViewById(R.id.tvsb);
        tv.setText(sub);
        adp = new listadp(context,list);
        list.clear();
        sbno = sbn;
        switch (sbn){
            case 0:
                for(int j=0;j< ds.length;j++)
                {
                    listass ob = new listass();
                    ob.setdata(ds[j]);
                    ob.setnum(String.valueOf(j+1));
                    list.add(ob);
                }

                break;
            case 1:
                for (int j =0;j<c.length;j++)
                {
                    listass ob = new listass();
                    ob.setdata(c[j]);
                    ob.setnum(String.valueOf(j+1));
                    list.add(ob);

                }
                break;
            case 2:
                for(int j=0;j<java.length;j++)
                {
                    listass ob = new listass();
                    ob.setdata(java[j]);
                    ob.setnum(String.valueOf(j+1));
                    list.add(ob);
                }
                break;
        }
        adp.notifyDataSetChanged();

        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adp);
        sbnm = sub;
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String ques = list.get(i).getdata().toString();
                Intent nm = new Intent(context, Ans.class);
                Bundle bn = new Bundle();
                bn.putString("subnm", sbnm);
                bn.putInt("subno", sbno);
                bn.putInt("qno", i);
                bn.putString("ques", ques);
                nm.putExtras(bn);
                startActivity(nm);

            }
        });

    }

    private class listass
    {
        private String qes;
        private String num ;
        public String getdata(){return qes;}
        public String getnum (){return num ;}
        private void setdata(String qes){ this.qes = qes ;}
        private void setnum (String num ){this.num = num ;}

    }
    public class  listadp extends ArrayAdapter<listass>
    { ArrayList<listass> lst;
        Context cnt;
        public listadp(Context cnt, ArrayList<listass> lst)
        {
            super(cnt,R.layout.listdetail,lst);
            this.cnt = cnt;
            this.lst = lst;
        }
        public View getView(int position, View convertView, ViewGroup parent)
        {

            LayoutInflater li = (LayoutInflater) cnt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = li.inflate(R.layout.listdetail, null, true);

            TextView tvnm = (TextView) view.findViewById(R.id.tvsbnm);
            tvnm.setText(lst.get(position).getdata());
            TextView tvnum = (TextView) view.findViewById(R.id.tvsbno);
            tvnum.setText(lst.get(position).getnum());


            return view;

        }



    }


}