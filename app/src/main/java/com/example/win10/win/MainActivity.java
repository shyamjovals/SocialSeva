package com.example.win10.win;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    String base_url;
    Firebase fb_db;
    ImageView imageView;
    EditText username;
    EditText password;
    TextView signup;
    TextView login;

    String uname,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);




        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        signup=(TextView) findViewById(R.id.signup);
        login=(TextView) findViewById(R.id.login);
        imageView=(ImageView) findViewById(R.id.imageView);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Create.class);
                startActivity(i);




            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i=new Intent(MainActivity.this,Create.class);
//                startActivity(i);
                uname = username.getText().toString();
                pass = password.getText().toString();

                base_url = "https://socialseva-db7fd.firebaseio.com/UserCreds/"+uname+"/";
                fb_db = new Firebase(base_url);

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

            fb_db.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot)
                {
                    CredUpdate credUpdate = dataSnapshot.getValue(CredUpdate.class);

                    if(credUpdate.getUaadhar().equals(uname)&&(credUpdate.getPass().equals(pass)))
                    {
                        Intent intent = new Intent(MainActivity.this,Theme.class);
                        intent.putExtra("uaadhar",uname);
                        startActivity(intent);
                        finish();
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
