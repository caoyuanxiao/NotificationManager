package smile.yuanxiao.notificationmager;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;
import android.widget.RemoteViews;

/**
 * Created by Smile on 2017/5/2.
 */

public enum NotificationManager {
    NOTIFICATION_MANAGER;

    public void NomalNotifi(Context mContext, android.app.NotificationManager manager, int type) {
        //为了版本兼容  选择V7包下的NotificationCompat进行构造
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);
        //Ticker是状态栏显示的提示  这里的提示仅仅是针对android5.0以下才可以显示
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
        builder.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher_round));
        PendingIntent pengdingIntent = createPengdingIntent(mContext);
        //点击跳转的intent
        builder.setContentIntent(pengdingIntent);
        //通知默认的声音 震动 呼吸灯
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification notification = builder.build();
        manager.notify(type, notification);
    }


    public Notification DownloadNotification(Context mContext, android.app.NotificationManager manager, int type) {
        int progress = 10;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher_round));
        //禁止用户点击删除按钮删除
        builder.setAutoCancel(false);
        //禁止滑动删除
        // builder.setOngoing(true);
        //取消右上角的时间显示
        // builder.setShowWhen(false);
        PendingIntent pengdingIntent = createPengdingIntent(mContext);
        builder.setContentIntent(pengdingIntent);

        RemoteViews remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.download_progress);
        // builder.setCustomContentView(remoteViews);
//        builder.setContentTitle("下载中..."+progress+"%");
//        builder.setProgress(100,progress,false);
        //builder.setContentInfo(progress+"%");

//        Intent intent = new Intent(this,DownloadService.class);
//        intent.putExtra("command",1);
        Notification notification = builder.build();
        notification.contentView = remoteViews;
        // manager.notify(type,notification);
        return notification;

    }

    /**
     * 点击后展开可显示大段文字内容的通知
     * 只有在首界面才会全部显示
     * 1. 使用类 Android.support.v4.app.NotificationCompat.BigTextStyle
     2. 在低版本系统上只显示点击前的普通通知样式 如4.4可以点击展开，在4.0系统上就不行
     3. 点击前后的ContentTitle、ContentText可以不一致，bigText内容可以自动换行 好像最多5行的样子
     *
     * @param mContext
     * @param manager
     */
    public void BigTextStyleNotification(Context mContext, android.app.NotificationManager manager) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);
        builder.setContentTitle("BigTextStyle");
        builder.setContentText("BigTextStyle演示示例");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher_round));
        android.support.v4.app.NotificationCompat.BigTextStyle style = new android.support.v4.app.NotificationCompat.BigTextStyle();
        style.bigText("这里是点击通知后要显示的正文，可以换行可以显示很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长这里是点击通知后要显示的正文，可以换行可以显示很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长这里是点击通知后要显示的正文，可以换行可以显示很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长");
        style.setBigContentTitle("点击后的标题");
        //SummaryText没什么用 可以不设置
        style.setSummaryText("末尾只一行的文字内容");
        builder.setStyle(style);
        builder.setAutoCancel(true);

        builder.setContentIntent(createPengdingIntent(mContext));
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification notification = builder.build();
        manager.notify(MainActivity.BIGTEXTSTYLE, notification);
    }

    /**
     * 只有在首界面才会全部显示
     * 注意事项
     1. 使用类android.support.v4.app.NotificationCompat.InboxStyle
     2. 每行内容过长时并不会自动换行
     3. addline可以添加多行 但是多余5行的时候每行高度会有截断
     4. 同BigTextStyle 低版本上系统只能显示普通样式
     *
     * @param mContext
     * @param manager
     */
    public void inBoxStyle(Context mContext, android.app.NotificationManager manager) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);
        builder.setContentTitle("InboxStyle");
        builder.setContentText("InboxStyle演示示例");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher_round));
        android.support.v4.app.NotificationCompat.InboxStyle style = new android.support.v4.app.NotificationCompat.InboxStyle();
        style.setBigContentTitle("BigContentTitle")
                .addLine("第一行，第一行，第一行，第一行，第一行，第一行，第一行")
                .addLine("第二行")
                .addLine("第三行")
                .addLine("第四行")
                .addLine("第五行")
                .addLine("第五行")
                .addLine("第五行")
                .addLine("第五行")
                .addLine("第五行")
                .setSummaryText("SummaryText");
        builder.setStyle(style);
        builder.setAutoCancel(true);

        builder.setContentIntent(createPengdingIntent(mContext));
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification notification = builder.build();
        manager.notify(MainActivity.INDEX_BOX, notification);
    }

    /**
     * 1. 使用类android.support.v4.app.NotificationCompat.BigPictureStyle
     2. style.bigPicture传递的是个bitmap对象 所以也不应该传过大的图 否则会oom
     3. 同BigTextStyle 低版本上系统只能显示普通样式
     * @param mContext
     * @param manager
     */
    public void bigPictureStyle(Context mContext, android.app.NotificationManager manager){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);
        builder.setContentTitle("BigPictureStyle");
        builder.setContentText("BigPicture演示示例");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.ic_launcher_round));
        android.support.v4.app.NotificationCompat.BigPictureStyle style = new android.support.v4.app.NotificationCompat.BigPictureStyle();
        style.setBigContentTitle("BigContentTitle");
        style.setSummaryText("SummaryText");
        style.bigPicture(BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.liushishi));
        builder.setStyle(style);
        builder.setAutoCancel(true);
        //设置点击大图后跳转
        builder.setContentIntent(createPengdingIntent(mContext));
        Notification notification = builder.build();
        manager.notify(MainActivity.BIG_BITMAP,notification);
    }

    public void FullScreenNotification(Context mContext, android.app.NotificationManager manager){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);
        builder.setContentTitle("横幅通知");
        builder.setContentText("请在设置通知管理中开启消息横幅提醒权限");
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.ic_launcher_round));

        builder.setContentIntent(createPengdingIntent(mContext));
        //这句是重点
        builder.setFullScreenIntent(createPengdingIntent(mContext),true);
        builder.setAutoCancel(true);
        Notification notification = builder.build();
        manager.notify(MainActivity.HEADED_UP,notification);
    }

    public PendingIntent createPengdingIntent(Context mContext) {
        Intent intent = new Intent(mContext, NotificationActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(mContext, 1, intent, 0);
        return pIntent;

    }
}
