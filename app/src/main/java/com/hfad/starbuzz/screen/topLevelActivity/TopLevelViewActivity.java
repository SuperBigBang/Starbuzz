package com.hfad.starbuzz.screen.topLevelActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.hfad.starbuzz.ExtendApplication;
import com.hfad.starbuzz.R;
import com.hfad.starbuzz.screen.drinkActivity.DrinkActivity;
import com.hfad.starbuzz.screen.drinkCategoryActivity.DrinkCategoryActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopLevelViewActivity extends MvpAppCompatActivity implements TopLevelView {

    @InjectPresenter
    TopLevelPresenter mTopLevelPresenter;

    @BindView(R.id.list_options)
    ListView listView;

    @BindView(R.id.list_favorites)
    ListView listFavorites;

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
        mTopLevelPresenter.fillListFavorites();
    }

    @Override
    public void showDrinkCategoryActivity() {
        Intent intent = new Intent(TopLevelViewActivity.this, DrinkCategoryActivity.class);
        startActivity(intent);
    }

    @Override
    public void fillFavoritesList(Cursor cursor) {
        CursorAdapter favoriteAdapter = new SimpleCursorAdapter(TopLevelViewActivity.this,
                android.R.layout.simple_list_item_1, cursor, new String[]{"NAME"},
                new int[]{android.R.id.text1}, 0);
        listFavorites.setAdapter(favoriteAdapter);
        listFavorites.setOnItemClickListener((parent, view, position, id) -> {
            mTopLevelPresenter.onFavoritesItemClick((int) id);
        });
    }

    @Override
    public void onFavoritesItemClicked(int id) {
        Intent intent = new Intent(TopLevelViewActivity.this, DrinkActivity.class);
        intent.putExtra(ExtendApplication.getBaseComponent().getStarbuzzDatabaseHelperModule().EXTRA_DRINKNO, id);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //       mTopLevelPresenter.onTopLevelActivityDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mTopLevelPresenter.fillListFavorites();
    }
}

