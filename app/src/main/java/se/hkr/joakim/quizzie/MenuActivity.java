package se.hkr.joakim.quizzie;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class MenuActivity extends AppCompatActivity {
    boolean mute = true;
    RadioGroup radioGroup;
    public boolean juniorDifficulty = false;
    public boolean seniorDifficulty = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId){
            if(checkedId == R.id.junior) {
                seniorDifficulty = false;
                juniorDifficulty = true;
            } else if(checkedId == R.id.senior) {
                juniorDifficulty = false;
                seniorDifficulty = true;
            }
        }
    });


    }

    @Override
    protected void onPause() {
        super.onPause();
    }



    public void play(View view ){
        if (!juniorDifficulty && !seniorDifficulty)
        Toast.makeText(getApplicationContext(), "Please select a difficulty first!", Toast.LENGTH_SHORT).show();

        else {
            Intent intent = new Intent(MenuActivity.this, PlayActivity.class);
            intent.putExtra("juniorDifficulty", juniorDifficulty);
            intent.putExtra("seniorDifficulty", seniorDifficulty);
            startActivity(intent);
        }
    }
    public void rules(View view ){
        Intent intent = new Intent(MenuActivity.this, RulesActivity.class);
        startActivity(intent);
    }
    public void about(View view ){
        Intent intent = new Intent(MenuActivity.this, AboutActivity.class);
        startActivity(intent);
    }

          public void mute(View view) {
              if(mute) {
                  startService(new Intent(this, BackgroundService.class));
                  mute = false;
              }else{
                  stopService(new Intent(this, BackgroundService.class));
                  mute = true;
              }
          }
}
