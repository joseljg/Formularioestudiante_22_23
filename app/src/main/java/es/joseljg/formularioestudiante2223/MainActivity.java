package es.joseljg.formularioestudiante2223;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import es.joseljg.formularioestudiante2223.clases.Estudiante;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_ESTUDIANTE = "es.joseljg.formularioestudiante.mainactivity.estudiante" ;
    private String cursoSeleccionado = null;
    private EditText edt_dni = null;
    private EditText edt_nombre = null;
    private EditText edt_fecha = null;
    private EditText edt_hora = null;
    private CheckBox ck_acepto = null;
    private Spinner sp_lista_cursos = null;
    private String dni = null;
    private String nombre = null;
    private String curso = null;
    private String fecha = null;
    private String hora = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_dni = (EditText) findViewById(R.id.edt_dni);
        edt_nombre = (EditText) findViewById(R.id.edt_nombre);
        edt_fecha = (EditText) findViewById(R.id.edt_fechan);
        edt_hora = (EditText) findViewById(R.id.edt_hora);
        sp_lista_cursos = (Spinner) findViewById(R.id.sp_lista_cursos);
        ck_acepto = (CheckBox) findViewById(R.id.ck_acepto);
        //-----------------------------------------------------------------------
        if(sp_lista_cursos != null)
        {
            // obtener lista de cursos de la base datos
            String[] cursos ={"1dam","2dam","1smr","2smr"};
            sp_lista_cursos.setOnItemSelectedListener(this);
           // ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lista_item_cursos, android.R.layout.simple_spinner_item);
          //  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
          //  ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lista_item_cursos, R.layout.item_spinner);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_spinner, cursos);
            adapter.setDropDownViewResource(R.layout.item_spinner_seleccionado);
            sp_lista_cursos.setAdapter(adapter);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        cursoSeleccionado = adapterView.getItemAtPosition(i).toString();
        Log.i("item_curso_seleccionado", cursoSeleccionado);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        cursoSeleccionado = "1º DAM";
        Log.i("item_curso_seleccionado", cursoSeleccionado);
    }

    public void mostrar_calendario(View view) {
        // cargar el datepicker
        DatePickerFragment calendario1 = new DatePickerFragment();
        // mostrar el datepicker
        calendario1.show(getSupportFragmentManager(),"DatePicker");
    }

    public void crearFecha(int year, int month, int day) {
        String textoYear = String.valueOf(year);
        String textoMonth = String.valueOf(month+1);
        String textoDay = String.valueOf(day);
        String textoFecha = textoDay + "/"+ textoMonth + "/" + textoYear;
        edt_fecha.setText(textoFecha);
    }

    public void mostrar_hora(View view) {
        // cargar el datepicker
        TimePickerFragment hora1 = new TimePickerFragment();
        // mostrar el datepicker
        hora1.show(getSupportFragmentManager(),"TimePicker");
    }

    public void crearHora(int hora, int minutos) {
        String textoHora = "";
        String textoMinutos ="";
        if(hora>=10)
        {
            textoHora=String.valueOf(hora);
        }
        else{
            textoHora="0"+String.valueOf(hora);
        }
        if(minutos>=10)
        {
            textoMinutos = String.valueOf(minutos);
        }
        else{
            textoMinutos = "0"+String.valueOf(minutos);
        }
        String textoFinal = textoHora + ":" + textoMinutos;
        edt_hora.setText(textoFinal);
    }

    public void enviar_estudiante(View view) {
               if(!ck_acepto.isChecked())
               {
                   Toast.makeText(this,"debes aceptar los terminos",Toast.LENGTH_LONG).show();
                   return;
               }
               dni = String.valueOf(edt_dni.getText());
               nombre = String.valueOf(edt_nombre.getText());
               curso = cursoSeleccionado;
               fecha = String.valueOf(edt_fecha.getText());
               hora = String.valueOf(edt_hora.getText());
               // MANDARLO A LA BASE DE DATOS
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("ALTA DEL USUARIO");
        alerta1.setMessage("Son correctos los datos proporcionados");
        alerta1.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                 // mostrarMensaje("enviando datos del usuario" + e1.toString());
                irAPantalla2();

            }
        });
        alerta1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mostrarMensaje("cancelo en el envio");
            }
        });
       alerta1.show();
    }

    public void mostrarMensaje(String texto)
    {
        Toast.makeText(this,texto,Toast.LENGTH_LONG).show();
    }

    public void irAPantalla2()
    {
        Estudiante e1 = new Estudiante(dni,nombre,curso,fecha,hora);
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra(EXTRA_ESTUDIANTE,e1);
        startActivity(intent);
    }
}