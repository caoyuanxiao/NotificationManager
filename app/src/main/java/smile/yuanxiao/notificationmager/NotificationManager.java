package smile.yuanxiao.notificationmager;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Smile on 2017/5/2.
 */

public enum NotificationManager {
    NOTIFICATION_MANAGER;

    public void NomalNotifi(Context mContext, android.app.NotificationManager manager, int type) {
        //为了版本兼容  选择V7包下的NotificationCompat进行构造
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);
        //Ticker是状态栏显示的提示
        builder.setTicker("简单Notification");
        //第一行内容  通常作为通知栏标题
        builder.setContentTitle("标题");
        //第二行内容 通常是通知正文
        builder.setContentText("通知内容");
        //第三行内容 通常是内容摘要什么的 在低版本机器上不一定显示
        builder.setSubText("这里显示的是通知第三行内容！");
        //ContentInfo 在通知的右侧 时间的下面 用来展示一些其他信息
        //builder.setContentInfo("2");
        //number设计用来显示同种通知的数量和ContentInfo的位置一样，如果设置了ContentInfo则number会被隐藏
        builder.setNumber(2);
        //可以点击通知栏的删除按钮删除
        builder.setAutoCancel(true);
        //系统状态栏显示的小图标
        builder.setSmallIcon(R.mipmap.ic_launcher);
        //下拉显示的大图标
        builder.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_stat_name));
        PendingIntent pengdingIntent = createPengdingIntent(mContext);
        //点击跳转的intent
        builder.setContentIntent(pengdingIntent);
        //通知默认的声音 震动 呼吸灯
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification notification = builder.build();
        manager.notify(type, notification);
    }

    public PendingIntent createPengdingIntent(Context mContext) {
        Intent intent = new Intent(mContext, NotificationActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(mContext, 1, intent, 0);
        return pIntent;

    }
}
