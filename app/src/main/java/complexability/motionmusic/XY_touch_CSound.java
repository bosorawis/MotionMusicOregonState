package complexability.motionmusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.csounds.CsoundObj;

import java.io.File;

import csnd6.Csound;

public class XY_touch_CSound extends BaseCsoundActivity {
    private CsoundObj csoundObj;
    Button startCsound, stopCsound, button1;
    SeekBar seekBar1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xy_touch__csound);
        Log.d("XY_sound", "onCreate()");

        csoundObj   = new CsoundObj();
        startCsound = (Button) findViewById(R.id.StartCsound);
        stopCsound  = (Button) findViewById(R.id.StopCsound);
        button1     = (Button) findViewById(R.id.Button1);
        seekBar1    = (SeekBar) findViewById(R.id.SeekBar1);
        // Set Listeners for stuff
        startCsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("XY_touch", "onClick()");
                /*
                csoundObj.addSlider(seekBar1, "seekBar1", 0, 1);
                csoundObj.addButton(button1, "button1");
                csoundObj.startCsound(createTempFile(getResourceFileAsString(R.raw.button_test)));
                */
            }
        });
        stopCsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                csoundObj.stop();
            }
        });
    }



}
