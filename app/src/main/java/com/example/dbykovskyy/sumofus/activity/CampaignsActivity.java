package com.example.dbykovskyy.sumofus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.dbykovskyy.sumofus.models.Campaign;
import com.example.dbykovskyy.sumofus.R;
import com.example.dbykovskyy.sumofus.adapter.CampaignItemAdapter;
import com.parse.ParseAnalytics;

import java.util.ArrayList;

public class CampaignsActivity extends AppCompatActivity {
    String imageUrl = "http://sumofus.org/wp-content/uploads/2015/10/38b73ede-6a13-433c-9c76-a567ccfea8b1.jpg";
    String shortDescriptoin = "The third-largest palm oil corporation in the world is exploiting refugees and clearing rainforests";
    String longDescriptoin = "Standard Chartered, a massive international bank, is about to bankroll a Malaysian palm oil producer responsible for horrific slave-labour conditions and widespread environmental destruction.";

    private ArrayList<Campaign> campaigns;
    private CampaignItemAdapter adapterCampaigns;
    private ListView lvCampaigns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_campaigns);

        populateCampaigns();

        adapterCampaigns = new CampaignItemAdapter(this, campaigns);
        lvCampaigns = (ListView) findViewById(R.id.lvCampaigns);
        lvCampaigns.setAdapter(adapterCampaigns);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_campaigns, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public ArrayList<Campaign> populateCampaigns(){
        campaigns = new ArrayList<Campaign>();
        for(int i=0; i<=10; i++){
            Campaign camp = new Campaign(imageUrl, shortDescriptoin, longDescriptoin);
            campaigns.add(camp);
        }
     return campaigns;
    }

}
