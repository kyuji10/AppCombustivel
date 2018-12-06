package com.example.android.appcombustivel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPrecoAlcool = findViewById(R.id.etAlcool);
        editPrecoGasolina = findViewById(R.id.etGasolina);
        resultado = findViewById(R.id.txtResultado);
    }

    public void Calcular(View view){

        //recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validar os campos digitados
        Boolean camposValidados = this.validarCampos(precoAlcool, precoGasolina);
        if (camposValidados){
            this.calcularMelhorPreco(precoAlcool, precoGasolina);

        } else {
            resultado.setText("Preencha os preços primeiro!");
        }
    }
    public void calcularMelhorPreco(String pAlcool, String pGasolina){

        //Converter valores string para numeros
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        //Cálculo para saber se é melhor gasolina ou alcool
        Double resultadoPreco = precoAlcool / precoGasolina;
        if (resultadoPreco >= 0.7){
            resultado.setText("Melhor utilizar Gasolina!");
        }else {
            resultado.setText("Melhor utilizar Álcool!");
        }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;

        //Validar Campos
        if (pAlcool==null  || pAlcool.equals("")){
            camposValidados = false;
        } else if (pGasolina==null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}
