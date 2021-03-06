package com.aaxena.kaagaz;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.jesgs.moonfx.MoonFx;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import static android.app.Notification.EXTRA_NOTIFICATION_ID;
import static android.graphics.Color.GRAY;
import static com.aaxena.kaagaz.App.CHANNEL_ID;

public class AlarmService extends Service {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    private String hello;


    public class AppConstant
    {
        public static final String STOP_ACTION = "STOP_ACTION";
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        loadPerfs();
        fireNotif();
        setWall();
        //Notification Tap
        Intent notificationsIntent = new Intent(this,Settings.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationsIntent,0);
        String msg="Wallpaper Service Running";
        Notification notification =  new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_half_moon)
                .setColor(GRAY)
                .setNotificationSilent()
                .setColorized(true)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);
        return START_NOT_STICKY;
    }

    @Override
    public boolean stopService(Intent name) {
        stopForeground(true);
        stopSelf();
        return super.stopService(name);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void setWall() {
        if (hello.contains("mojave")) {
            //Setting Wallpaper for Mojave Desert
            setWallpaperMojave();
        } else if (hello.contains("water")) {
            //Setting Wallpaper for Beach Side
            setWallpaperBeach();
        } else if (hello.contains("moon")){
            //Setting Wallpaper for Moonlit Cosmos
            setWallpaperCosmos();
        }
        else if (hello.contains("kaagaz")){
            //Setting Wallpaper for BigSur
            setWallpaperKaagaz();
        }
        else if (hello.contains("null")){
            stopSelf();
            stopForeground(true);
        }
    }
    private void fireNotif() {
        MoonFx moonFx = new MoonFx();
        moonFx.setDate(new Date());
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        if (moonFx.getSynodicPhase() >= 6 && moonFx.getSynodicPhase() < 7 && timeOfDay >= 19 && timeOfDay < 20|| moonFx.getSynodicPhase() >= 19 && moonFx.getSynodicPhase() < 21 && timeOfDay >= 19 && timeOfDay < 20) {
            Intent intent1 = new Intent(AlarmService.this, ReminderBroadcast.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmService.this, 0, intent1, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            long tenSecondsInMillis = 1 + 10;
            alarmManager.set(AlarmManager.RTC_WAKEUP, tenSecondsInMillis, pendingIntent);
        }
    }

    private void loadPerfs() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        hello = sharedPreferences.getString(TEXT, "kaagaz");
    }

    private void setWallpaperBeach() {

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 01) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seventeen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 01 && timeOfDay < 02) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seventeen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 02 && timeOfDay < 03) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seventeen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 03 && timeOfDay < 04) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fifteen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 04 && timeOfDay < 05) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fifteen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 05 && timeOfDay < 06) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sixteen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 06 && timeOfDay < 07) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 07 && timeOfDay < 8) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 8 && timeOfDay < 9) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.two_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 9 && timeOfDay < 10) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.three_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 10 && timeOfDay < 11) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.four_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 11 && timeOfDay < 12) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.five_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 12 && timeOfDay < 13) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.six_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 13 && timeOfDay < 14) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seven_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 14 && timeOfDay < 15) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eight_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 15 && timeOfDay < 16) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nine_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 16 && timeOfDay < 17) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ten_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 17 && timeOfDay < 18) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eleven_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 18 && timeOfDay < 19) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.twelve_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 19 && timeOfDay < 20) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.thirteen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 20 && timeOfDay < 21) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fifteen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 21 && timeOfDay < 22) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fourteen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 22 && timeOfDay < 23) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seventeen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 23 && timeOfDay < 24) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seventeen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setWallpaperMojave() {

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 01) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 01 && timeOfDay < 02) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 02 && timeOfDay < 03) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 03 && timeOfDay < 04) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.four);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 04 && timeOfDay < 05) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.five);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 05 && timeOfDay < 06) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.six);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 06 && timeOfDay < 07) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seven);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 07 && timeOfDay < 8) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seven);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 8 && timeOfDay < 9) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eight);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 9 && timeOfDay < 10) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nine);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 10 && timeOfDay < 11) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ten);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 11 && timeOfDay < 12) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ten);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 12 && timeOfDay < 13) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eleven);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 13 && timeOfDay < 14) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.twelve);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 14 && timeOfDay < 15) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.thirteen);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 15 && timeOfDay < 16) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.thirteen);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 16 && timeOfDay < 17) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fourteen);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 17 && timeOfDay < 18) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fifteen);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 18 && timeOfDay < 19) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sixteen);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 19 && timeOfDay < 20) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.four);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 20 && timeOfDay < 21) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 21 && timeOfDay < 22) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 22 && timeOfDay < 23) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 23 && timeOfDay < 24) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setWallpaperCosmos() {
        MoonFx moonFx = new MoonFx();
        moonFx.setDate(new Date());
        if (moonFx.getSynodicPhase() >= 0 && moonFx.getSynodicPhase() < 2) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.new_moon);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        }
        else if (moonFx.getSynodicPhase() >= 2 && moonFx.getSynodicPhase() < 3) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sixteen_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        }
        else if (moonFx.getSynodicPhase() >= 3 && moonFx.getSynodicPhase() < 4) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fifteen_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 4 && moonFx.getSynodicPhase() < 6) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fourteen_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 6 && moonFx.getSynodicPhase() < 7) {
            Intent intent1 = new Intent(AlarmService.this, ReminderBroadcast.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmService.this, 0, intent1, 0);
            AlarmManager alarmManager =(AlarmManager)getSystemService(ALARM_SERVICE);
            long tenSecondsInMillis = 1+10;
            alarmManager.set(AlarmManager.RTC_WAKEUP, tenSecondsInMillis, pendingIntent);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.thirteen_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 7 && moonFx.getSynodicPhase() < 8) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.twelve_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 8 && moonFx.getSynodicPhase() < 9) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eleven_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 9 && moonFx.getSynodicPhase() < 10) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ten_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 10 && moonFx.getSynodicPhase() < 11) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ten_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 11 && moonFx.getSynodicPhase() < 12) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nine_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        }
        //FullMoon
        else if (moonFx.getSynodicPhase() >= 12 && moonFx.getSynodicPhase() < 13) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eight_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 13 && moonFx.getSynodicPhase() < 14) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eight_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        }
        //FullMoonEnd
        else if (moonFx.getSynodicPhase() >= 14 && moonFx.getSynodicPhase() < 15) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eight_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 15 && moonFx.getSynodicPhase() < 16) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seven_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 16 && moonFx.getSynodicPhase() < 19) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.six_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 19 && moonFx.getSynodicPhase() < 21) {
            Intent intent1 = new Intent(AlarmService.this, ReminderBroadcast.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmService.this, 0, intent1, 0);
            AlarmManager alarmManager =(AlarmManager)getSystemService(ALARM_SERVICE);
            long tenSecondsInMillis = 1+10;
            alarmManager.set(AlarmManager.RTC_WAKEUP, tenSecondsInMillis, pendingIntent);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.five_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 21 && moonFx.getSynodicPhase() < 23) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 23 && moonFx.getSynodicPhase() < 25) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.four_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 25 && moonFx.getSynodicPhase() < 26) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.three_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 26 && moonFx.getSynodicPhase() < 27) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.two_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 27 && moonFx.getSynodicPhase() < 28) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.new_moon);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 28 && moonFx.getSynodicPhase() < 29) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.new_moon);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (moonFx.getSynodicPhase() >= 29 && moonFx.getSynodicPhase() < 30) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.new_moon);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setWallpaperKaagaz() {

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 01) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_twelve);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 01 && timeOfDay < 02) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_twelve);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 02 && timeOfDay < 03) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_twelve);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 03 && timeOfDay < 04) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_twelve);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 04 && timeOfDay < 05) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_twelve);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 05 && timeOfDay < 06) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_twelve);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 06 && timeOfDay < 07) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_one);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 07 && timeOfDay < 8) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_one);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 8 && timeOfDay < 9) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 9 && timeOfDay < 10) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_eight);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 10 && timeOfDay < 11) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_five);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 11 && timeOfDay < 12) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_five);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 12 && timeOfDay < 13) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_six);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 13 && timeOfDay < 14) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_six);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 14 && timeOfDay < 15) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_seven);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 15 && timeOfDay < 16) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_seven);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 16 && timeOfDay < 17) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_nine);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 17 && timeOfDay < 18) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_nine);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 18 && timeOfDay < 19) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 19 && timeOfDay < 20) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_four);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 20 && timeOfDay < 21) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_four);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 21 && timeOfDay < 22) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_eleven);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 22 && timeOfDay < 23) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_twelve);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 23 && timeOfDay < 24) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abs_eleven);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    //Action that keeps service running even after removed from recents
    public void onTaskRemoved(Intent rootIntent){
        Intent restartServiceTask = new Intent(getApplicationContext(),this.getClass());
        restartServiceTask.setPackage(getPackageName());
        PendingIntent restartPendingIntent =PendingIntent.getService(getApplicationContext(), 1,restartServiceTask, PendingIntent.FLAG_ONE_SHOT);
        AlarmManager myAlarmService = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        myAlarmService.set(
                AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + 1000,
                restartPendingIntent);
        super.onTaskRemoved(rootIntent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
