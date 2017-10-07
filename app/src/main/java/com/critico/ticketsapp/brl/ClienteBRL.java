package com.critico.ticketsapp.brl;

import com.critico.ticketsapp.model.Cliente;
import java.util.List;




public interface ClienteBRL
{
    public int insert(Cliente obj);

    public List<Cliente> getClientes();

    public Cliente getCliente(int clienteId);



    //public void update(Cliente obj);

    //public void delete(int productoId);

    //public List<Cliente> getProductosConStockMayorA(int stock);


}
