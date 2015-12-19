package complexability.motionmusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.csounds.CsoundObj;
import com.csounds.CsoundObjListener;
import com.csounds.bindings.CsoundBinding;

import java.io.File;


import csnd6.CsoundMYFLTArray;
import csnd6.controlChannelType;

public class CSoundTest extends BaseCsoundActivity implements CsoundObjListener, CsoundBinding {
    public View multiTouchView;

    //protected CsoundObj csoundObj = new CsoundObj(false,true);

    /**
     * Variables
     */
    int touchIds[] = new int[10];
    float touchX[] = new float[10];
    float touchY[] = new float[10];

    CsoundMYFLTArray touchXPtr[] = new CsoundMYFLTArray[10];
    CsoundMYFLTArray touchYPtr[] = new CsoundMYFLTArray[10];


    protected int getTouchIdAssignment(){
        Log.d("testCsound", "getTouchIdAssignment()");
        int i;
        for (i = 0 ; i < touchIds.length ; i++);{
            if (touchIds[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    protected int getTouchId(int touchId) {
        Log.d("testCsound", "getTouchId()");
        for (int i = 0; i < touchIds.length; i++) {
            if (touchIds[i] == touchId) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("testCsound", "onCreate()");
        for (int i = 0 ; i < touchIds.length ; i++){
            touchIds[i] = -1;
            touchX[i] = -1;
            touchY[i] = -1;
        }
        multiTouchView = new View(this);
        multiTouchView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("csoundTest", "listener");

                final int action = event.getAction() & MotionEvent.ACTION_MASK;
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_POINTER_DOWN:

                        for (int i = 0; i < event.getPointerCount(); i++) {
                            int pointerId = event.getPointerId(i);
                            int id = getTouchId(pointerId);

                            if (id == -1) {

                                id = getTouchIdAssignment();

                                if (id != -1) {
                                    touchIds[id] = pointerId;
                                    touchX[id] = event.getX(i)
                                            / multiTouchView.getWidth();
                                    touchY[id] = 1 - (event.getY(i) / multiTouchView
                                            .getHeight());

                                    if (touchXPtr[id] != null) {
                                        touchXPtr[id].SetValue(0, touchX[id]);
                                        touchYPtr[id].SetValue(0, touchY[id]);

                                        csoundObj.sendScore(String.format(
                                                "i1.%d 0 -2 %d", id, id));
                                    }
                                }
                            }

                        }

                        break;
                    case MotionEvent.ACTION_MOVE:
                        for (int i = 0; i < event.getPointerCount(); i++) {
                            int pointerId = event.getPointerId(i);
                            int id = getTouchId(pointerId);

                            if (id != -1) {
                                touchX[id] = event.getX(i)
                                        / multiTouchView.getWidth();
                                touchY[id] = 1 - (event.getY(i) / multiTouchView
                                        .getHeight());
                            }

                        }
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                    case MotionEvent.ACTION_UP: {
                        int activePointerIndex = event.getActionIndex();
                        int pointerId = event.getPointerId(activePointerIndex);

                        int id = getTouchId(pointerId);
                        if (id != -1) {
                            touchIds[id] = -1;
                            csoundObj.sendScore(String.format("i-1.%d 0 0 %d", id,
                                    id));
                        }

                    }
                    break;
                }
                return true;            }
        });
        String csd = getResourceFileAsString(R.raw.multitouch_xy);
        setContentView(R.layout.activity_csound_test);
        File f = createTempFile(csd);

        csoundObj.addBinding(this);

        csoundObj.startCsound(f);
    }


    @Override
    public void setup(CsoundObj csoundObj) {
        for (int i = 0; i < touchIds.length; i++) {
            Log.d("testCsound", "setup()");
            touchXPtr[i] = csoundObj.getInputChannelPtr(
                    String.format("touch.%d.x", i),
                    controlChannelType.CSOUND_CONTROL_CHANNEL);
            touchYPtr[i] = csoundObj.getInputChannelPtr(
                    String.format("touch.%d.y", i),
                    controlChannelType.CSOUND_CONTROL_CHANNEL);
        }
    }

    @Override
    public void updateValuesToCsound() {
        for (int i = 0; i < touchX.length; i++) {
            touchXPtr[i].SetValue(0, touchX[i]);
            touchYPtr[i].SetValue(0, touchY[i]);
        }
    }

    @Override
    public void updateValuesFromCsound() {}


    @Override
    public void cleanup() {
        for (int i = 0; i < touchIds.length; i++) {
            touchXPtr[i].Clear();
            touchXPtr[i] = null;
            touchYPtr[i].Clear();
            touchYPtr[i] = null;
        }
    }

    @Override
    public void csoundObjStarted(CsoundObj csoundObj) {}

    @Override
    public void csoundObjCompleted(CsoundObj csoundObj) {}

}
