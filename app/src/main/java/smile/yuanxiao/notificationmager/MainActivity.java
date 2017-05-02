package smile.yuanxiao.notificationmager;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int TYPE_NOMAL = 1;
    public static final int TYPE_DOWNLOAD = 2;
    public static final int BIGTEXTSTYLE = 3;
    public static final int INDEX_BOX = 4;
    public static final int BIG_BITMAP = 5;
    public static final int HEADED_UP=6;


    android.app.NotificationManager manager;


    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what < 100) {
                mRemoteViews.setTextViewText(R.id.tv_progress, msg.what + "%");
                mRemoteViews.setProgressBar(R.id.notifi_progressbar, 100, msg.what, false);
                manager.notify(TYPE_DOWNLOAD, notification);
            } else {
                mRemoteViews.setTextViewText(R.id.tv_progress, "下载完成");
            }
        }
    };

    /*http://blog.csdn.net/w804518214/article/details/51231946*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (android.app.NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        findViewById(R.id.notification_nomal).setOnClickListener(this);
        findViewById(R.id.notification_download).setOnClickListener(this);
        findViewById(R.id.notification_bigtextstyle).setOnClickListener(this);
        findViewById(R.id.notification_IndexBox).setOnClickListener(this);
        findViewById(R.id.notification_BigBitmap).setOnClickListener(this);
        findViewById(R.id.notification_FullScreen).setOnClickListener(this);
    }

    Notification notification;
    RemoteViews mRemoteViews;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.notification_nomal:
                NotificationManager.NOTIFICATION_MANAGER.NomalNotifi(this, manager, TYPE_NOMAL);
                break;
            case R.id.notification_download:
                notification = NotificationManager.NOTIFICATION_MANAGER.DownloadNotification(this, manager, TYPE_NOMAL);
                mRemoteViews = notification.contentView;

                for (int i = 1; i <= 100; i++) {
                    final int finalI = i;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            mHandler.sendEmptyMessage(finalI);
                        }
                    }).start();

                }

                break;
            case R.id.notification_bigtextstyle:
                NotificationManager.NOTIFICATION_MANAGER.BigTextStyleNotification(this, manager);
                break;
            case R.id.notification_IndexBox:
                NotificationManager.NOTIFICATION_MANAGER.inBoxStyle(this, manager);
                break;
            case R.id.notification_BigBitmap:
                NotificationManager.NOTIFICATION_MANAGER.bigPictureStyle(this, manager);
                break;
            case R.id.notification_FullScreen:
                break;
        }

    }
}
