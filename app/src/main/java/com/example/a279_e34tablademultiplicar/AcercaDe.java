package com.example.a279_e34tablademultiplicar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AcercaDe extends AppCompatActivity {
    //referencia al array
    TextView mTitulo, mContenido;
    String [] arrayAcercaDe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        mTitulo = findViewById(R.id.titulo);
        mContenido = findViewById(R.id.contenido);
        //creamos la instancia del array y la poblamos
        arrayAcercaDe = getResources().getStringArray(R.array.acerca_de);

        mTitulo.setText(arrayAcercaDe[0]);

        //colocacion del contenido
        String cad="";
        for(int i=1; i<arrayAcercaDe.length; i++){
            cad+= arrayAcercaDe[i]+"\n";
        }
        mContenido.setText(cad);

        //Poner icono en el Action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }
}