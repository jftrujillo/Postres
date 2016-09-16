package com.example.jhon.listas;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jhon.listas.util.Util;

public class ConfirmarCompraActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    EditText nombre,cedula,tarjetaDeCredito;
    TextView titulo;
    Button btn;
    Bundle bundle;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_compra);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        nombre = (EditText) findViewById(R.id.nombre);
        cedula = (EditText) findViewById(R.id.cedula);
        tarjetaDeCredito = (EditText) findViewById(R.id.tarjeta_credito);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Confirmar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bundle = getIntent().getExtras();
        if (bundle != null){
            titulo = (TextView) findViewById(R.id.titulo);
            titulo.setVisibility(View.VISIBLE);
            int index = bundle.getInt("index");
            titulo.setText(Util.getData().get(index).getPrecio());
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (ValidateStrings.validateStringsInEditText(nombre.getText().toString(),cedula.getText().toString(),tarjetaDeCredito.getText().toString())){

            Toast.makeText(ConfirmarCompraActivity.this, "Formulario" + nombre.getText().toString() + " " + cedula.getText().toString() + " " + tarjetaDeCredito.getText().toString() , Toast.LENGTH_SHORT).show();
            finish();    
        }
        
        else {
            Toast.makeText(ConfirmarCompraActivity.this, "Valor de formulario invalido", Toast.LENGTH_SHORT).show();
        }
        
    }
}
