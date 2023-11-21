package com.example.recordatorioapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class alarma extends AppCompatActivity {

    EditText droga;
    EditText describir;
    EditText hour;
    EditText minute;
    Button btna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarma);
        droga = (EditText) findViewById(R.id.txtdroga);
        describir =(EditText)findViewById(R.id.txtdescripcion);
        hour = (EditText)findViewById(R.id.hora);
        minute = (EditText)findViewById(R.id.minuto);

        btna = (Button) findViewById(R.id.btnalarma);
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hora1 = Integer.parseInt(hour.getText().toString());
                int minut = Integer.parseInt(minute.getText().toString());
                String texto = droga.getText().toString();
                String des = describir.getText().toString();

                Intent i = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, texto +" : " + des)
                       // .putExtra(AlarmClock.EXTRA_MESSAGE, des)
                        .putExtra(AlarmClock.EXTRA_HOUR, hora1)
                        .putExtra(AlarmClock.EXTRA_MINUTES, minut);

                if(hora1 <=24 && minut<= 60){
                    startActivity(i);
                }else{
                    Toast.makeText(alarma.this, "HORA ERRONEA", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menulat, menu); // esta linea se debe crear
        return super.onCreateOptionsMenu(menu);
    }

    // acciones del menu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // se crea el switch tecleando
        switch (item.getItemId()) {

            case R.id.cantalarmas:
                Toast.makeText(this, "ALARMAS GUARDADAS", Toast.LENGTH_SHORT).show();
                Intent irca = new Intent(this, alarmaguarda.class);
                irca.putExtra("texto",droga.getText().toString());
                irca.putExtra("texto1",describir.getText().toString());

                startActivity(irca);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}