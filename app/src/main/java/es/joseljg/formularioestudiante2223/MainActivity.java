package es.joseljg.formularioestudiante2223;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String cursoSeleccionado = null;
    private EditText edt_dni = null;
    private EditText edt_nombre = null;
    private Spinner sp_lista_cursos = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_dni = (EditText) findViewById(R.id.edt_dni);
        edt_nombre = (EditText) findViewById(R.id.edt_nombre);
        sp_lista_cursos = (Spinner) findViewById(R.id.sp_lista_cursos);
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
        // mostrar el datepicker
    }
}