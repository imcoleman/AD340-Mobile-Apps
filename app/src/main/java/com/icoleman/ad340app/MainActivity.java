package com.icoleman.ad340app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.ListAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.icoleman.ad340app.MESSAGE";

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
