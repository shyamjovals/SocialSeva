package com.example.win10.win;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by WIN 10 on 01-03-2017.
 */

public class Start extends AppCompatActivity {
    TextView textView,textView2;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate( savedInstanceState);
        setContentView(R.layout.start);

        textView=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView2);

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Start.this,"Clicked user",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Start.this,MainActivity.class);
                startActivity(i);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Start.this,"Clicked Admin",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Start.this,admin_login.class);
                startActivity(i);

            }
        });


    }
}
