package com.example.namanappmemorableplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> places = new ArrayList<String>();
    static ArrayList<LatLng> locations = new ArrayList<LatLng>();
    static ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.namanappmemorableplaces", Context.MODE_PRIVATE);
        ListView listView = findViewById(R.id.myListView);
        places.add("Add a new place...");
        locations.add(new LatLng(0,0));

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, places);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("placeNumber",i);

                startActivity(intent);
            }
        });

    }
}

//public class MainActivity extends AppCompatActivity {
//    static ArrayList<String> memorablePlacesList=new ArrayList<String>();
//    static ArrayList<LatLng> locations=new ArrayList<LatLng>();
//    static ArrayAdapter<String> arrayAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ListView myListView=(ListView) findViewById(R.id.myListView);
//        memorablePlacesList.add("Add a new place...");
//        locations.add(new LatLng(0,0));
//        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, memorablePlacesList);
//        myListView.setAdapter(arrayAdapter);
//
//        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(position==0)
//                {
//                    Intent intent=new Intent(getApplicationContext(), SecondActivity.class);
//                    startActivity(intent);
//                    intent.putExtra("memorablePlacesList", memorablePlacesList);
//                }
//            }
//        });
//
//
//    }
//}
