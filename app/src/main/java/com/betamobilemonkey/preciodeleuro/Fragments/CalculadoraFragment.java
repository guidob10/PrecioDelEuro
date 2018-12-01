package com.betamobilemonkey.preciodeleuro.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.betamobilemonkey.preciodeleuro.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculadoraFragment extends Fragment {

    Double numero1,numero2,resultadoCalculadora;
    String operador;


    public CalculadoraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment, se modifica return para ir añadiendo datos a la vista

        View view = inflater.inflate(R.layout.fragment_calculadora,
                container, false);

        Button buttonCero = (Button) view.findViewById(R.id.main_btn_0);
        buttonCero.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView tv = (TextView) getView().findViewById(R.id.txtNumero) ;
                tv.setText(tv.getText() + "0");
            }
        });

        Button buttonUno = (Button) view.findViewById(R.id.main_btn_1);
        buttonUno.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView tv = (TextView) getView().findViewById(R.id.txtNumero) ;
                tv.setText(tv.getText() + "1");
            }
        });

        Button buttonDos = (Button) view.findViewById(R.id.main_btn_2);
        buttonDos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tv = (TextView) getView().findViewById(R.id.txtNumero);
                tv.setText(tv.getText() + "2");
            }
        });

        Button buttonTres = (Button) view.findViewById(R.id.main_btn_3);
        buttonTres.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tv = (TextView) getView().findViewById(R.id.txtNumero);
                tv.setText(tv.getText() + "3");
            }
        });

        Button buttonCuatro = (Button) view.findViewById(R.id.main_btn_4);
        buttonCuatro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tv = (TextView) getView().findViewById(R.id.txtNumero);
                tv.setText(tv.getText() + "4");
            }
        });

        Button buttonCinco = (Button) view.findViewById(R.id.main_btn_5);
        buttonCinco.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tv = (TextView) getView().findViewById(R.id.txtNumero);
                tv.setText(tv.getText() + "5");
            }
        });

        Button buttonSeis = (Button) view.findViewById(R.id.main_btn_6);
        buttonSeis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tv = (TextView) getView().findViewById(R.id.txtNumero);
                tv.setText(tv.getText() + "6");
            }
        });

        Button buttonSiete = (Button) view.findViewById(R.id.main_btn_7);
        buttonSiete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tv = (TextView) getView().findViewById(R.id.txtNumero);
                tv.setText(tv.getText() + "7");
            }
        });

        Button buttonOcho = (Button) view.findViewById(R.id.main_btn_8);
        buttonOcho.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tv = (TextView) getView().findViewById(R.id.txtNumero);
                tv.setText(tv.getText() + "8");
            }
        });

        Button buttonNueve = (Button) view.findViewById(R.id.main_btn_9);
        buttonNueve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tv = (TextView) getView().findViewById(R.id.txtNumero);
                tv.setText(tv.getText() + "9");
            }
        });

        Button buttonPunto = (Button) view.findViewById(R.id.main_btn_punto);
        buttonPunto.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View v){
            TextView tv = (TextView) getView().findViewById(R.id.txtNumero);
            tv.setText(tv.getText() + ".");
            }
        });

        Button buttonLimpia = (Button) view.findViewById(R.id.main_btn_limpia);
        buttonLimpia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numero1 = 0.0;
                numero2 = 0.0;
                TextView tv = (TextView) getView().findViewById(R.id.txtNumero);
                tv.setText("");
            }
        });

        Button buttonSuma = (Button) view.findViewById(R.id.main_btn_mas);
        buttonSuma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                operador="+";
                onClickOperacionCapturaNumero1(getView());
            }
        });

        Button buttonResta = (Button) view.findViewById(R.id.main_btn_menos);
        buttonResta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                operador="-";
                onClickOperacionCapturaNumero1(getView());
            }
        });

        Button buttonMult = (Button) view.findViewById(R.id.main_btn_x);
        buttonMult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                operador="*";
                onClickOperacionCapturaNumero1(getView());
            }
        });

        Button buttonDiv = (Button) view.findViewById(R.id.main_btn_div);
        buttonDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                operador="/";
                onClickOperacionCapturaNumero1(getView());
            }
        });

        Button buttonIgual = (Button) view.findViewById(R.id.main_btn_igual);
        buttonIgual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tv = (TextView) getView().findViewById(R.id.txtNumero) ;

                try {

                    numero2 = Double.parseDouble(tv.getText().toString());

                    if(operador.equals("+"))
                    {
                        resultadoCalculadora= numero1+numero2;
                    }
                    else if(operador.equals("-"))
                    {
                        resultadoCalculadora= numero1-numero2;
                    }
                    else if(operador.equals("*"))
                    {
                        resultadoCalculadora= numero1*numero2;
                    }
                    else if(operador.equals("/"))
                    {
                        resultadoCalculadora= numero1/numero2;
                    }
                    tv.setText(resultadoCalculadora.toString());

                } catch (Throwable e) {
                    tv.setText("");
                }
            }
        });



        return view;


    }


    public void onClickOperacionCapturaNumero1(View miView)
    {
        TextView tv = (TextView) miView.findViewById(R.id.txtNumero) ;

        try {
            numero1 = Double.parseDouble(tv.getText().toString());

        } catch (Throwable e) {
            tv.setText("");
        }

        tv.setText("");
    }



}
