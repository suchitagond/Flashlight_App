package com.example.flashlightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch aSwitch;
//    TextView on_off;
//    TextView heding;
    CameraManager cameraManager;
    String cameraid,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        aSwitch=findViewById(R.id.switch1);
//        on_off=findViewById(R.id.ONOFF);

//        heding=findViewById(R.id.flashlight);
//        heding.setPaintFlags(heding.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                torch(b);
            }
        });
    }

    private void torch(boolean b) {
        try {
            cameraManager= (CameraManager) getSystemService(CAMERA_SERVICE);
            cameraid=cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraid,b);
//            result=b?"ON":"OFF";
//            on_off.setText(result);
            if(b==true){
                Toast.makeText(MainActivity.this,"Flashlight is turned ON ",Toast.LENGTH_SHORT).show();
            }
            if(b==false){
                Toast.makeText(MainActivity.this,"Flashlight is turned OFF ",Toast.LENGTH_SHORT).show();
            }
        } catch (CameraAccessException e) {
            throw new RuntimeException(e);
        }

    }
}