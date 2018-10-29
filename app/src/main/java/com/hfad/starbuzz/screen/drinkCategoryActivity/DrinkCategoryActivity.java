package com.hfad.starbuzz.screen.drinkCategoryActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hfad.starbuzz.model.DrinkModel;
import com.hfad.starbuzz.screen.drinkActivity.DrinkActivity;
import com.hfad.starbuzz.screen.drinkActivity.DrinkActivityPresenter;

public class DrinkCategoryActivity extends ListActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = getListView();
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DrinkModel.drinks));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
        intent.putExtra(DrinkActivityPresenter.EXTRA_DRINKNO, (int) id);
        startActivity(intent);
    }
}
