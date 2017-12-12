package com.example.tharani.broadcastnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    /*onCreate is the first method in the life cycle of an activity
    savedInstance passes data to super class,data is pull to store state of application
  * setContentView is used to set layout for the activity
  *R is a resource and it is auto generate file
  * activity_main assign an integer value*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       }
    //creating Method sendInboxStyleNotification()
    public void sendInboxStyleNotification(View view) {
        //creating object of pendingIntent
        PendingIntent pendingIntent = getPendingIntent();
        //pendingIntent is clicking of the notification where we want to go
        //by using addLine method adding messages
        Notification notification = null ;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            //using  if Statement because it decides whether a certain statement will execute or not
            long when = System.currentTimeMillis();//currentTimeMillis (). Returns the current time in milliseconds
             notification = new Notification.InboxStyle(new Notification.Builder(MainActivity.this)
                    .setTicker("Event Detail")//setting Ticker it adda a rich notification style to be applied at build time
                    .setSmallIcon(R.mipmap.ic_launcher)//sets icon image
                    .setWhen(when)
                    .setContentTitle("Details...")//sets details
                    .setContentText("Inbox Style")//sets content Text
                    .setNumber(6)//sets numbers of messages that i want to print
                    .setContentIntent(pendingIntent))//pendingIntent is clicking of the notification where we want to go
                     //by using addLine method adding messages
                    .addLine("Helloo..!")
                    .addLine("How are you?")
                    .addLine("HIII !!")
                    .addLine("i am fine...")
                    .addLine("what about you? all is well?")
                    .addLine("Yes, every thing is all right..")
                    .setBigContentTitle("Event Details")//sets title
                    .build();
            // Put the auto cancel notification flag
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            //creating Object NotificationManager helps to get notifications
            NotificationManager notificationManager = getNotificationManager();
            notificationManager.notify(0, notification);//notify here
        }
    }
    //Creating PendingIntent Method()
    public PendingIntent getPendingIntent() {//pendingIntent is clicking of the notification where we want to go
        return PendingIntent.getActivity(this, 0, new Intent(this,
                HandleNotificationActivity.class), 0);//returns pending intent and handles notification
       // here Handle notification messages in a backgrounded app: When your app is in the background,
        // Android directs notification messages to the system tray
    }
    //creating getNotificationManager() for getting the Notification
    private NotificationManager getNotificationManager() {//taking private to access within this
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);//returns and gets system service
    }

}
