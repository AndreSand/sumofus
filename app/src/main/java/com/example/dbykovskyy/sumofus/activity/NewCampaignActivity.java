package com.example.dbykovskyy.sumofus.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.dbykovskyy.sumofus.R;
import com.example.dbykovskyy.sumofus.fragments.NewCampaignFragment;
import com.example.dbykovskyy.sumofus.models.CampaignParse;

public class NewCampaignActivity extends AppCompatActivity {

    private CampaignParse campaign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        campaign = new CampaignParse();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        // Begin with main data entry view
        setContentView(R.layout.activity_new_campaign);
        FragmentManager manager = getFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = new NewCampaignFragment();
            manager.beginTransaction().add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }

    public CampaignParse getCurrentCampaign() {
        return campaign;
    }

}
