package smile.yuanxiao.notificationmager.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.RemoteInput;
import android.widget.Toast;

import static smile.yuanxiao.notificationmager.manager.NotificationManager.KEY_TEXT_REPLY;

/**
 * Created by Smile on 2017/5/2.
 */

public class RemoteReciver extends BroadcastReceiver {

    public static final String ACTION_REPLY = "QUIKLY_REPLY";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        Bundle bundle = intent.getExtras();
        if (remoteInput != null && bundle != null) {
            if (intent.getAction().equals(ACTION_REPLY)) {
                android.app.NotificationManager manager = (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                Toast.makeText(context, remoteInput.getCharSequence(KEY_TEXT_REPLY).toString(), Toast.LENGTH_SHORT).show();
                manager.cancel(10);
            }
        }
    }


}
