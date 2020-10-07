package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Planes;

public class Usuario_act extends AppCompatActivity {
    private Spinner spin1, spin2;
    private TextView text;
    private Button calcular;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_act);

        spin1 = (Spinner)findViewById(R.id.SpCliente);
        spin2 = (Spinner)findViewById(R.id.SpServicio);

        text = (TextView)findViewById(R.id.TvResultado);
        calcular = (Button)findViewById(R.id.BtnCalcular);
        edit = (EditText)findViewById(R.id.EtMonto);

        ArrayList<String>listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");

        ArrayList<String>listaPlanes = (ArrayList<String>)getIntent().getSerializableExtra("listaPlanes");

        ArrayAdapter<String> adaptCli = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adaptPla = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaPlanes);

        spin1.setAdapter(adaptCli);
        spin2.setAdapter(adaptPla);

    }



    public void Calcular(View view)
    {
        Planes plan = new Planes();
        String cliente = spin1.getSelectedItem().toString();
        String planes = spin2.getSelectedItem().toString();

        int saldo = Integer.parseInt(edit.getText().toString());

        int normal = Integer.parseInt(plan.getNormal().toString());
        int fitness = Integer.parseInt(plan.getFitness().toString());
        int mamdisimo = Integer.parseInt(plan.getNormal().toString());

        int resulNormal = saldo - normal;
        int resulFitness = saldo - fitness;
        int resulMamadisimo = saldo - mamdisimo;



        if(cliente.equals("shona")&&planes.equals("Normal")){
            text.setText("El valor de Normal es: "+resulNormal);
        }

        if(cliente.equals("shona")&&planes.equals("Fitness")){
            text.setText("El valor de Normal es: "+resulFitness);
        }

        if(cliente.equals("shona")&&planes.equals("Mamadisimo")){
            text.setText("El valor de Normal es: "+resulMamadisimo);
        }

        if(cliente.equals("DarkSnow")&&planes.equals("Normal")){
            text.setText("El valor de Normal es: "+resulNormal);
        }

        if(cliente.equals("DarkSnow")&&planes.equals("Fitness")){
            text.setText("El valor de Normal es: "+resulFitness);
        }

        if(cliente.equals("DarkSnow")&&planes.equals("Mamadisimo")){
            text.setText("El valor de Normal es: "+resulMamadisimo);
        }

        if(cliente.equals("MiNiMo")&&planes.equals("Normal")){
            text.setText("El valor de Normal es: "+resulNormal);
        }

        if(cliente.equals("MiNiMo")&&planes.equals("Fitness")){
            text.setText("El valor de Normal es: "+resulFitness);
        }

        if(cliente.equals("MiNiMo")&&planes.equals("Mamadisimo")){
            text.setText("El valor de Normal es: "+resulMamadisimo);
        }
    }

}