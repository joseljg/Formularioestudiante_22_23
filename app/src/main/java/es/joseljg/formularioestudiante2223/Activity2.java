package es.joseljg.formularioestudiante2223;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import es.joseljg.formularioestudiante2223.clases.Estudiante;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //------------------------------------------
        Intent intent =  getIntent();
        if(intent != null)
        {
            Estudiante e = (Estudiante) intent.getSerializableExtra(MainActivity.EXTRA_ESTUDIANTE);
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }
}