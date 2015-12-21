package complexability.motionmusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.csounds.CsoundObj;
import com.csounds.CsoundObjListener;
import com.csounds.bindings.ui.CsoundUI;


import java.io.File;

import csnd6.Csound;

public class XY_touch_CSound extends BaseCsoundActivity implements CsoundObjListener{
    private CsoundObj csoundObj = new CsoundObj();
    //CsoundUI csoundUI = new CsoundUI(csoundObj);
    Button startCsound, stopCsound, button1;
    SeekBar seekBar1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xy_touch__csound);
        Log.d("XY_sound", "onCreate()");

        startCsound = (Button)  findViewById(R.id.StartCsound);
        stopCsound  = (Button)  findViewById(R.id.StopCsound);
        button1     = (Button)  findViewById(R.id.Button1);
        seekBar1    = (SeekBar) findViewById(R.id.SeekBar1);
        // Set Listeners for stuff
        startCsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("XY_touch", "onClick()");
                String csd = getResourceFileAsString(R.raw.test);
                File f = createTempFile(csd);
                CsoundUI csoundUI = new CsoundUI(csoundObj);
                csoundUI.addSlider(seekBar1, "SeekBar1", 0.0, 1.0);
                //csoundUI.addButton(button1, "button1");
                csoundObj.addListener(XY_touch_CSound.this);
                csoundObj.startCsound(createTempFile(getResourceFileAsString(R.raw.test)));

            }
        });
        stopCsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                csoundObj.stop();
            }
        });
    }


    @Override
    public void csoundObjStarted(CsoundObj csoundObj) {

    }

    @Override
    public void csoundObjCompleted(CsoundObj csoundObj) {

    }
}
