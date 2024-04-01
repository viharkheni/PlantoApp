package com.example.plantoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {
    TextView txtPrice, txtProduct;
    NotificationChannel notificationChannel = null;
    Notification notification = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Intent intent = getIntent();
        Plant plant = new Plant(
                intent.getIntExtra("img", 1),
                intent.getStringExtra("name"),
                intent.getIntExtra("image", 1),
                intent.getStringExtra("rating"),
                intent.getStringExtra("description"),
                intent.getStringExtra("size"),
                intent.getStringExtra("plant"),
                intent.getStringExtra("height"),
                intent.getStringExtra("humidity"),
                intent.getStringExtra("price"));

        ImageView imgOrderReview = findViewById(R.id.imgOrderReview);
        imgOrderReview.setImageResource(plant.getWithoutBgImage());

        txtProduct = findViewById(R.id.txtProduct);
        txtProduct.setText(plant.getName());

        txtPrice = findViewById(R.id.txtPrice);
        txtPrice.setText(plant.getPrice());


        Button btnCheckout = findViewById(R.id.btnCheckout);
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoteViews expandedView = new RemoteViews(getPackageName(), R.layout.expanded_notification);

                Intent intentAction = new Intent(getApplicationContext(), CheckoutActivity.class);

                expandedView.setOnClickPendingIntent(R.id.imgsetting, PendingIntent.getActivity(CheckoutActivity.this, 1, intentAction, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE ));

                String CHANNEL_ID = "MYCHANNEL";
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                     notificationChannel = new NotificationChannel(CHANNEL_ID, "Status Bar", NotificationManager.IMPORTANCE_LOW);
                }

                RemoteViews collapsedView = new RemoteViews(getPackageName(), R.layout.collapsed_notification);
                collapsedView.setTextViewText(R.id.timestamp, DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    notification = new Notification.Builder(getApplicationContext(), CHANNEL_ID)
                            .setContentIntent(PendingIntent.getActivity(getApplicationContext(), 1, new Intent(getApplicationContext(), ProductActivity.class),  PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE))
                            .setCustomContentView(collapsedView)
                            .setCustomBigContentView(expandedView)
                            .setSmallIcon(R.drawable.logo)
                            .setShowWhen(true)
                            .setOngoing(true)
                            .setWhen(System.currentTimeMillis())
                            .build();
                }

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                notificationManager.notify(1, notification);
            }
        });

        ImageView imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }
}