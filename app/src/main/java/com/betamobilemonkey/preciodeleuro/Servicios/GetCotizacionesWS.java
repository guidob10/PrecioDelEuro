package com.betamobilemonkey.preciodeleuro.Servicios;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.betamobilemonkey.preciodeleuro.Fragments.CotizacionesFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;


public class GetCotizacionesWS extends AsyncTask<Void, Void, Void> {

    private final CotizacionesFragment fragment;
    Context context;
    String url;
    boolean error = false;
    JSONObject jsonRespuesta = null;
    JSONArray jsonArrayRespuesta = null;
    boolean esRespuestaArray = false;
    int codigoMensajeError = 1;
    ProgressDialog progresoTask;

    public GetCotizacionesWS(CotizacionesFragment fragmentCotizaciones) {

        this.fragment = fragmentCotizaciones;
        // this.url = PropertiesHelper.getProperty("GetEventosTask", fragment.getActivity().getApplicationContext());
        this.esRespuestaArray = false;
    }


    @Override
    protected Void doInBackground(Void... params) {
        Boolean success = false;
        String response = "";

        try {
            //Uri uri = creaLlamada();
            URL url = new URL(String.format("http://dolarhoyinfo.com/selectpreciosapp.php"));

            //Create GET
            response = RestHelper.createRestGet(url);

            if (!esRespuestaArray) {
                success = procesaRespuestaObjeto(response);
            } else {
                success = procesaRespuestaArray(response);
            }


        } catch (JSONException e) {
            error = true;

        } catch (Exception e) {
            error = true;
        }
        return null;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(progresoTask != null)
            this.progresoTask.show();
    }

    @Override
    protected void onPostExecute(Void result) {
        ArrayList<CotizacionJson> cotizaciones = new ArrayList<CotizacionJson>();
        if (!error) {

            try {

                String test = jsonRespuesta.getString("argentina");

            } catch (Exception e) {

                super.onPostExecute(result);
            }

            this.fragment.getCotizacionesWSCallBack(jsonRespuesta);

            super.onPostExecute(result);
            //     }
        }
    }

    public class CotizacionJson {

        private String pais;
        private String precio;

        public CotizacionJson(String pais, String precio) {
            this.pais = pais;
            this.precio = precio;

        }
    }

    private boolean procesaRespuestaObjeto(String response) throws JSONException{
        boolean success =false;
        if (response != null) {
            jsonRespuesta = new JSONObject(response);
            success = true;
        }
        return success;
    }

    private boolean procesaRespuestaArray(String response)  throws JSONException{
        boolean success =false;
        if (response != null) {
            jsonArrayRespuesta = new JSONArray(response);
            success = true;
        }
        return success;
    }
}