package com.betamobilemonkey.preciodeleuro.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.betamobilemonkey.preciodeleuro.Adapters.AdaptadorCotizaciones;
import com.betamobilemonkey.preciodeleuro.Entidades.Cotizacion;
import com.betamobilemonkey.preciodeleuro.R;
import com.betamobilemonkey.preciodeleuro.Servicios.GetCotizacionesWS;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CotizacionesFragment extends Fragment {

    private ListView listView;
    private List<Cotizacion> cotizaciones;
    public GetCotizacionesWS mGetCotizaciones;
    private AdView mBottomBanner;




    public CotizacionesFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cotizaciones,container,false);

        listView = (ListView) view.findViewById(R.id.listView);

        // crea cotizaciones a mostrar
        this.creaCotizaciones();

        //adaptador es la forma en que mostraremos los datos, se usa adaptador porque se agregan no solo un simple texto, una clase con moneda, imagen, valor, etc.
        // el segundo parametro es el layout, el tercero el array, en la clase miadaptadorcotizacion de java, va como mostrar los datos.
        AdaptadorCotizaciones miAdaptador = new AdaptadorCotizaciones(this.getContext(), R.layout.list_itemcard_cotizaciones,cotizaciones);
        listView.setAdapter(miAdaptador);

        //Busca banner
        mBottomBanner = (AdView) view.findViewById(R.id.av_bottom_banner);

        if (mBottomBanner != null) {

            AdRequest adRequest = new AdRequest.Builder().build();

            mBottomBanner.loadAd(adRequest);
        }

        return view;
    }


    private void RefreshDataSource() {
        GetCotizacionesWS mGetCotizaciones = new GetCotizacionesWS(this);
        mGetCotizaciones.execute((Void) null);

    }

    public void creaCotizaciones(){
        cotizaciones = new ArrayList<Cotizacion>();

        cotizaciones.add(new Cotizacion(1,"USA","USD",new BigDecimal(0.0),new BigDecimal(0.0)));
        cotizaciones.add(new Cotizacion(2,"UK","GBP",new BigDecimal(0.0),new BigDecimal(0.0)));
        cotizaciones.add(new Cotizacion(3,"Mexico","MXN",new BigDecimal(0.0),new BigDecimal(0.0)));
        cotizaciones.add(new Cotizacion(4,"Rusia","RUB",new BigDecimal(0.0),new BigDecimal(0.0)));
        cotizaciones.add(new Cotizacion(5,"Brasil","BRL",new BigDecimal(0.0),new BigDecimal(0.0)));
        cotizaciones.add(new Cotizacion(6,"Argentina","ARS",new BigDecimal(0.0),new BigDecimal(0.0)));
        cotizaciones.add(new Cotizacion(7,"Australia","AUD",new BigDecimal(0.0),new BigDecimal(0.0)));
        cotizaciones.add(new Cotizacion(8,"India","INR",new BigDecimal(0.0),new BigDecimal(0.0)));
        cotizaciones.add(new Cotizacion(9,"Colombia","COP",new BigDecimal(0.0),new BigDecimal(0.0)));
        cotizaciones.add(new Cotizacion(10,"Peru","PEN",new BigDecimal(0.0),new BigDecimal(0.0)));
        cotizaciones.add(new Cotizacion(11,"China","CNY",new BigDecimal(0.0),new BigDecimal(0.0)));
        this.RefreshDataSource();
    }

    public void getCotizacionesWSCallBack(JSONObject json) {

        BigDecimal precioVenta = new BigDecimal(0.0);
        BigDecimal numeroMultiplicador = BigDecimal.valueOf(1.02);
        int i = 0;

        while (cotizaciones.size() > i) {
            try{
                if (cotizaciones.get(i).getPais().equalsIgnoreCase("argentina")){
                    BigDecimal precio = conviertePrecio(json.getString("argentina"));
                    precioVenta = precio.multiply(numeroMultiplicador);
                    cotizaciones.get(i).setPrecioCompra(precio);
                    cotizaciones.get(i).setPrecioVenta(precioVenta);
                }
                if (cotizaciones.get(i).getPais().equalsIgnoreCase("peru")){
                    BigDecimal precio = conviertePrecio(json.getString("peru"));
                    precioVenta = precio.multiply(numeroMultiplicador);
                    cotizaciones.get(i).setPrecioCompra(precio);
                    cotizaciones.get(i).setPrecioVenta(precioVenta);
                }
                if (cotizaciones.get(i).getPais().equalsIgnoreCase("usa")){
                    BigDecimal precio = conviertePrecio(json.getString("usa"));
                    cotizaciones.get(i).setPrecioCompra(precio);
                    precioVenta = precio.multiply(numeroMultiplicador);
                    cotizaciones.get(i).setPrecioCompra(precio);
                    cotizaciones.get(i).setPrecioVenta(precioVenta);
                }
                if (cotizaciones.get(i).getPais().equalsIgnoreCase("uk")){
                    BigDecimal precio = conviertePrecio(json.getString("uk"));
                    cotizaciones.get(i).setPrecioCompra(precio);
                    precioVenta = precio.multiply(numeroMultiplicador);
                    cotizaciones.get(i).setPrecioCompra(precio);
                    cotizaciones.get(i).setPrecioVenta(precioVenta);
                }
                if (cotizaciones.get(i).getPais().equalsIgnoreCase("colombia")){
                    BigDecimal precio = conviertePrecio(json.getString("colombia"));
                    cotizaciones.get(i).setPrecioCompra(precio);
                    precioVenta = precio.multiply(numeroMultiplicador);
                    cotizaciones.get(i).setPrecioCompra(precio);
                    cotizaciones.get(i).setPrecioVenta(precioVenta);
                }
                if (cotizaciones.get(i).getPais().equalsIgnoreCase("mexico")){
                    BigDecimal precio = conviertePrecio(json.getString("mexico"));
                    cotizaciones.get(i).setPrecioCompra(precio);
                    precioVenta = precio.multiply(numeroMultiplicador);
                    cotizaciones.get(i).setPrecioCompra(precio);
                    cotizaciones.get(i).setPrecioVenta(precioVenta);
                }
                if (cotizaciones.get(i).getPais().equalsIgnoreCase("brasil")){
                    BigDecimal precio = conviertePrecio(json.getString("brasil"));
                    cotizaciones.get(i).setPrecioCompra(precio);
                    precioVenta = precio.multiply(numeroMultiplicador);
                    cotizaciones.get(i).setPrecioCompra(precio);
                    cotizaciones.get(i).setPrecioVenta(precioVenta);
                }
                if (cotizaciones.get(i).getPais().equalsIgnoreCase("china")){
                    BigDecimal precio = conviertePrecio(json.getString("china"));
                    cotizaciones.get(i).setPrecioCompra(precio);
                    precioVenta = precio.multiply(numeroMultiplicador);
                    cotizaciones.get(i).setPrecioCompra(precio);
                    cotizaciones.get(i).setPrecioVenta(precioVenta);
                }
                if (cotizaciones.get(i).getPais().equalsIgnoreCase("india")){
                    BigDecimal precio = conviertePrecio(json.getString("india"));
                    cotizaciones.get(i).setPrecioCompra(precio);
                    precioVenta = precio.multiply(numeroMultiplicador);
                    cotizaciones.get(i).setPrecioCompra(precio);
                    cotizaciones.get(i).setPrecioVenta(precioVenta);
                }
                if (cotizaciones.get(i).getPais().equalsIgnoreCase("australia")){
                    BigDecimal precio = conviertePrecio(json.getString("australia"));
                    cotizaciones.get(i).setPrecioCompra(precio);
                    precioVenta = precio.multiply(numeroMultiplicador);
                    cotizaciones.get(i).setPrecioCompra(precio);
                    cotizaciones.get(i).setPrecioVenta(precioVenta);
                }
                if (cotizaciones.get(i).getPais().equalsIgnoreCase("rusia")){
                    BigDecimal precio = conviertePrecio(json.getString("rusia"));
                    cotizaciones.get(i).setPrecioCompra(precio);
                    precioVenta = precio.multiply(numeroMultiplicador);
                    cotizaciones.get(i).setPrecioCompra(precio);
                    cotizaciones.get(i).setPrecioVenta(precioVenta);
                }

            } catch (Exception e) {

            }
            i++;
        }

        //adaptador es la forma en que mostraremos los datos, se usa adaptador porque se agregan no solo un simple texto, una clase con moneda, imagen, valor, etc.
        // el segundo parametro es el layout, el tercero el array, en la clase miadaptadorcotizacion de java, va como mostrar los datos.
        AdaptadorCotizaciones miAdaptador = new AdaptadorCotizaciones(this.getContext(), R.layout.list_itemcard_cotizaciones,cotizaciones);
        listView.setAdapter(miAdaptador);

    }

    private BigDecimal conviertePrecio(String precioString) {

        Float valorFloat=Float.parseFloat(precioString);
        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        df.format(valorFloat);
        BigDecimal numeroMultiplicador = BigDecimal.valueOf(1.02);
        //  numero = numero*.(json);
        BigDecimal resul = BigDecimal.valueOf(valorFloat);

        resul = resul.multiply(numeroMultiplicador);

        df.setMaximumFractionDigits(2);
        String result = df.format(resul);
        // double res = Math.floor(numero * 1.014);
        String cadena = "";
        cadena = String.valueOf(result);
        //TextView divisaVenta = (TextView) findViewById(R.id.precioVenta);
        //divisaVenta.setText(cadena);

        return resul;
    }

}
