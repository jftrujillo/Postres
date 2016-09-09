package com.example.jhon.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jhon.listas.Adapter.ListPostresAdapter;
import com.example.jhon.listas.Models.Postres;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list;
    List<Postres> data;
    ListPostresAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list);
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
        //endregion

        adapter = new ListPostresAdapter(data,this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(MainActivity.this, data.get(i).getName() , Toast.LENGTH_SHORT).show();
    }
}
