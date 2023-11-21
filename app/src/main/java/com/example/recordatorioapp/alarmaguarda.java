package com.example.recordatorioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class alarmaguarda extends AppCompatActivity {

    ListView lista;
    ArrayList medicamentos;
    ArrayAdapter adaptador1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmaguarda);
        String dato = getIntent().getStringExtra("texto");
        String dato1 = getIntent().getStringExtra("texto1");

        medicamentos = new ArrayList(10);
        medicamentos.add(dato +"  " + dato1);

        adaptador1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,medicamentos);
        lista = (ListView) findViewById(R.id.lista1);
        lista.setAdapter(adaptador1);



    }

    public void regresar(View view){
        Intent i = new Intent(alarmaguarda.this, alarma.class);
        startActivity(i);
    }


}