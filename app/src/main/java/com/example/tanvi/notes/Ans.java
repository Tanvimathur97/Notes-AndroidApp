package com.example.tanvi.notes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by tanvi on 05/01/17.
 */

public class Ans extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String [] dsas = {"A data structure is a way of storing program in a sequential manner, so that it becomes easy to handle and extract",
                "A linklist is a intrconnected type data structure in which each node is connected to the previous node",
                "A stack is a open jar type data structure in which only one opening is there for entering the data and for the deletion ",
                "a stack has one opening whereas the queue has tow open ends , the front and the rear end for insertion and deletion",
                "A tree is a data structure where each node is connected to other directly or indirectly .",
        "a graph is a structural arrangement of  points collected in a i dont know cause i loke what i do nad i do what i like",
        "need not care about anythimg we dont undersant yh yah ah yaah"};

        String [] cas={"object orinted programing is based on class and attributes, the basic of oop is the object",
                " c is high level tye language, where cpp is objct orinted",
                "A class is a collection of data attributes and methods",
                " extending the properties of one class to another"
                ," simple , hirerchal, hibrid"};
        String [] jas = {"jvm is java virtual machine","jdk is java development tool used for programing in java",
                "java is robust because it has on built excepton handeling",
                "finally is stateent which can not be changed","package is groupe of classes"};

            setContentView(R.layout.third);
            Bundle bn = getIntent().getExtras();
            String ques = bn.getString("ques");
            int qno = bn.getInt("qno");
            String sbnm = bn.getString("subnm");
            int sbno = bn.getInt("subno");

            TextView tv = (TextView) findViewById(R.id.tvsubnm);
            tv.setText(sbnm);
            tv = (TextView) findViewById(R.id.tvque);
            tv.setText(ques);
            tv = (TextView) findViewById(R.id.tvans);
            switch(sbno)
            {
                case 0:
                    tv.setText(dsas[qno]);
                    break;
                case 1:
                    tv.setText(cas[qno]);
                    break;
                case 2:
                    tv.setText(jas[qno]);
                    break;
            }


    }
}
