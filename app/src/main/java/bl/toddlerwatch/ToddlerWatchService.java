package bl.toddlerwatch;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import bl.toddlerwatch.model.TrackedEvent;
import bl.toddlerwatch.service.EventStateMachine;

import static bl.toddlerwatch.util.Logger.*;

public class ToddlerWatchService extends Service {
    private static final String TAG = ToddlerWatchService.class.getSimpleName();
    public static final String EXTRA_EVENT_DATA = "extra_event_data";

    public ToddlerWatchService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        TrackedEvent event = intent.getParcelableExtra(EXTRA_EVENT_DATA);

        LOGD(TAG, "received: "+event);
        if (event != null) {
            // process this event
            EventStateMachine.INSTANCE.nextState(event);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
