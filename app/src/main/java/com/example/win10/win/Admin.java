package com.example.win10.win;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by WIN 10 on 01-03-2017.
 */

public class Admin extends AppCompatActivity {
    ListView listView;
    String[] countries = new String[]{
            "Municipality", "Transport", "Forestry and WildLife", "HomeAffairs and National Security", "Ward Complaint",
            "Nearby Blood Donors", "Public distribution"
    };
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
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);


        CustomList customList = new CustomList(this, countries, flags);

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(customList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "You Clicked " + countries[i], Toast.LENGTH_SHORT).show();
            }



            });
}
}
