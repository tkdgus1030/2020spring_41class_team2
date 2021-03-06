package com.example.bloodwallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MyDonationsReceivedList extends AppCompatActivity {
    ListView listView;
    String[] title={"기부 받은 기록1","기부 받은 기록2","기부 받은 기록3"};
    String[] time={"10:56 PM","2:00 PM","11:03 AM"};
    String[] story={"aaaa","bbbb","cccc"};
    String[] percent={"100%","100%","50%"};
    myadapter adapter;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_donations_received_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        userID=intent.getStringExtra("userID");
        listView =(ListView) findViewById(R.id.donationreceivedlist);
        adapter = new myadapter();
        listView.setAdapter(adapter);


        ImageButton myinfobutton=findViewById(R.id.myinfobutton_list);
        myinfobutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(  MyDonationsReceivedList.this , Myinfo.class );
                i.putExtra("userID",userID);
                startActivity(i);
            }
        });

        ListView listView = (ListView) findViewById(R.id.donationreceivedlist);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(  MyDonationsReceivedList.this , StoryActivity.class );
                i.putExtra("Button_on",0);
                startActivity(i);
            }
        });

    }
    class myadapter extends BaseAdapter{
        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public Object getItem(int position) {
            return title[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            DonationsRecievedListReading view= new DonationsRecievedListReading(getApplicationContext());
            view.setTitle(title[position]);
            view.setTime(time[position]);
            view.setStory(story[position]);
            view.percent(percent[position]);

            return view;
        }
    }
}
