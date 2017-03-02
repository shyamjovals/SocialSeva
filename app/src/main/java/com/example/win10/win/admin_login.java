package com.example.win10.win;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import static com.example.win10.win.R.id.imageView;

/**
 * Created by WIN 10 on 01-03-2017.
 */

public class admin_login extends AppCompatActivity {


    String adminaadhar1,adminpass1;
    String base_url = "https://socialseva-db7fd.firebaseio.com/Admin/";

    Firebase fb_db;

    EditText username;
    EditText password;

    TextView login;
    ImageView imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);

        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        login=(TextView) findViewById(R.id.login);
        imageView=(ImageView) findViewById(R.id.imageView);


        Firebase.setAndroidContext(this);
        fb_db=new Firebase(base_url);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i=new Intent(admin_login.this,Admin.class);
//                startActivity(i);
                adminaadhar1 = username.getText().toString();
                adminpass1 = password.getText().toString();

                new MyTask().execute();
            }
        });




    }



    private class MyTask extends AsyncTask<String, Integer, String> {

        // Runs in UI before background thread is called
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//           progressDialog = ProgressDialog.show(getApplicationContext(), "Message", "Creating Account...");

        }

        // This is run in a background thread
        @Override
        protected String doInBackground(String... params)
        {

            fb_db.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot)
                {
                    AdminCreds adminCreds = dataSnapshot.getValue(AdminCreds.class);

                    System.out.println("KKKKKK"+adminCreds.getAdminpass()+"asdfasdfasdf"+adminCreds.getAdminaadhar());




                    if(adminCreds.getAdminaadhar().equals(adminaadhar1)&&(adminCreds.getAdminpass().equals(adminpass1)))
                    {
                        Intent intent = new Intent(admin_login.this,Admin.class);
                       startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"LOL ",Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });








            return "SUCCESS";
        }



        // This runs in UI when background thread finishes
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if(result.equals("SUCCESS")){
                System.out.println("SUCCESS");

//                Toast.makeText(Register.this,"Account Created",Toast.LENGTH_LONG).show();


            }
            else{
//                Toast.makeText(Register.this,"Failed..",Toast.LENGTH_LONG).show();
            }

//            progressDialog.dismiss();
            // Do things like hide the progress bar or change a TextView
        }
    }
}
