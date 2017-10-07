package com.critico.ticketsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.critico.ticketsapp.Activitys.FormularioActivity;
import com.critico.ticketsapp.adapter.ClientesListAdapter;
import com.critico.ticketsapp.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Cliente> clientes = new ArrayList<>();

        /*
        clientes.add(new Cliente("Lucia", 1, "Atendido"));
        clientes.add(new Cliente("Jose", 2, "Atendido"));
        clientes.add(new Cliente("Carlos", 3, "Espera"));
        clientes.add(new Cliente("Sofia", 4, "Espera"));
        */

        ListView listView = (ListView) findViewById(R.id.List_Clientes);

        final ClientesListAdapter adapter = new ClientesListAdapter(this, clientes);
        listView.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.fab)
        {

            Intent intent = new Intent(getApplicationContext(), FormularioActivity.class);
            startActivity(intent);
        }

    }
}
