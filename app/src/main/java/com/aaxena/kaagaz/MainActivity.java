package com.aaxena.kaagaz;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Toast;

import com.jesgs.moonfx.MoonFx;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    private String identifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadPerfs();
        Intent launchIntent = new Intent(this, AlarmService.class);
        PendingIntent alarmIntent = PendingIntent.getService(this, 0, launchIntent, 0);

        if (identifier.contains("mojave")){
            AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Toast.makeText(this, R.string.intro_msg, Toast.LENGTH_LONG).show();
            setWallpaperMojave();
            Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY, 2);
            c.add(Calendar.SECOND, 5);
            manager.setRepeating(AlarmManager.RTC, c.getTimeInMillis(), AlarmManager.INTERVAL_HOUR, alarmIntent);
            finish();
        }
        else if (identifier.contains("water")){
            AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Toast.makeText(this, R.string.intro_msg, Toast.LENGTH_LONG).show();
            setWallpaperBeach();
            Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY, 2);
            c.add(Calendar.SECOND, 5);
            manager.setRepeating(AlarmManager.RTC, c.getTimeInMillis(), AlarmManager.INTERVAL_HOUR, alarmIntent);
            finish();
        }
        else if (identifier.contains("moon")){
            AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            setWallpaperCosmos();
            Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY, 2);
            c.add(Calendar.SECOND, 5);
            manager.setRepeating(AlarmManager.RTC, c.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);
            Toast.makeText(this, R.string.intro_msg, Toast.LENGTH_LONG).show();
            finish();
        }
        else if (identifier.contains("kaagaz")){
            AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Toast.makeText(this, R.string.intro_msg, Toast.LENGTH_LONG).show();
            setWallpaperKaagaz();
            Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY, 2);
            c.add(Calendar.SECOND, 5);
            manager.setRepeating(AlarmManager.RTC, c.getTimeInMillis(), AlarmManager.INTERVAL_HOUR, alarmIntent);
            finish();
        }
        else if (identifier.contains("null")){
            AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            manager.cancel(alarmIntent);
            finish();
        }
    }

    private void loadPerfs() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        identifier = sharedPreferences.getString(TEXT,"kaagaz");
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
}
