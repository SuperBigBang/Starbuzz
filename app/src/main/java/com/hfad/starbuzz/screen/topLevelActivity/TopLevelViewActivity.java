package com.hfad.starbuzz.screen.topLevelActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.hfad.starbuzz.R;
import com.hfad.starbuzz.screen.drinkCategoryActivity.DrinkCategoryActivity;

import butterknife.BindView;

public class TopLevelViewActivity extends MvpAppCompatActivity implements TopLevelView {

    @InjectPresenter
    TopLevelPresenter

    @BindView(R.id.list_options)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0) {
                    Intent intent=new Intent(TopLevelViewActivity.this, DrinkCategoryActivity.class);
                startActivity(intent);}

            }
        };
        ListView listView= (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }
}
