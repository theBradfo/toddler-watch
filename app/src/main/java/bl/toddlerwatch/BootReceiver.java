package bl.toddlerwatch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by theBradfo on 7/30/2016.
 */

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent myIntent = new Intent(context, ToddlerWatchService.class);
        context.startService(myIntent);

    }
}