package com.critico.ticketsapp.model;

/**
 * Created by CRIVIOSIS on 06/10/2017.
 */

public class Cliente
{
    private int clienteId;
    private int nroTicket;
    private String nombre;
    private String fechaNacimiento;
    private String tipoCliente;
    private String estado;

    public Cliente()
    {

    }

    public Cliente(int clienteId, int nroTicket, String nombre, String fechaNacimientoNac, String tipoCliente, String estado)
    {
        this.clienteId = clienteId;
        this.nroTicket = nroTicket;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimientoNac;
        this.tipoCliente = tipoCliente;
        this.estado = estado;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getNroTicket() {
        return nroTicket;
    }

    public void setNroTicket(int nroTicket) {
        this.nroTicket = nroTicket;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
