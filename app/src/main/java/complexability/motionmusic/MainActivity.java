package complexability.motionmusic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import complexability.motionmusic.R;

public class MainActivity extends AppCompatActivity {
    public SharedPreferences prefs;
    private Hands rightHand = new Hands();
    private Hands leftHand  = new Hands();
    /*
    private int leftEffectCount;
    private int rightEffectCount;
    private String LeftInstrument;
    private String RightInstrument;
    private String LeftEffect_1, LeftEffect_2, LeftEffect_3;
    private String RightEffect_1, RightEffect_2, RightEffect_3;
    */
    Spinner leftInstrumentSpinner;
    Spinner rightInstrumentSpinner;
    Spinner leftEffectSpinner_1;
    Spinner leftEffectSpinner_2;
    Spinner leftEffectSpinner_3;
    Spinner rightEffectSpinner_1;
    Spinner rightEffectSpinner_2;
    Spinner rightEffectSpinner_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**********************************************************************************************
         *Create Left Instrument spinner
         ***********************************************************************************************/
        leftInstrumentSpinner = (Spinner) findViewById(R.id.left_instrument_spinner);
        ArrayAdapter<CharSequence> leftInstrumentAdapter = ArrayAdapter.createFromResource(this, R.array.Instruments_array, android.R.layout.simple_spinner_dropdown_item);
        leftInstrumentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        leftInstrumentSpinner.setAdapter(leftInstrumentAdapter);
        leftInstrumentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /*
            Event handler for the effect dropdown menus
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //LeftInstrument =  (String) parent.getItemAtPosition(position);
                leftHand.changeInstrument((String) parent.getItemAtPosition(position));
                Log.d("Selected Item", "Left Instrument:" + leftHand.getInstrument());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        /**********************************************************************************************
         *Create Right Instrument spinner
         ***********************************************************************************************/
        rightInstrumentSpinner = (Spinner) findViewById(R.id.right_instrument_spinner);
        ArrayAdapter<CharSequence> rightInstrumentAdapter = ArrayAdapter.createFromResource(this, R.array.Instruments_array, android.R.layout.simple_spinner_dropdown_item);
        rightInstrumentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rightInstrumentSpinner.setAdapter(rightInstrumentAdapter);
        rightInstrumentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //RightInstrument =  (String) parent.getItemAtPosition(position);
                //Log.d("Selected Item", "Right Instrument:" + RightInstrument);
                rightHand.changeInstrument((String) parent.getItemAtPosition(position));
                Log.d("Selected Item", "Right Instrument:" + rightHand.getInstrument());
                /*
                if(RightInstrument!=null) {
                    rightHand.changeInstrument(RightInstrument);
                    Log.d("Selected Item", "Right Instrument:" + rightHand.getInstrument());
                }
                */
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //====================================================================================================================================================================
        /**********************************************************************************************
         *Left Create effect 1 spinner
         ***********************************************************************************************/
        leftEffectSpinner_1 = (Spinner) findViewById(R.id.left_effect_1_spinner);
        ArrayAdapter<CharSequence> leftEffectAdapter_1 = ArrayAdapter.createFromResource(this, R.array.EffectName_array, android.R.layout.simple_spinner_dropdown_item);
        leftEffectAdapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        leftEffectSpinner_1.setAdapter(leftEffectAdapter_1);
        leftEffectSpinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //LeftEffect_1 = (String) parent.getItemAtPosition(position);
                //Log.d("Selected Item", "Left Effect_1:" + LeftEffect_1);
               // if(LeftInstrument != null){
                leftHand.changeEffect((String) parent.getItemAtPosition(position), 1);
                Log.d("Selected Item", "Left Effect_1:" + leftHand.getEffect(1));

