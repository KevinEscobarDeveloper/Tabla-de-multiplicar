package com.example.a279_e34tablademultiplicar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //cse declaran las referencias a las vistas
    private EditText mValor;
    private TextView mTextTabla;

    //para controlar el tamaño del texto
    private int tamTexto = 20;
    private int lSup = 40;
    private int lInf = 10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //se instancian las vistas
        mValor = findViewById(R.id.valor);
        mTextTabla = findViewById(R.id.textTabla);

        //Poner icono en el Action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    public void funMenos(View view) {
        if(tamTexto > lInf) {
            tamTexto -= 5; //equivale a tamTexto = tamTexto-5
            mTextTabla.setTextSize(tamTexto);
        }
    }

    public void funMas(View view) {
        if(tamTexto < lSup) {
            tamTexto += 5; //equivale a tamTexto = tamTexto+5
            mTextTabla.setTextSize(tamTexto);
        }
    }

    public void limpiar(View view) {
        mValor.setText("");
        mTextTabla.setText("");
    }

    public void tabular(View view) {
        String c = mValor.getText().toString();
        if(!c.equals("")) {
            int n = Integer.parseInt(c);
            String cad = "";
            for (int i = 1; i <= 10; i++) {
                cad += n + " X " + i + " = " + (n * i) + "\n";
            }
            mTextTabla.setText(cad);
            ocultarTeclado(mValor);
        }
        else{

        }
    }

    private void ocultarTeclado(EditText et){
        InputMethodManager imm =(InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et.getWindowToken(),0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){

            case R.id.acerca_de:
                startActivity(new Intent(this, AcercaDe.class));
                break;
            case R.id.salir:
                AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
                dialogo.setTitle("Confirmación");
                dialogo.setMessage("Confirme si realmente desea salir de la app");
                dialogo.setCancelable(false);
                dialogo.setIcon(R.drawable.ic_baseline_warning_24);
                dialogo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialogo.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}