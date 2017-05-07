package com.icoleman.ad340app;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.ListAdapter;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.icoleman.ad340app.MESSAGE";

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // OnClickListener for FAB (+ button to create new list)
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            // Set radio buttons for list type choices
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setIcon(R.drawable.ic_playlist_add_black_48dp);
                myBuilder.setTitle(R.string.dialog_title);
                myBuilder.setCancelable(false);
                Resources res = getResources();
                final CharSequence[] dialogItems = res.getStringArray(R.array.dialog_items);
                myBuilder.setSingleChoiceItems(dialogItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {
                        // log selected choice
                        Log.d(TAG, "New list dialog choice = " + dialogItems[item]);
                    }
                });

                // Set the action buttons
                myBuilder.setPositiveButton("Create List", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        Toast.makeText(MainActivity.this, "Create List",
                                Toast.LENGTH_SHORT).show();
                        if (id == -1) {
                            // log create list action
                            Log.d(TAG, "New list dialog action = Create List");
                        }
                        dialogInterface.dismiss();
                    }
                });
                myBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        Toast.makeText(MainActivity.this, "Cancelled",
                                Toast.LENGTH_SHORT).show();
                        if (id == -2) {
                            // log cancel action
                            Log.d(TAG, "New list dialog action = Cancelled");
                        }
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = myBuilder.create();
                alertDialog.show();
            }
        });
    }

    /** Creates menu items in toolbar. */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater myMenuInflater = getMenuInflater();
        myMenuInflater.inflate(R.menu.menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        return true;
    }


    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    /** Called when the user taps the "Send" button */
    public void sendMessage(View view) {
        try {
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            EditText editText = (EditText) findViewById(R.id.editText);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } catch (Exception e) {
            Log.d(TAG, "sendMessage()", e);
        }

    }

    /** Called when user taps any of the "list" buttons (except "Contacts") */
    public void toast(View view) {
        Toast.makeText(MainActivity.this, "No lists to display",
                Toast.LENGTH_SHORT).show();

    }

    /** Called when the user taps the "Contact" button */
    public void getContacts(View view) {
        try {
            Intent intent = new Intent(this, DisplayContactsActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            Log.d(TAG, "getContacts()", e);
        }

    }

    /** Called when the user taps a menu item on the action bar */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_contacts:
                /** Called when the user selects "contacts" from menu */
                try {
                    Intent intent = new Intent(this, DisplayContactsActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Log.d(TAG, "getContacts()", e);
                }
                return true;

            case R.id.menu_about:
                /** Called when the user selects "about" from menu */
                try {
                    Intent intent = new Intent(this, AboutActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Log.d(TAG, "getAbout()", e);
                }
                return true;

            case R.id.menu_settings:
                /** Called when the user selects "settings" from menu */
                Toast.makeText(MainActivity.this, "no settings to show",
                        Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


}
