package com.example.rafaelstarke.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    int mId = 1001;

    NotificationCompat.Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.btAllert);

        mBuilder = new NotificationCompat.Builder(this);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                // Creates an explicit intent for an Activity in your app
                Intent resultIntent = new Intent(v.getContext(), MainActivity.class);
                // The stack builder object will contain an artificial back stack for the
                // started Activity.
                // This ensures that navigating backward from the Activity leads out of
                // your application to the Home screen.
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(v.getContext());
                // Adds the back stack for the Intent (but not the Intent itself)
                stackBuilder.addParentStack(MainActivity.class);
                // Adds the Intent that starts the Activity to the top of the stack
                stackBuilder.addNextIntent(resultIntent);

                mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Minha Notificacao")
                        .setContentText("Ola eu sou seu aminho a notificação. Quer brincar comigo?????")
                        .setAutoCancel(true);

                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(
                                0,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );

                mBuilder.setContentIntent(resultPendingIntent);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(mId, mBuilder.build());
            }
        });
    }




}
