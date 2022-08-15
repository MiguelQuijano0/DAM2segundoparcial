package com.example.dam2segundoparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class dialogopersonalizado extends AppCompatActivity {
    private Button dialogo;
    private EditText name;
    private EditText age;
    private EditText gener;
    private Button guardare;
    String nombreArchivo="",rutaSdcard="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogopersonalizado);
        dialogo = (Button) findViewById(R.id.menu);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.edad);
        gener = (EditText) findViewById(R.id.genero);
        guardare=(Button)findViewById(R.id.guardare);
        nombreArchivo="archivo.txt";

        guardare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarEnExterna();
            }
        });

    }
    private void guardarEnExterna() {
        String nombre =name.getText().toString();
        String genero =gener.getText().toString();
        String edad= age.getText().toString();

        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            rutaSdcard=getExternalFilesDir(null).getAbsolutePath();
        }else{
            Toast.makeText(getApplicationContext(), "No se puede acceder a la SD card",Toast.LENGTH_LONG).show();
        }
        File file= new File(rutaSdcard+"/"+nombreArchivo);
        FileOutputStream fos = null;
        try{
            fos=new FileOutputStream(file);
            if(fos!=null){
                fos.write(nombre.getBytes());
                fos.write(genero.getBytes());
                fos.write(edad.getBytes());
            }
            if(fos!=null){
                fos.close();
            }
            Toast.makeText(getApplicationContext(), "Texto Guardado con EXITO!!!",Toast.LENGTH_LONG).show();
            Intent i = new Intent(this,categorias.class);
            startActivity(i);
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Error"+e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }catch(IOException e){
            Toast.makeText(getApplicationContext(), "Error"+e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}