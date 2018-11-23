package com.betamobilemonkey.preciodeleuro.Entidades;


import com.betamobilemonkey.preciodeleuro.R;

import java.math.BigDecimal;

/**
 * Created by GuidoB on 22/05/2017.
 */
public class Cotizacion {

    private int id;
    private String pais;
    private String divisa;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;

    public Cotizacion (int id, String pais, String divisa, BigDecimal precioCompra, BigDecimal precioVenta) {
        this.id = id;
        this.pais = pais;
        this.divisa = divisa;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public int getId() {
        return id;
    }

    public String getDivisa() {
        return divisa;
    }

    public String getPais() {
        return pais;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagen(){
        switch (this.getPais()){
            case "Argentina":
                return R.drawable.arg;
            case "USA":
                return R.drawable.sa;

            case "Brasil":
                return R.drawable.bra;
            case "Mexico":
                return R.drawable.bandmex;
            case "Colombia":
                return R.drawable.col;
            case "UK":
                return R.drawable.uk;

            case "Rusia":
                return R.drawable.rus;
            case "China":
                return R.drawable.china;
            case "India":
                return R.drawable.india;
            case "Australia":
                return R.drawable.australia;
            case "Peru":
                return R.drawable.peru;

            case "Otros":
                return R.drawable.sa; //poner europa
        }
        return R.drawable.sa;
    }


}
