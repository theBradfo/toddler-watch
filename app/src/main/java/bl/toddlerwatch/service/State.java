package bl.toddlerwatch.service;

import android.content.Intent;

import static bl.toddlerwatch.util.Logger.LOGW;

/**
 * Created by theBr on 7/30/2016.
 */

public enum State {
    SLEEP,
    AWAKE,
    BOOT,
    SHUT_DOWN;

    private static final String TAG = State.class.getSimpleName();

    public static State fromAction(String action) {
        switch (action) {
            case Intent.ACTION_SCREEN_OFF:
                return SLEEP;
            case Intent.ACTION_SCREEN_ON:
                return AWAKE;
            case Intent.ACTION_BOOT_COMPLETED:
                return BOOT;
            case Intent.ACTION_SHUTDOWN:
                return SHUT_DOWN;
            default:
                LOGW(TAG, "Unable to find state for action " + action);
                return null;
        }
    }
}
