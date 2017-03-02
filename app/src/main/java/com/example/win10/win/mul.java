package com.example.win10.win;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by WIN 10 on 27-02-2017.
 */

public class mul extends AppCompatActivity {

    String base_url = "https://socialseva-db7fd.firebaseio.com/";

    Firebase fb_db;

    EditText editText,editText2,editText3,editText4;
    TextView text;
    String to,sub,loc,desc,aadhar;
    String curlist;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mul);

        Firebase.setAndroidContext(this);
        fb_db = new Firebase(base_url);

        curlist = getIntent().getExtras().getString("curlist");
        aadhar = getIntent().getExtras().getString("uaadhar");

        System.out.println("NOOB "+curlist);
        System.out.println("NOOB 3"+aadhar);


        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
        editText4=(EditText)findViewById(R.id.editText4);
        text=(TextView)findViewById(R.id.text);


      text.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              to = editText.getText().toString();
              sub = editText2.getText().toString();
              loc = editText3.getText().toString();
              desc = editText4.getText().toString();
              date=new SimpleDateFormat("dd-MM-yy HH:mm:ss").format(new Date());
              String finalnode = aadhar+date;

              PostComp postComp = new PostComp();
              postComp.setAadhar(aadhar);
              postComp.setTo(to);
              postComp.setSub(sub);
              postComp.setLoc(loc);
              postComp.setDesc(desc);




              fb_db.child("Complaints").child(curlist).child(aadhar).setValue(postComp);












              Toast.makeText(mul.this,"your complaint is sent",Toast.LENGTH_SHORT).show();

          }
      });


    }
}