                //}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /**********************************************************************************************
         *Left Create effect 2 spinner
         ***********************************************************************************************/
        leftEffectSpinner_2 = (Spinner) findViewById(R.id.left_effect_2_spinner);
        ArrayAdapter<CharSequence> leftEffectAdapter_2 = ArrayAdapter.createFromResource(this, R.array.EffectName_array, android.R.layout.simple_spinner_dropdown_item);
        leftEffectAdapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        leftEffectSpinner_2.setAdapter(leftEffectAdapter_2);
        leftEffectSpinner_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //LeftEffect_2 = (String) parent.getItemAtPosition(position);
                leftHand.changeEffect((String) parent.getItemAtPosition(position), 2);
                Log.d("Selected Item", "Left Effect_2:" + leftHand.getEffect(2));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /**********************************************************************************************
         *Left Create effect 3 spinner
         ***********************************************************************************************/
        leftEffectSpinner_3 = (Spinner) findViewById(R.id.left_effect_3_spinner);
        ArrayAdapter<CharSequence> leftEffectAdapter_3 = ArrayAdapter.createFromResource(this, R.array.EffectName_array, android.R.layout.simple_spinner_dropdown_item);
        leftEffectAdapter_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        leftEffectSpinner_3.setAdapter(leftEffectAdapter_3);
        leftEffectSpinner_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //LeftEffect_3= (String) parent.getItemAtPosition(position);
                //Log.d("Selected Item", "Left Effect_3:" + LeftEffect_3);
                leftHand.changeEffect((String) parent.getItemAtPosition(position), 3);
                Log.d("Selected Item", "Left Effect_3:" + leftHand.getEffect(3));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //====================================================================================================================================================================
        //====================================================================================================================================================================
        /**********************************************************************************************
         *Right Create effect 1 spinner
         ***********************************************************************************************/
        rightEffectSpinner_1 = (Spinner) findViewById(R.id.right_effect_1_spinner);
        ArrayAdapter<CharSequence> rightEffectAdapter_1 = ArrayAdapter.createFromResource(this, R.array.EffectName_array, android.R.layout.simple_spinner_dropdown_item);
        rightEffectAdapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rightEffectSpinner_1.setAdapter(rightEffectAdapter_1);
        rightEffectSpinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //RightEffect_1 = (String) parent.getItemAtPosition(position);
                //Log.d("Selected Item", "RightEffect_1:" + RightEffect_1);
                rightHand.changeEffect((String) parent.getItemAtPosition(position), 1);
                Log.d("Selected Item", "Right Effect_1:" + rightHand.getEffect(1));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /**********************************************************************************************
         *Right Create effect 2 spinner
         ***********************************************************************************************/
        rightEffectSpinner_2 = (Spinner) findViewById(R.id.right_effect_2_spinner);
        ArrayAdapter<CharSequence> rightEffectAdapter_2 = ArrayAdapter.createFromResource(this, R.array.EffectName_array, android.R.layout.simple_spinner_dropdown_item);
        rightEffectAdapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rightEffectSpinner_2.setAdapter(rightEffectAdapter_2);
        rightEffectSpinner_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //RightEffect_2 = (String) parent.getItemAtPosition(position);
                //Log.d("Selected Item", "RightEffect_2:" + RightEffect_2);
                rightHand.changeEffect((String) parent.getItemAtPosition(position), 2);
                Log.d("Selected Item", "Right Effect_2:" + rightHand.getEffect(2));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /**********************************************************************************************
         *Right Create effect 3 spinner
         ***********************************************************************************************/
        rightEffectSpinner_3 = (Spinner) findViewById(R.id.right_effect_3_spinner);
        ArrayAdapter<CharSequence> rightEffectAdapter_3 = ArrayAdapter.createFromResource(this, R.array.EffectName_array, android.R.layout.simple_spinner_dropdown_item);
        rightEffectAdapter_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rightEffectSpinner_3.setAdapter(rightEffectAdapter_3);
        rightEffectSpinner_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //RightEffect_3 = (String) parent.getItemAtPosition(position);
                //Log.d("Selected Item", "RightEffect_2:" + RightEffect_3);
                rightHand.changeEffect((String) parent.getItemAtPosition(position), 3);
                Log.d("Selected Item", "Right Effect_3:" + rightHand.getEffect(3));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //====================================================================================================================================================================
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("MainActivity", "onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy()");
    }

    public void leftAddEffect(View view){
        Spinner effect_1 = (Spinner) findViewById(R.id.left_effect_1_spinner);
        Spinner effect_2 = (Spinner) findViewById(R.id.left_effect_2_spinner);
        Spinner effect_3 = (Spinner) findViewById(R.id.left_effect_3_spinner);
        leftHand.increaseEffectCount();

        switch(leftHand.getEffectCount()) {
            case 1:
                effect_1.setVisibility(view.VISIBLE);
                break;
            case 2:
                effect_2.setVisibility(view.VISIBLE);
                break;
            case 3:
                effect_3.setVisibility(view.VISIBLE);
                break;
        }

        //Log.d("hello", "leftEffectCount:" + leftEffectCount);
    }
    public void leftRemoveEffect(View view){
        Spinner effect_1 = (Spinner) findViewById(R.id.left_effect_1_spinner);
        Spinner effect_2 = (Spinner) findViewById(R.id.left_effect_2_spinner);
        Spinner effect_3 = (Spinner) findViewById(R.id.left_effect_3_spinner);
        switch(leftHand.getEffectCount()) {
            case 3:
                effect_3.setVisibility(view.GONE);
                break;
            case 2:
                effect_2.setVisibility(view.GONE);
                break;
            case 1:
                effect_1.setVisibility(view.GONE);
                break;
        }

        leftHand.decreaseEffectCount();
        //Log.d("hello", "leftEffectCount:" + leftEffectCount);
    }
    public void rightAddEffect(View view) {
        Spinner effect_1 = (Spinner) findViewById(R.id.right_effect_1_spinner);
        Spinner effect_2 = (Spinner) findViewById(R.id.right_effect_2_spinner);
        Spinner effect_3 = (Spinner) findViewById(R.id.right_effect_3_spinner);
        rightHand.increaseEffectCount();

        //if (rightHand.getEffectCount() < 3) {
        switch (rightHand.getEffectCount()) {
            case 1:
                effect_1.setVisibility(view.VISIBLE);
                break;
            case 2:
                effect_2.setVisibility(view.VISIBLE);
                break;
            case 3:
                effect_3.setVisibility(view.VISIBLE);
                break;
        }
        //}
        //Log.d("hello", "rightEffectCount:" + rightEffectCount);
    }
    public void rightRemoveEffect(View view){
        Spinner effect_1 = (Spinner) findViewById(R.id.right_effect_1_spinner);
        Spinner effect_2 = (Spinner) findViewById(R.id.right_effect_2_spinner);
        Spinner effect_3 = (Spinner) findViewById(R.id.right_effect_3_spinner);
        //if(rightEffectCount > 0) {
        switch(rightHand.getEffectCount()) {
            case 3:
                effect_3.setVisibility(view.GONE);
                break;
            case 2:
                effect_2.setVisibility(view.GONE);
                break;
            case 1:
                effect_1.setVisibility(view.GONE);
                break;
        }
        rightHand.decreaseEffectCount();
            //rightEffectCount--;

        //}
        //Log.d("hello", "leftEffectCount:" + leftEffectCount);
    }
    public void testButtonClicked(View view){

        //SharedPreferences soundPreference = getSharedPreferences("Play_mode", MODE_PRIVATE);
        Log.d("MainActivity", "**************Begin test****************");
        Log.d("MainActivity", "Left Instrument:     " + leftHand.getInstrument());
        for(int i = 1 ; i < leftHand.getEffectCount() + 1 ; i++){
            Log.d("MainActivity", "     Left Effect " + i + ": " + leftHand.getEffect(i));
        }
        Log.d("MainActivity", "Right Instrument:    " + rightHand.getInstrument());
        for(int i = 1 ; i < rightHand.getEffectCount() + 1 ; i++){
            Log.d("MainActivity", "     Right Effect " + i + ": " + rightHand.getEffect(i));
        }
        //Pull data from shared reference
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        displayGeneralPreference(sharedPreferences);
        displaySoundPreference(sharedPreferences);

        Log.d("MainActivity", "**************End test****************");

    }

    /**
     * Help function for printing sound preference
     * @param sp - sharedPreference memory
     */
    protected void displaySoundPreference(SharedPreferences sp){
        int Default = -99;
        int LeftInstrumentVol  = sp.getInt("leftInstrumentSeekVolume", Default);
        int RightInstrumentVol = sp.getInt("rightInstrumentSeekVolume", Default);

        int LeftEffect1_volume = sp.getInt("leftEffect_1_volume", Default);
        int LeftEffect1_level  = sp.getInt("leftEffect_1_level", Default);

        int LeftEffect2_volume = sp.getInt("leftEffect_2_volume", Default);
        int LeftEffect2_level  = sp.getInt("leftEffect_2_level", Default);

        int LeftEffect3_volume = sp.getInt("leftEffect_3_volume", Default);
        int LeftEffect3_level  = sp.getInt("leftEffect_3_level", Default);



        int RightEffect1_volume = sp.getInt("rightEffect_1_volume", Default);
        int RightEffect1_level  = sp.getInt("rightEffect_1_level", Default);

        int RightEffect2_volume = sp.getInt("rightEffect_2_volume", Default);
        int RightEffect2_level  = sp.getInt("rightEffect_2_level", Default);

        int RightEffect3_volume = sp.getInt("rightEffect_3_volume", Default);
        int RightEffect3_level  = sp.getInt("rightEffect_3_level", Default);

        boolean Left_enable     = sp.getBoolean("leftInstrumentSwitch", false);
        boolean Right_enable     = sp.getBoolean("rightInstrumentSwitch", false);
        Log.d("MainActivity", "Left Instrument Enabled:" + Left_enable +  "   Left Instrument volume:  " + LeftInstrumentVol + " %");
        Log.d("MainActivity", "     Effect 1 volume:    " + LeftEffect1_volume + "/10     Effect 1 level:     "+ LeftEffect1_level);
        Log.d("MainActivity", "     Effect 2 volume:    " + LeftEffect2_volume + "/10     Effect 2 level:     " + LeftEffect2_level);
        Log.d("MainActivity", "     Effect 3 volume:    " + LeftEffect3_volume + "/10     Effect 3 level:     " + LeftEffect3_level);

        Log.d("MainActivity", "Right Instrument Enabled:" + Right_enable + "   Right Instrument volume: " + RightInstrumentVol + " %");
        Log.d("MainActivity", "     Effect 1 volume:    " + RightEffect1_volume + "/10     Effect 1 level:     "  + RightEffect1_level + "/10");
        Log.d("MainActivity", "     Effect 2 volume:    " + RightEffect2_volume + "/10     Effect 2 level:     "  + RightEffect2_level + "/10");
        Log.d("MainActivity", "     Effect 3 volume:    " + RightEffect3_volume + "/10     Effect 3 level:     "  + RightEffect3_level + "/10");
    }

    /**
     * Help function for printing general reference
     * @param sp
     */
    protected void displayGeneralPreference(SharedPreferences sp){
        String Default = "N/A";
        String Play_mode = sp.getString("Play_mode", Default);
        String Sound_mode = sp.getString("Sound_mode", Default);
        boolean bodyMovement = sp.getBoolean("Enable_body_movement",true);
        //Log.d("MainActivity","Sound mode: " + Play_mode);

        switch(Play_mode){
            case "0":
                Log.d("MainActivity","Play mode:        Hands Orientation Only");
                break;
            case "1":
                Log.d("MainActivity","Play mode:        Hands Orientation and Sweeps");
                break;
            default:
                Log.d("MainActivity","It's broken");
                break;
        }

        switch(Sound_mode){
            case "0":
                Log.d("MainActivity","Sound mode:       Sound Effects");
                break;
            case "1":
                Log.d("MainActivity","Sound mode:       Music");
                break;
            default:
                Log.d("MainActivity","It's broken");
                break;
        }
        Log.d("MainActivity","Enable Body Movement:     " + bodyMovement);
    }
    /*****************************************************
     * Save the instance of the data when changing orientation
     * @param outState
     ******************************************************/
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("save state", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putInt("LEFT_EFFECT_COUNT", leftHand.getEffectCount());
        outState.putInt("RIGHT_EFFECT_COUNT", rightHand.getEffectCount());
    }
    /*****************************************************
     * Retrieve the saved state before recreating the activity
     ******************************************************/
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("Restore","onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        int testLeft;
        int testRight;
        testLeft = savedInstanceState.getInt("LEFT_EFFECT_COUNT");
        testRight = savedInstanceState.getInt("RIGHT_EFFECT_COUNT");

        Log.d("Restored","testLeft:" + testLeft);
        Log.d("Restored", "testRight:" + testRight);

        Spinner left_effect_1 = (Spinner) findViewById(R.id.left_effect_1_spinner);
        Spinner left_effect_2 = (Spinner) findViewById(R.id.left_effect_2_spinner);
        Spinner left_effect_3 = (Spinner) findViewById(R.id.left_effect_3_spinner);

        Spinner right_effect_1 = (Spinner) findViewById(R.id.right_effect_1_spinner);
        Spinner right_effect_2 = (Spinner) findViewById(R.id.right_effect_2_spinner);
        Spinner right_effect_3 = (Spinner) findViewById(R.id.right_effect_3_spinner);

        leftHand.setEffectCount(testLeft);
        rightHand.setEffectCount(testRight);
        for(int i = 1 ; i < testLeft+1 ; i++){
            switch (i) {
                case 1:
                    left_effect_1.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    left_effect_2.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    left_effect_3.setVisibility(View.VISIBLE);
                    break;
            }
        }
        for(int i = 1 ; i < testRight+1 ; i++){
            switch (i) {
                case 1:
                    right_effect_1.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    right_effect_2.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    right_effect_3.setVisibility(View.VISIBLE);
                    break;
            }
        }

    }


    /**
     * Initializing top-right corner menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Function for handling top-right corner option menu
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.d("settings","Setting Clicked!!");
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
    public static String getPref(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }
    */

}


