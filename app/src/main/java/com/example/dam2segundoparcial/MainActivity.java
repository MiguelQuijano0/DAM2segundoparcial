package com.example.dam2segundoparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private Button dialogo;
    /*private EditText name;
    private EditText age;
    private EditText gener;
    private Button guardare;
    String nombreArchivo="",rutaSdcard="";*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogo = (Button) findViewById(R.id.menu);

        /*name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.edad);
        gener = (EditText) findViewById(R.id.genero);
        guardare=(Button)findViewById(R.id.guardare);
        nombreArchivo="archivo.txt";*/

        /*dialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();
            }
        });*/
    }
    /*private void mostrarDialogo(){
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        final View customlayout = getLayoutInflater().inflate(R.layout.activity_dialogopersonalizado,null);
        alert.setView(customlayout);
        alert.setCancelable(false);

        alert.setPositiveButton("aceptar", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int i) {
                //Toast.makeText(getApplicationContext(), "Datos guardados", Toast.LENGTH_LONG).show();
            }
        });
        alert.setNegativeButton("cancelar",null);
        AlertDialog dialog = alert.create();
        dialog.show();
    }*/
    public void dialogo (View view){
        Intent i = new Intent(this,dialogopersonalizado.class);
        startActivity(i);
    }
}