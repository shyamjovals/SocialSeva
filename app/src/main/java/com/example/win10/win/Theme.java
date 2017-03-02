package com.example.win10.win;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class Theme extends AppCompatActivity {

    ListView listView;
    String[] countries = new String[]{
            "Municipality", "Transport", "Forestry and WildLife", "HomeAffairs and National Security", "Ward Complaint",
            "Nearby Blood Donors", "Public distribution"
    };
    String aadhar;


    Integer[] flags = new Integer[]{
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themelayout);
        aadhar = getIntent().getExtras().getString("uaadhar");


        CustomList customList = new CustomList(this, countries, flags);

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(customList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "You Clicked " + countries[i], Toast.LENGTH_SHORT).show();

                if(i == 0|| i == 1 ||i == 2|| i == 3 || i == 4)
                {
                    Intent intent = new  Intent(Theme.this,mul.class);
                    intent.putExtra("curlist",countries[i]);
                    intent.putExtra("uaadhar",aadhar);

                    startActivity(intent);



                }

                if(i==5)
                {
                    Intent k=new Intent(Theme.this,blood.class);
                    startActivity(k);
                }
                if(i==6)
                {
                   Intent u=new Intent(Theme.this,pds.class) ;
                    startActivity(u);
                }
                }



    });}}
