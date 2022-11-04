package es.joseljg.formularioestudiante2223;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import es.joseljg.formularioestudiante2223.clases.Estudiante;

public class Activity2 extends AppCompatActivity {

    private Estudiante e = null;
    private TextView txt_dni_estudiante = null;
    private TextView txt_nombre_estudiante = null;
    private TextView txt_curso_estudiante = null;
    private TextView txt_fecha_estudiante = null;
    private TextView txt_hora_estudiante = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //------------------------------------------
        Intent intent =  getIntent();
        if(intent != null)
        {
            e = (Estudiante) intent.getSerializableExtra(MainActivity.EXTRA_ESTUDIANTE);
          //  Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
        if(e != null)
        {
            txt_dni_estudiante = (TextView) findViewById(R.id.txt_dni_estudiante);
            txt_dni_estudiante.setText("DNI: " + e.getDni());

            txt_nombre_estudiante = (TextView) findViewById(R.id.txt_nombre_estudiante);
            txt_nombre_estudiante.setText("NOMBRE: " + e.getNombre());

            txt_curso_estudiante = (TextView) findViewById(R.id.txt_curso);
            txt_curso_estudiante.setText("CURSO: " + e.getCurso());

            txt_fecha_estudiante = (TextView) findViewById(R.id.txt_fecha_estudiante);
            txt_fecha_estudiante.setText("FECHA: "+ e.getFecha_nacimiento());

            txt_hora_estudiante = (TextView) findViewById(R.id.txt_hora_estudiante);
            txt_hora_estudiante.setText("HORA: " + e.getHora_tutoria());

        }
    }
}