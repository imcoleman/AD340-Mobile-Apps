package com.icoleman.ad340app;

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

import java.util.ArrayList;
import java.util.List;

public class DisplayContactsActivity extends AppCompatActivity {
    private static final String TAG = DisplayContactsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contacts);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<Data> data = fill_with_data();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

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

    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("Alika Carey", "(886) 553-8836"));
        data.add(new Data("Alisa Trevino", "(131) 615-8532"));
        data.add(new Data("Amal Rollins", "(279) 221-4269"));
        data.add(new Data("Astra Farrell", "(467) 414-1067"));
        data.add(new Data("Aubrey Nolan", "(241) 548-4204"));
        data.add(new Data("Ayanna Nichols", "(145) 128-0439"));
        data.add(new Data("Beck Wooten", "(322) 521-4045"));
        data.add(new Data("Benedict Wilder", "(467) 347-0218"));
        data.add(new Data("Brenden Blanchard", "(492) 694-6460"));
        data.add(new Data("Brynn Hart", "(169) 807-9369"));
        data.add(new Data("Burton Lawrence", "(193) 973-2479"));
        data.add(new Data("Cairo Martin", "(218) 313-3221"));
        data.add(new Data("Carla Mccall", "(835) 839-9518"));
        data.add(new Data("Carlos Jordan", "(890) 903-5231"));
        data.add(new Data("Casey Vinson", "(670) 826-4704"));
        data.add(new Data("Chava Blankenship", "(227) 653-4691"));
        data.add(new Data("Chester Franco", "(688) 783-7793"));
        data.add(new Data("Cole Wong", "(977) 150-7743"));
        data.add(new Data("Colton Olson", "(841) 316-3553"));
        data.add(new Data("Courtney Olson", "(973) 699-9418"));
        data.add(new Data("Dahlia Jones", "(687) 265-1644"));
        data.add(new Data("Debra Trujillo", "(442) 157-6842"));
        data.add(new Data("Dorian Lowery", "(889) 890-2220"));
        data.add(new Data("Dylan Zimmerman", "(533) 550-7339"));
        data.add(new Data("Emerson Moon", "(913) 233-9680"));
        data.add(new Data("Ferris Blanchard", "(191) 344-1222"));
        data.add(new Data("Fleur Sanders", "(964) 130-5023"));
        data.add(new Data("Gareth Le", "(444) 565-8048"));
        data.add(new Data("Giacomo Douglas", "(964) 877-9606"));
        data.add(new Data("Gray Davidson", "(959) 702-7811"));
        data.add(new Data("Gwendolyn Stanley", "(614) 823-3857"));
        data.add(new Data("Hammett Martinez", "(299) 206-7956"));
        data.add(new Data("Ignacia Holloway", "(378) 446-8718"));
        data.add(new Data("India Dickson", "(496) 921-4716"));
        data.add(new Data("Isabella Jacobs", "(801) 399-8954"));
        data.add(new Data("Jakeem Hahn", "(678) 531-3767"));
        data.add(new Data("Jonah Landry", "(364) 220-0536"));
        data.add(new Data("Kaitlin Bennett", "(879) 280-0844"));
        data.add(new Data("Kamal Neal", "(279) 972-0629"));
        data.add(new Data("Kareem Sanders", "(992) 418-3055"));
        data.add(new Data("Karly Freeman", "(584) 191-5764"));
        data.add(new Data("Kessie Barr", "(746) 918-8417"));
        data.add(new Data("Lacy Landry", "(665) 519-9461"));
        data.add(new Data("Laith Wood", "(844) 215-6086"));
        data.add(new Data("Lance Dawson", "(550) 572-2372"));
        data.add(new Data("Laura Hayes", "(850) 615-7853"));
        data.add(new Data("Laura Hurley", "(293) 940-2454"));
        data.add(new Data("Laurel Reed", "(960) 347-6588"));
        data.add(new Data("Lester Wiggins", "(816) 665-5813"));
        data.add(new Data("Lila Gay", "(739) 915-9351"));
        data.add(new Data("Lucas Knight", "(910) 689-7505"));
        data.add(new Data("Madaline Nichols", "(223) 248-3927"));
        data.add(new Data("Madeson Hurley", "(810) 688-6444"));
        data.add(new Data("Maggy Ball", "(524) 104-5860"));
        data.add(new Data("Marah Larson", "(260) 557-9995"));
        data.add(new Data("Marshall Monroe", "(210) 358-7849"));
        data.add(new Data("Maryam Leach", "(474) 432-8218"));
        data.add(new Data("Melodie Blair", "(221) 666-0226"));
        data.add(new Data("Miriam Garcia", "(672) 472-8097"));
        data.add(new Data("Nerea Solis", "(503) 979-1929"));
        data.add(new Data("Nicholas Zamora", "(787) 921-9582"));
        data.add(new Data("Nina Witt", "(677) 336-3423"));
        data.add(new Data("Nissim Harrell", "(975) 614-9065"));
        data.add(new Data("Odessa Holloway", "(558) 660-4757"));
        data.add(new Data("Otto Rocha", "(855) 218-3551"));
        data.add(new Data("Penelope Howell", "(104) 122-1485"));
        data.add(new Data("Penelope Sandoval", "(444) 775-6532"));
        data.add(new Data("Petra Cline", "(770) 907-4341"));
        data.add(new Data("Phyllis Kane", "(489) 255-3383"));
        data.add(new Data("Quintessa Anderson", "(312) 203-0099"));
        data.add(new Data("Rana Cruz", "(449) 628-3798"));
        data.add(new Data("Raymond Dalton", "(964) 332-9477"));
        data.add(new Data("Reese Clements", "(785) 633-8631"));
        data.add(new Data("Rhiannon Noble", "(591) 550-8222"));
        data.add(new Data("Rinah Massey", "(890) 801-8065"));
        data.add(new Data("Rogan Dodson", "(256) 821-0263"));
        data.add(new Data("Ross Hutchinson", "(992) 856-4054"));
        data.add(new Data("Ruby George", "(859) 764-7296"));
        data.add(new Data("Ryder Irwin", "(893) 260-1224"));
        data.add(new Data("Sharon Mcbride", "(111) 721-1209"));
        data.add(new Data("Sheila Mcconnell", "(675) 260-1015"));
        data.add(new Data("Shellie Lester", "(744) 503-5125"));
        data.add(new Data("Skyler Santiago", "(630) 806-8410"));
        data.add(new Data("Solomon Rios", "(451) 939-0769"));
        data.add(new Data("Sophia Watson", "(954) 883-7848"));
        data.add(new Data("Suki Monroe", "(656) 187-1267"));
        data.add(new Data("Taylor Ballard", "(198) 768-6433"));
        data.add(new Data("Tyler Vinson", "(108) 882-5275"));
        data.add(new Data("Uma Collins", "(268) 340-8851"));
        data.add(new Data("Velma Gutierrez", "(148) 679-3049"));
        data.add(new Data("Vera Cook", "(875) 609-6511"));
        data.add(new Data("Victor Gentry", "(922) 414-1835"));
        data.add(new Data("Vincent Houston", "(436) 944-5495"));
        data.add(new Data("Vivien Freeman", "(938) 829-7002"));
        data.add(new Data("Xander Faulkner", "(366) 846-3141"));
        data.add(new Data("Xander Huffman", "(276) 674-1140"));
        data.add(new Data("Xerxes Riley", "(512) 715-8832"));
        data.add(new Data("Xerxes Ward", "(896) 755-8137"));
        data.add(new Data("Yuri Cross", "(741) 182-7575"));
        data.add(new Data("Yvette Beard", "(430) 913-9262"));

        return data;
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