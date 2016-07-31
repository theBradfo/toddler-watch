package bl.toddlerwatch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Date;

import bl.toddlerwatch.model.TrackedEvent;
import bl.toddlerwatch.service.DataProvider;

import static bl.toddlerwatch.util.Logger.*;

/**
 * Created by theBradfo on 7/30/2016.
 */

public class SystemEventsReceiver extends BroadcastReceiver {
    private static final String TAG = SystemEventsReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        LOGD(TAG, "received message with action "+intent.getAction());

        final Date current = new Date();
        String action = intent.getAction();
        final int id = DataProvider.INSTANCE.getNextId();
        final TrackedEvent event = new TrackedEvent(id, current, action);

        switch (intent.getAction()) {
            // TODO process this data
            case Intent.ACTION_SCREEN_OFF:
            case Intent.ACTION_SCREEN_ON:
            case Intent.ACTION_BOOT_COMPLETED:
            case Intent.ACTION_SHUTDOWN:
                break;
            default:
                LOGE(TAG, "Not sure how to handle action "+intent.getAction());
                break;
        }

        Intent myIntent = new Intent(context, ToddlerWatchService.class);
        myIntent.putExtra(ToddlerWatchService.EXTRA_EVENT_DATA, event);
        context.startService(myIntent);
    }
}