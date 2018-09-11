package com.hfad.starbuzz;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends ListActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView=getListView();
        ArrayAdapter<Drink> listadapter = new ArrayAdapter<Drink>(this,android.R.layout.simple_list_item_1, Drink.drinks);
        listView.setAdapter(listadapter);
    }
}
