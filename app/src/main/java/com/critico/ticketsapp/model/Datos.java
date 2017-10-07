package com.critico.ticketsapp.model;

import java.util.List;

/**
 * Created by CRIVIOSIS on 06/10/2017.
 */

public class Datos
{
    private List<Cliente> clientes;
    private static Datos instancia;

    private Datos()
    {
        clientes.add(new Cliente("Lucia", 1, "Atendido"));
        clientes.add(new Cliente("Jose", 2, "Atendido"));
        clientes.add(new Cliente("Carlos", 3, "Espera"));
        clientes.add(new Cliente("Sofia", 4, "Espera"));
    }

    public static Datos getInstancia()
    {
        if(instancia ==null)
        {
            instancia = new Datos();
        }
        return instancia;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
