package com.example.user.mynotebookedit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    public static final String NOTE_ID_EXTRA = "com.example.user.mynotebook.Identifier";
    public static final String NOTE_TITLE_EXTRA = "com.example.user.mynotebook.Title";
    public static final String NOTE_MESSAGE_EXTRA = "com.example.user.mynotebook.Message";
    public static final String NOTE_CATEGORY_EXTRA = "com.example.user.mynotebook.Category";
    public static final String NOTE_FRAGMENT_TO_LOAD_EXTRA = "com.example.user.mynotebook.Fragment_To_load";

    public enum FragmentToLaunch{ VIEW, EDIT, CREATE }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadPreferences();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, AppPreferences.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.action_add_note){
            Intent intent = new Intent(this, NoteDetailActivity.class);
            intent.putExtra(MainActivity.NOTE_FRAGMENT_TO_LOAD_EXTRA, FragmentToLaunch.CREATE);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*This piece of code controls the settings page that was created. It works alongside the app_preferences layout.*/
    private void loadPreferences(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        //Sunlight editing options. Makes the background darker for ease on the eyes.
        boolean isBackgroundDark = sharedPreferences.getBoolean("background_color", false);
        if(isBackgroundDark){
            LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainActivityLayout);
            mainLayout.setBackgroundColor(Color.parseColor("#3c3f41"));
        }

        //ColorBackground editing options.
        boolean diffBackgroundColor = sharedPreferences.getBoolean("diff_background_color", false);
        if(diffBackgroundColor){
            LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainActivityLayout);
            mainLayout.setBackgroundColor(Color.parseColor("#000000"));
        }

        boolean diffBackgroundColor1 = sharedPreferences.getBoolean("diff_background_color1", false);
        if(diffBackgroundColor1){
            LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainActivityLayout);
            mainLayout.setBackgroundColor(Color.parseColor("#4885ed"));
        }

        boolean diffBackgroundColor2 = sharedPreferences.getBoolean("diff_background_color2", false);
        if(diffBackgroundColor2){
            LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainActivityLayout);
            mainLayout.setBackgroundColor(Color.parseColor("#3cba54"));
        }

        //General editing options. Allows to change the title of the current notebook.
        String notebookTitle = sharedPreferences.getString("title", "Notebook");
        setTitle(notebookTitle);
    }
}
