package com.betamobilemonkey.preciodeleuro.Servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestHelper {
    private static final int timeOut = 10000;
    private static final String contentType = "Content-type";
    private static final String jsonType = "application/json";


    private static String obtenerRespuesta(boolean error, HttpURLConnection connection) throws IOException {
        InputStream is;
        if (error)
            is = connection.getErrorStream();
        else
            is = connection.getInputStream();
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(is));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null)
            responseStrBuilder.append(inputStr);
        return responseStrBuilder.toString();

    }

    public static String createRestPost(String url, String objJson) throws Exception {
        String response = null;
        //TODO: pasar a https
        HttpURLConnection connection = null;

        // DebugLogConfig.enable();
        try {

            URL urlEntity = new URL(url);
            connection = (HttpURLConnection) urlEntity.openConnection();


            connection.setReadTimeout(RestHelper.timeOut);
            connection.setConnectTimeout(RestHelper.timeOut);
            connection.setRequestMethod("POST");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            connection.setRequestProperty(contentType, jsonType);
            //connection.setRequestProperty("Content-Length", Integer.toString(objJson.length()));


            connection.connect();

            //other option coud be OutputStreamWriter
            OutputStream out = connection.getOutputStream();
            out.write(objJson.getBytes());
            out.close();
            int codigo = connection.getResponseCode();
            if (codigo == 200) {
                response = RestHelper.obtenerRespuesta(false, connection);
            } else if (codigo == 306) {
                response = RestHelper.obtenerRespuesta(false, connection);
                throw new Exception();
            }else if (codigo == 401) {
                response = RestHelper.obtenerRespuesta(true, connection);
                throw new Exception();
            } else if (codigo == 500) {
                response = RestHelper.obtenerRespuesta(true, connection);
                throw new Exception();
            } else
                throw new Exception("Error desconocido");

        } catch (IOException e) {
            throw new Exception(e);

        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.disconnect();
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        return response;
    }

    public static String createRestGet(URL url) throws Exception {
        String response = null;
        //TODO: cambiar a https
        HttpURLConnection connection = null;

        try {
            //     URL urlEntity = new URL(uriWithParameters);
            //    connection = (HttpURLConnection) uriWithParameters.openConnection();

            connection = (HttpURLConnection)url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Length", "0");
            connection.setReadTimeout(RestHelper.timeOut);
            connection.setConnectTimeout(RestHelper.timeOut);
            connection.setUseCaches(false);
            connection.setAllowUserInteraction(false);

            connection.connect();
            int codigo = connection.getResponseCode();
            if (codigo == 200) {
                response = RestHelper.obtenerRespuesta(false, connection);
            }else if (codigo == 306) {
                response = RestHelper.obtenerRespuesta(false, connection);
                throw new Exception("Error desconocido");
            }else if (codigo == 401) {
                response = RestHelper.obtenerRespuesta(true, connection);
                throw new Exception("Error desconocido");
            }
            else if (codigo == 404) {
                response = null;
            } else if (codigo == 500) {
                response = RestHelper.obtenerRespuesta(true, connection);
                throw new Exception("Error desconocido");
            } else
                throw new Exception("Error desconocido");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new Exception(e);
        } catch (IOException e) {
            throw new Exception(e);
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.disconnect();
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        return response;
    }
}
