package smile.yuanxiao.notificationmager;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int TYPE_NOMAL = 1;
    android.app.NotificationManager manager;

    /*http://blog.csdn.net/w804518214/article/details/51231946*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (android.app.NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        findViewById(R.id.notification_nomal).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.notification_nomal:
                NotificationManager.NOTIFICATION_MANAGER.NomalNotifi(this, manager, TYPE_NOMAL);
                break;
        }
        ;
    }
}
