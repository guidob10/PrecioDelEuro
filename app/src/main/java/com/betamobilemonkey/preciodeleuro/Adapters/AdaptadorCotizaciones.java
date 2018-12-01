package com.betamobilemonkey.preciodeleuro.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.betamobilemonkey.preciodeleuro.Entidades.Cotizacion;
import com.betamobilemonkey.preciodeleuro.R;

import java.text.DecimalFormat;
import java.util.List;

public class AdaptadorCotizaciones extends BaseAdapter {
// Este adaptador se usa para mostrar la informacion que queremos, tenemos metodos
// donde elegimos cuantos items se van a mostrar, para saber la cantidad de elementos o agarrar uno particular.

    private Context context;
    private int layout;
    private List<Cotizacion> cotizaciones;
    public ImageView img;


    public AdaptadorCotizaciones(Context context, int layout, List<Cotizacion> cotizaciones) {
        this.context = context;
        this.layout = layout;
        this.cotizaciones = cotizaciones;
    }


    @Override
    public int getCount() {
       return this.cotizaciones.size();
    }

    @Override
    public Object getItem(int position) {
        return this.cotizaciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vistaCotizacion = convertView;

        //inflamos la vista que nos llega, que es un layout determinado
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        vistaCotizacion = layoutInflater.inflate(R.layout.list_itemcard_cotizaciones,null );

        //traemos el dato en la posicion que pida
        Cotizacion cotizacion = cotizaciones.get(position);

        img = (ImageView) vistaCotizacion.findViewById(R.id.imagenBandera);
        img.setImageResource(cotizaciones.get(position).getImagen());

        TextView textViewCot = (TextView) vistaCotizacion.findViewById(R.id.lblListItem);
        textViewCot.setText(cotizaciones.get(position).getPais());

        TextView textViewDiv = (TextView) vistaCotizacion.findViewById(R.id.lblCodigoIso);
        textViewDiv.setText(cotizaciones.get(position).getDivisa());

        TextView textViewCompra = (TextView) vistaCotizacion.findViewById(R.id.precioCompra);
        textViewCompra.setText(new DecimalFormat("#.##").format(cotizacion.getPrecioCompra()).toString());

        TextView textViewVenta = (TextView) vistaCotizacion.findViewById(R.id.precioVenta);
        textViewVenta.setText(new DecimalFormat("#.##").format(cotizacion.getPrecioVenta()).toString());

        //devuelve la vista inflada con los cambios
        return vistaCotizacion;
    }
}