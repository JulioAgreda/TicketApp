package com.critico.ticketsapp.Activitys;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.critico.ticketsapp.R;

public class FormularioActivity extends AppCompatActivity
{
    private Spinner listaPrioridad, listaDia, listaMes, listaAño;
    private ArrayAdapter spinnerPrioridad, spinnerDia, spinnerMes, spinnerAño;
    private Button botonRegistrar;
    private EditText textNombre;
    private String stringPrioridad, stringDia, stringMes, stringAño;
    private int nacDia, nacMes, nacAño;

    public static final String PARAM_PRODUCTO_INDEX ="PARAM_PRODUCTO_INDEX";

    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        cargandoListas();
        textNombre = (EditText)findViewById(R.id.textNombre);
        botonRegistrar =  (Button)findViewById(R.id.btnRegistrar);

        cargandoListas();

        //index = getIntent().fillIn()

        botonRegistrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //validar();
            }
        });

    }

    public void cargandoListas()
    {
        listaPrioridad = (Spinner) findViewById(R.id.spPrioridad);
        listaDia = (Spinner)findViewById(R.id.spDia);
        listaMes = (Spinner)findViewById(R.id.spMes);
        listaAño = (Spinner)findViewById(R.id.spAño);

        spinnerPrioridad = ArrayAdapter.createFromResource(this, R.array.prioridad, android.R.layout.simple_spinner_item);
        spinnerDia = ArrayAdapter.createFromResource(this, R.array.dia, android.R.layout.simple_spinner_item);
        spinnerMes = ArrayAdapter.createFromResource(this, R.array.mes, android.R.layout.simple_spinner_item);
        spinnerAño = ArrayAdapter.createFromResource(this, R.array.año, android.R.layout.simple_spinner_item);

        spinnerPrioridad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAño.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        listaPrioridad.setAdapter(spinnerPrioridad);
        listaDia.setAdapter(spinnerDia);
        listaMes.setAdapter(spinnerMes);
        listaAño.setAdapter(spinnerAño);
    }

    public void validar()
    {
        String nombre = textNombre.getText().toString().trim();
        boolean esValido = true;
        if(nombre.isEmpty())
        {
            textNombre.setError("Debe ingresar el Nombre");
            esValido = false;
        }

        if(!esValido)
        {
            return;
        }
        Toast.makeText(this, "Datos Registrados Correctamente", Toast.LENGTH_SHORT).show();
        finish();
    }


}
