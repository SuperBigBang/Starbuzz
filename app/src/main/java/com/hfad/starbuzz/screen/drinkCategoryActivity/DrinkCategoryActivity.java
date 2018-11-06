package com.hfad.starbuzz.screen.drinkCategoryActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.hfad.starbuzz.ExtendApplication;
import com.hfad.starbuzz.screen.drinkActivity.DrinkActivity;
import com.hfad.starbuzz.screen.drinkActivity.DrinkActivityPresenter;

public class DrinkCategoryActivity extends ListActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
        intent.putExtra(DrinkActivityPresenter.EXTRA_DRINKNO, (int) id);
        startActivity(intent);
    }

    private void setListAdapter() {
        ListView listView = getListView();
        CursorAdapter listAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                ExtendApplication.getBaseComponent().getStarbuzzDatabaseHelperModule()
                        .getCursor(ExtendApplication.getBaseComponent().getContext()),
                new String[]{"NAME"},
                new int[]{android.R.id.text1},
                0);
        listView.setAdapter(listAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ExtendApplication.getBaseComponent().getStarbuzzDatabaseHelperModule().closeDatabaseAndCursor();
    }
}
