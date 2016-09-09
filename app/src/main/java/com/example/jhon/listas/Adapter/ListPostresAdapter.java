package com.example.jhon.listas.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jhon.listas.Models.Postres;
import com.example.jhon.listas.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jhon on 7/09/16.
 */
public class ListPostresAdapter extends BaseAdapter {
    List<Postres> data;
    Context context;

    public ListPostresAdapter(List<Postres> data, Context context) {
        this.data = data;
        this.context= context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null){
            v = View.inflate(context, R.layout.template_list_postres,null);
        }

        ImageView img = (ImageView) v.findViewById(R.id.imagen);
        TextView nombre = (TextView) v.findViewById(R.id.nombre);
        Log.i("Nombre",nombre.getText().toString());
        TextView ingredientes = (TextView) v.findViewById(R.id.ingredientes);
        TextView precio = (TextView) v.findViewById(R.id.precio);
        nombre.setText(data.get(i).getName());
        ingredientes.setText(data.get(i).getIngredientes());
        precio.setText(data.get(i).getPrecio());
        Picasso.with(context).load(data.get(i).getImgUrl()).into(img);
        return v;
    }
}
