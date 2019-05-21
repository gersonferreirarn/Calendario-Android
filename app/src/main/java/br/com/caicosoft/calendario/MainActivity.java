package br.com.caicosoft.calendario;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private MaterialCalendarView cvCalendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvCalendario = findViewById(R.id.cvCalendario);

        cvCalendario.state().edit()
                .setMinimumDate(CalendarDay.from(2019,1,1))
                .setMaximumDate(CalendarDay.from(2020, 1, 1))
                .commit();

        CharSequence meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        cvCalendario.setTitleMonths(meses);

        CharSequence semanas[] = {"Seg", "Ter", "Qua", "Qui", "Sex", "Sáb", "Dom"};

        cvCalendario.setWeekDayLabels(semanas);

        cvCalendario.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
                Log.i("DATA:", (date.getMonth()+1)+"/"+date.getYear());
            }
        });

        /*cvCalendario.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Log.i("DATA:", date+"");
            }
        });
       */

    }
}
