package com.example.win10.win;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;

/**
 * Created by WIN 10 on 27-02-2017.
 */

public class Create extends AppCompatActivity {

    String base_url = "https://socialseva-db7fd.firebaseio.com/";
    Firebase fb_db;

    ImageView imageView;
    EditText username;
    EditText password;
    TextView signup;
    EditText aadhar;
    EditText mob;
    EditText area;
    EditText blood;

    String uname,upass,uaadhar,umob,uarea,ublood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Firebase.setAndroidContext(this);
        fb_db = new Firebase(base_url);
        imageView = (ImageView) findViewById(R.id.imageView);
        username =(EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        signup =(TextView) findViewById(R.id.signup);
        aadhar = (EditText) findViewById(R.id.aadhar);
        mob =(EditText) findViewById(R.id.mob);
        area= (EditText) findViewById(R.id.area);
        blood = (EditText) findViewById(R.id.blood);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i=new Intent(Create.this,Theme.class);
//                startActivity(i);

                uname = username.getText().toString();
                upass = password.getText().toString();
                uaadhar = aadhar.getText().toString();
                umob = mob.getText().toString();
                uarea = area.getText().toString();
                ublood = blood.getText().toString();

                CredUpdate credUpdate = new CredUpdate();
                credUpdate.setUname(uname);
                credUpdate.setPass(upass);
                credUpdate.setUaadhar(uaadhar);
                credUpdate.setUmob(umob);
                credUpdate.setUarea(uarea);
                credUpdate.setUblood(ublood);

                fb_db.child("UserCreds").child(uaadhar).setValue(credUpdate);








            }
        });

    }
}
