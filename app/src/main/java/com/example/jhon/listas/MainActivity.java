package com.example.jhon.listas;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jhon.listas.Adapter.ListPostresAdapter;
import com.example.jhon.listas.Models.Postres;
import com.example.jhon.listas.util.Util;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list;
    List<Postres> data;
    ListPostresAdapter adapter;
    Toolbar toolbar;
    AlertDialog alert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        data = new ArrayList<>();
        //region setData
        Postres postres = new Postres();
        postres.setName("Helado");
        postres.setIngredientes("Leche, agua, frutas");
        postres.setPrecio("2000");
        postres.setImgUrl("http://xn--soar-con-e3a.com/wp-content/uploads/2015/07/So%C3%B1ar-con-Helado-de-Frutilla.jpg");
        data.add(postres);

        Postres postres1 = new Postres();
        postres1.setName("Fresas con crema");
        postres1.setIngredientes("Fresas, crema, frutas");
        postres1.setPrecio("2800");
        postres1.setImgUrl("http://cdn.kiwilimon.com/recetaimagen/268/thumb400x300-14757.jpg");
        data.add(postres1);

        Postres postres2 = new Postres();
        postres2.setName("Pastel");
        postres2.setIngredientes("Harina, huevos, pasas");
        postres2.setPrecio("1000");
        postres2.setImgUrl("http://pasteleriasmarisa.com.mx/dyn/wp-content/uploads/2015/07/IMG_01221.jpg");
        data.add(postres2);

        Postres postres3 = new Postres();
        postres3.setName("Tres leches");
        postres3.setIngredientes("Leche 1, leche 2, leche 3");
        postres3.setPrecio("5000");
        postres3.setImgUrl("http://laestrella.com.pa/media/news/image/158996_800x600_crop_55ce26f1eda91.jpg");
        data.add(postres3);

        Util.getData().addAll(data);
        //endregion
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Postres");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adapter = new ListPostresAdapter(data,this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(MainActivity.this, data.get(i).getName() , Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ConfirmarCompraActivity.class);
        intent.putExtra("index",i);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:

                //region Alert de salir
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Atencion");
                builder.setMessage("Esta seguro que quiere salir de la aplicacion");
                builder.setCancelable(true);
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("No",null);
                alert = builder.create();
                alert.show();
                //endregion

                break;
            case R.id.compras_menu:
                Toast.makeText(MainActivity.this, "Presiono menu", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,ConfirmarCompraActivity.class);
                startActivity(intent);
                break;
            case R.id.info_menu:
                Toast.makeText(MainActivity.this, "Presiono info", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
