package rhs.recipeapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class RecipeInput extends AppCompatActivity {

    private SQLiteOpenHelper mDbHelper = null;
    final DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
    final SQLiteDatabase db = dbHelper.getWritableDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveToDatabase();
                goToSecondActivity();

            }
        });

    }

    private void saveToDatabase() { //save this to sqlite database
        // Create new helper

        // Get the database. If it does not exist, this is where it will
        // also be created.

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.MyRecipes.COLUMN_NAME_RECIPE_NAME, "recipeName");
        values.put(DatabaseContract.MyRecipes.COLUMN_NAME_TIMES, "times");
        values.put(DatabaseContract.MyRecipes.COlUMN_NAME_NUM_SERVINGS, "numServings");
        values.put(DatabaseContract.MyRecipes.COlUMN_NAME_INGREDIENTS, "ingredients");
        values.put(DatabaseContract.MyRecipes.COLUMN_NAME_INSTRUCTIONS, "instructions");
        // Insert the new row, returning the primary key value of the new row
        db.insert(DatabaseContract.MyRecipes.TABLE_NAME, null, values);
    }

    private void goToSecondActivity() {
        Intent intent = new Intent(this, Display.class);

        startActivity(intent);
    }

}
