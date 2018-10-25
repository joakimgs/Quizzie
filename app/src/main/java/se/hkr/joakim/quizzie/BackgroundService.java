package se.hkr.joakim.quizzie;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

public class BackgroundService extends Service {
    MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("Service started");
        player = MediaPlayer.create(this,R.raw.sound  );
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        player.setLooping(true);
        player.start();
        return START_STICKY;
    }

    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service stopped");
        player.stop();
    }

}