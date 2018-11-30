package com.example.luanp.birl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SelecionaExercicio extends AppCompatActivity implements SensorEventListener{

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private int passo;
    private float minpos;
    private float maxpos;
    private float milhao;
    private int erro;
    private int contador;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_seleciona_exercicio);

        milhao=10000000;
        passo=0;
        minpos=milhao;
        maxpos=milhao*(-1);
        contador=0;
        erro = 10;

        textView = (TextView) findViewById(R.id.textView9);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mSensorManager.registerListener(SelecionaExercicio.this,mSensor,SensorManager.SENSOR_DELAY_GAME);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.values[1]<minpos){

            minpos = event.values[1];

        }

        if(event.values[1]>maxpos){

            maxpos = event.values[1];

        }

        if((event.values[1]-minpos)>=erro && passo==0){

            passo=1;

        }

        if((maxpos-event.values[1])>=erro && passo==1){

            passo=2;

        }

        if(passo==2){

            passo=0;
            contador = contador + 1;
            textView.setText(Integer.toString(contador));
            Vibrar();
            minpos=milhao;
            maxpos=milhao*(-1);


        }

        Log.d("Exercicio:", " X=" + event.values[0] + " | Y=" + event.values[1] + " | Z=" + event.values[2]);

    }
    public void Vibrar(){
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        long milliseconds = 100;
        vibrator.vibrate(milliseconds);
    }
    public void Tocar(){
        MediaPlayer mp = MediaPlayer.create(SelecionaExercicio.this,R.raw.bril );
        //mp.release();
        mp.start();
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}


}
