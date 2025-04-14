package com.example.calculadoraa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CalculoIMCActivity extends AppCompatActivity {

    EditText campoPeso, campoAltura;
    Button btnCalcular, btnLimpar, btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

        campoPeso = findViewById(R.id.campoPeso);
        campoAltura = findViewById(R.id.campoAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFechar = findViewById(R.id.btnFechar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pesoStr = campoPeso.getText().toString();
                String alturaStr = campoAltura.getText().toString();

                if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
                    Toast.makeText(CalculoIMCActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double peso = Double.parseDouble(pesoStr);
                double altura = Double.parseDouble(alturaStr);
                double imc = peso / (altura * altura);

                Intent intent;

                if (imc < 18.5) {
                    intent = new Intent(CalculoIMCActivity.this, AbaixoDoPesoActivity.class);
                } else if (imc < 25) {
                    intent = new Intent(CalculoIMCActivity.this, PesoNormalActivity.class);
                } else if (imc < 30) {
                    intent = new Intent(CalculoIMCActivity.this, SobrepesoActivity.class);
                } else if (imc < 35) {
                    intent = new Intent(CalculoIMCActivity.this, Obesidade1Activity.class);
                } else if (imc < 40) {
                    intent = new Intent(CalculoIMCActivity.this, Obesidade2Activity.class);
                } else {
                    intent = new Intent(CalculoIMCActivity.this, Obesidade3Activity.class);
                }

                intent.putExtra("peso", peso);
                intent.putExtra("altura", altura);
                intent.putExtra("imc", imc);
                startActivity(intent);
            }
        });

        btnLimpar.setOnClickListener(v -> {
            campoPeso.setText("");
            campoAltura.setText("");
        });

        btnFechar.setOnClickListener(v -> finish());
    }
}