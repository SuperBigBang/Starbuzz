package com.hfad.starbuzz.screen.topLevelActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.hfad.starbuzz.R;
import com.hfad.starbuzz.screen.drinkCategoryActivity.DrinkCategoryActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopLevelViewActivity extends MvpAppCompatActivity implements TopLevelView {

    @InjectPresenter
    TopLevelPresenter mTopLevelPresenter;

    @BindView(R.id.list_options)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        ButterKnife.bind(this);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (position == 0) {
                mTopLevelPresenter.onDrinkCategorySelection();
            }
        });
    }

    @Override
    public void showDrinkCategoryActivity() {
        Intent intent = new Intent(TopLevelViewActivity.this, DrinkCategoryActivity.class);
        startActivity(intent);
    }
}

