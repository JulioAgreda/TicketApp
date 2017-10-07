package com.critico.ticketsapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.critico.ticketsapp.MainActivity;
import com.critico.ticketsapp.R;
import com.critico.ticketsapp.model.Cliente;

import java.util.List;


public class ClientesListAdapter extends BaseAdapter
{

    private List<Cliente> items;
    private Context context;

    public ClientesListAdapter(Context context, List<Cliente> item)
    {
        this.items = item;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return items.size();
    }

    @Override
    public Object getItem(int i)
    {
        return items.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.layout_clientes, viewGroup, false);
        }

        TextView labelNombre =  (TextView)view.findViewById(R.id.textNombre);
        TextView labelNroTicket =  (TextView)view.findViewById(R.id.txtNroTicket);
        TextView labelEstado =  (TextView)view.findViewById(R.id.txtEstado);

        Cliente item = items.get(i);

        labelNombre.setText(item.getNombre());
        labelNroTicket.setText(String.valueOf(item.getNroTicket()));
        labelEstado.setText(item.getEstado());

        return view;
    }
}
