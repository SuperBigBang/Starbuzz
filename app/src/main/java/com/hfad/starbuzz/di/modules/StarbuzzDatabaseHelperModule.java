package com.hfad.starbuzz.di.modules;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.hfad.starbuzz.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StarbuzzDatabaseHelperModule extends SQLiteOpenHelper {
    private static final String DB_NAME = "starbuzz";
    private static final int DB_VERSION = 4;
    private SQLiteDatabase mDatabase;
    private SQLiteOpenHelper mStarbuzzDatabaseHelper;

    private static final String TABLE = "DRINK";
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String IMAGE_RESOURCE_ID = "IMAGE_RESOURCE_ID";


    public StarbuzzDatabaseHelperModule(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
        mDatabase = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
        mDatabase = db;
    }

    public static void insertDrink(SQLiteDatabase db, String name,
                                   String description, int resourceId) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put(NAME, name);
        drinkValues.put(DESCRIPTION, description);
        drinkValues.put(IMAGE_RESOURCE_ID, resourceId);
        db.insert(TABLE, null, drinkValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE DRINK ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertDrink(db, "Cappuccino", "Espresso, hot milk and steamed-milk foam", R.drawable.cappuccino);
            insertDrink(db, "Latte", "Espresso and steamed milk", R.drawable.latte);
            insertDrink(db, "Filter", "Our best drip coffee", R.drawable.filter);
        }
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC");
        }
        if (oldVersion < 4) {
            db.execSQL("DROP TABLE DRINK");
            db.execSQL("CREATE TABLE DRINK ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertDrink(db, "Cappuccino", "Espresso, hot milk and steamed-milk foam", R.drawable.cappuccino);
            insertDrink(db, "Latte", "Espresso and steamed milk", R.drawable.latte);
            insertDrink(db, "Filter", "Our best drip coffee", R.drawable.filter);
        }
    }

    @Provides
    @Singleton
    public StarbuzzDatabaseHelperModule provideStarbuzzDatabaseHelperModule(Context context) {
        return new StarbuzzDatabaseHelperModule(context);
    }

    public String[] getItemSourceFromDatabase(String drinkNO, Context context) {
        String nameText = "";
        String descriptionText = "";
        String photoId = "";
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelperModule(context);
            db = starbuzzDatabaseHelper.getReadableDatabase();
            cursor = db.query(TABLE,
                    new String[]{NAME, DESCRIPTION, IMAGE_RESOURCE_ID},
                    "_id = ?",
                    new String[]{drinkNO},
                    null, null, null);
            if (cursor.moveToFirst()) {
                nameText = cursor.getString(0);
                descriptionText = cursor.getString(1);
                photoId = cursor.getString(2);
            }
            cursor.close();
            db.close();

        } catch (SQLiteException e) {
            if (cursor != null || db != null) {
                cursor.close();
                db.close();
            }
            Toast toast = Toast.makeText(context, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
        return new String[]{nameText, descriptionText, photoId};
    }
}

