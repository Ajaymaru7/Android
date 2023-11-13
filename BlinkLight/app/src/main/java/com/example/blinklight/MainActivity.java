package com.example.blinklight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnFlashLight, btnBlinkLight;
    private static final int CAMERA_REQUEST = 123;
    boolean hasCameraFlash = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},CAMERA_REQUEST);
        
        hasCameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CONTROLS);
        
        btnFlashLight = (Button) findViewById(R.id.btn_On);
        btnBlinkLight = (Button) findViewById(R.id.btn_Blink);
        
        
        btnFlashLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasCameraFlash){
                    if(btnFlashLight.getText().toString().contains("ON")){
                        btnFlashLight.setText("FLASHLIGHT OFF");
                        btnFlashLight.setText("Blink FLASHLIGHT OFF");
                        flashLightOff();
                    }else{
                        btnBlinkLight.setText("Blink FlashLight ON");
                        btnFlashLight.setText("FLASHLIGHT ON");
                        flashLightOn();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "No Flash available on your device", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnBlinkLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(btnFlashLight.getText().toString().contains("ON"))
                 {
//                     blinkFlash();
                 }else {
                     Toast.makeText(MainActivity.this, "Press the above button first..", Toast.LENGTH_SHORT).show();
                 }
            }
        });
    }
    private  void flashLightOn(){
        CameraManager on =(CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try{
            String cameraID = on.getCameraIdList()[0];
            on.setTorchMode(cameraID,true);
        }catch(CameraAccessException e){

    }
}
    private  void flashLightOff(){
        CameraManager off =(CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try{
            String cameraID = off.getCameraIdList()[0];
            off.setTorchMode(cameraID,false);
        }catch(CameraAccessException e){

        }
}


}