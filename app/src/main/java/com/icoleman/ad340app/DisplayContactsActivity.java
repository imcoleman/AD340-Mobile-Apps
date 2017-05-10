package com.icoleman.ad340app;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayContactsActivity extends AppCompatActivity {
    private static final String TAG = DisplayContactsActivity.class.getSimpleName();
    private static final String ENDPOINT = "http://icoleman.icoolshow.net/ad340Files/contactsData.json";
    private RequestQueue requestQueue;
    private Gson gson;
    private List<Data> contacts;
    private List<Data> contact_strs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contacts);

        /** perform network request to load the data */
        requestQueue = Volley.newRequestQueue(this);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        fetchPosts();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        contact_strs = new ArrayList<>();

    }

    /** retrieve the JSON as a String which can then be parsed and deserialized into instances of the Data class  */
    private void fetchPosts() {
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT, onPostsLoaded, onPostsError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onPostsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            contacts = Arrays.asList(gson.fromJson(response, Data[].class));
            Log.i("DisplayContactsActivity", contacts.size() + " contacts loaded.");
            for (Data contact : contacts) {
                // add items to list
                contact_strs.add(new Data(contact.name, contact.phone));
                Log.i("DisplayContactsActivity", contact.name + ": " + contact.phone);
            }
            Log.i("DisplayContactsActivity", contact_strs.size() + " contacts loaded.");

            // display contacts using RecyclerView
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
            Recycler_View_Adapter adapter = new Recycler_View_Adapter(contact_strs, getApplication());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        }
    };

    // Error handling for Volley network connection
    private final Response.ErrorListener onPostsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            String message;
            Log.e("DisplayContactsActivity", error.toString());
            if (error instanceof NetworkError) {
                message = "Cannot connect to Internet...Please check your connection.";
                Toast.makeText(DisplayContactsActivity.this, message,
                        Toast.LENGTH_SHORT).show();
            } else if (error instanceof ServerError) {
                message = "The data could not be found. Please try again later.";
                Toast.makeText(DisplayContactsActivity.this, message,
                        Toast.LENGTH_SHORT).show();
            } else if (error instanceof AuthFailureError) {
                message = "Cannot connect to Internet...Please check your connection.";
                Toast.makeText(DisplayContactsActivity.this, message,
                        Toast.LENGTH_SHORT).show();
            } else if (error instanceof ParseError) {
                message = "The data could not be found. Please try again later.";
                Toast.makeText(DisplayContactsActivity.this, message,
                        Toast.LENGTH_SHORT).show();
            } else if (error instanceof NoConnectionError) {
                message = "Cannot connect to Internet...Please check your connection.";
                Toast.makeText(DisplayContactsActivity.this, message,
                        Toast.LENGTH_SHORT).show();
            } else if (error instanceof TimeoutError) {
                message = "Connection TimeOut...Please check your internet connection.";
                Toast.makeText(DisplayContactsActivity.this, message,
                        Toast.LENGTH_SHORT).show();
            }
        }
    };

    /** Creates menu items in toolbar. */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater myMenuInflater = getMenuInflater();
        myMenuInflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.menu_contacts);  //disable "contacts" menu item on toolbar
        item.setVisible(false);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    /**
     * Called when the activity is about to become visible.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    /**
     * Called when the activity has become visible.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    /**
     * Called when another activity is taking focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    /**
     * Called when the activity is no longer visible.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    /**
     * Called just before the activity is destroyed.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    /**
     * Called when the user taps a menu item on the action bar
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

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
                Toast.makeText(DisplayContactsActivity.this, "no settings to show",
                        Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}