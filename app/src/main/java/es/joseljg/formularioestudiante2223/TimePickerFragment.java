package es.joseljg.formularioestudiante2223;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;
import java.util.TimeZone;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendario1 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid"));
        int hora = calendario1.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario1.get(Calendar.MINUTE);
        TimePickerDialog tpd1 = new TimePickerDialog(getActivity(),this,hora,minutos,true);
        return tpd1;
    }


    @Override
    public void onTimeSet(TimePicker timePicker, int hora, int minutos) {
         MainActivity actividad1 = (MainActivity) getActivity();
         actividad1.crearHora(hora,minutos);
    }
}