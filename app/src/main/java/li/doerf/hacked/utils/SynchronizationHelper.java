package li.doerf.hacked.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import li.doerf.hacked.R;
import li.doerf.hacked.services.ScheduledCheckService;

/**
 * Created by moo on 08/09/16.
 */
public class SynchronizationHelper {
    private static final String LOGTAG = "SynchronizationHelper";

    public static void scheduleSync(Context aContext) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(aContext);
        disableSync(aContext);
        if (settings.getBoolean(aContext.getString(R.string.pref_key_sync_enable), false)) {
            // TODO reenable after testing
//            enableSync(aContext, AlarmManager.INTERVAL_HALF_HOUR);
            enableSync(aContext, 15000);
        }
    }

    private static void enableSync(Context aContext, long aInterval) {
        PendingIntent ktipsync = getPendingIntent(aContext);

        AlarmManager alarmManager = (AlarmManager) aContext.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
                0,
                aInterval,
                ktipsync);
        Log.i(LOGTAG, "scheduled service to run every " + aInterval + " ms");
    }

    private static PendingIntent getPendingIntent(Context aContext) {
        Intent i = new Intent(aContext, ScheduledCheckService.class);
        return PendingIntent.getService(aContext, 0, i, 0);
    }

    private static void disableSync(Context aContext) {
        AlarmManager alarmManager = (AlarmManager) aContext.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(getPendingIntent(aContext));
        Log.i(LOGTAG, "cancelled pending intent");
    }
}