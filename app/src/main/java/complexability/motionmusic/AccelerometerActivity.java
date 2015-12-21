package complexability.motionmusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.csounds.CsoundObj;
import com.csounds.CsoundObjListener;
import com.csounds.bindings.CsoundBinding;
import com.csounds.bindings.motion.CsoundMotion;

import java.io.File;

public class AccelerometerActivity extends BaseCsoundActivity implements CsoundObjListener, CsoundBinding {

    ToggleButton startStopButton = null;
    //CsoundObj csoundObj = new CsoundObj();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        startStopButton = (ToggleButton) findViewById(R.id.onOffButton);

        startStopButton
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            String csd = getResourceFileAsString(R.raw.hardware_test);
                            File f = createTempFile(csd);

                            CsoundMotion csoundMotion = new CsoundMotion(csoundObj);
                            csoundMotion.enableAccelerometer(AccelerometerActivity.this);

                            csoundObj.startCsound(f);
                        }
                        else{
                            csoundObj.stop();
                        }
                    }
                });
    }

    @Override
    public void csoundObjStarted(CsoundObj csoundObj) {

    }

    @Override
    public void csoundObjCompleted(CsoundObj csoundObj) {
        handler.post(new Runnable() {
            public void run() {
                startStopButton.setChecked(false);
            }
        });
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
