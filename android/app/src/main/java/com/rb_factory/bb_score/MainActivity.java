package com.rb_factory.bb_score;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.rb_factory.bb_score.industry_facility.IndustryFacility;
import com.rb_factory.bb_score.location.Location;
import org.apache.commons.lang3.StringUtils;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Controller controller;


    private AutoCompleteTextView searchAutoComplete;
    private Button btnAdd;
    private ArrayAdapter<String> searchAdapter;

    private Location currentLocation;
    private String selectedLocationId = StringUtils.EMPTY;

    private final View.OnClickListener searchOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            currentLocation = controller.searchLocation(((EditText) findViewById(R.id.view_search)).getText());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new Controller(MainActivity.this);
        searchAutoComplete = findViewById(R.id.view_search);
        btnAdd = findViewById(R.id.btn_addLocation);
        searchAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, controller.getLocations());

        btnAdd.setOnClickListener(searchOnClick);

        searchAutoComplete.setAdapter(searchAdapter);
        searchAutoComplete.setOnItemSelectedListener(this);
    }

    private void buildFacilityLayout(Location location) {
        LinearLayout vertical = findViewById(R.id.vertical_layout);


        for (IndustryFacility industryFacility : location.getIndustryFacilities()) {
            LinearLayout horizontal = new LinearLayout(this);
            TextView name = new TextView(this);
            name.setText(industryFacility.getType().toString());
            horizontal.addView(name);


        }
        //vertical.addView(horizontal);


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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedLocationId = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}