package complexability.motionmusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.csounds.CsoundObj;
import com.csounds.CsoundObjListener;
import com.csounds.bindings.CsoundBinding;
import com.csounds.bindings.ui.CsoundUI;


import java.io.File;

import csnd6.Csound;

public class XY_touch_CSound extends BaseCsoundActivity implements CsoundObjListener, CsoundBinding {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xy_touch__csound);
        Log.d("XY_sound", "onCreate()");

    }

    @Override
    public void csoundObjStarted(CsoundObj csoundObj) {

    }

    @Override
    public void csoundObjCompleted(CsoundObj csoundObj) {

    }

    @Override
    public void setup(CsoundObj csoundObj) {

    }

    @Override
    public void updateValuesToCsound() {

    }

    @Override
    public void updateValuesFromCsound() {

    }

    @Override
    public void cleanup() {

    }
}
