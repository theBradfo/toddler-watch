package bl.toddlerwatch.util;

import android.util.Log;

/**
 * Created by theBr on 7/30/2016.
 */

public final class Logger {
    private Logger() { }

    public static void LOGI(String tag, String message) {
        Log.i(tag, message);
    }

    public static void LOGD(String tag, String message) {
        Log.d(tag, message);
    }

    public static void LOGE(String tag, String message) {
        Log.e(tag, message);
    }

    public static void LOGE(String tag, String message, final Throwable throwable) {
        Log.e(tag, message, throwable);
    }
}
