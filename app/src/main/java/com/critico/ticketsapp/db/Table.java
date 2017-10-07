package com.critico.ticketsapp.db;


public enum Table
{

    tbl_Cliente("tbl_Cliente");

    private final String text;

    /**
     * @param text
     */
    private Table(final String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return text;
    }
}
