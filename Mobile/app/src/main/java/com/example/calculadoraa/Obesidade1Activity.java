package com.example.calculadoraa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class Obesidade1Activity extends AppCompatActivity {

    TextView textoPeso, textoAltura, textoIMC, textoClassificacao, textoMensagem;
    ImageView imagemCategoria;
    Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obesidade1);

        textoPeso = findViewById(R.id.textoPeso);
        textoAltura = findViewById(R.id.textoAltura);
        textoIMC = findViewById(R.id.textoIMC);
        textoClassificacao = findViewById(R.id.textoClassificacao);
        textoMensagem = findViewById(R.id.textoMensagem);
        imagemCategoria = findViewById(R.id.imagemCategoria);
        btnFechar = findViewById(R.id.btnFechar);

        Intent intent = getIntent();
        double peso = intent.getDoubleExtra("peso", 0);
        double altura = intent.getDoubleExtra("altura", 0);
        double imc = intent.getDoubleExtra("imc", 0);

        textoPeso.setText("Peso: " + peso + " kg");
        textoAltura.setText("Altura: " + altura + " m");
        textoIMC.setText("IMC: " + String.format("%.2f", imc));
        textoClassificacao.setText("Classificação: Obesidade Grau 1");
        textoMensagem.setText(R.string.mensagem_obesidade1);
        imagemCategoria.setImageResource(R.drawable.obesidade1);

        btnFechar.setOnClickListener(v -> {
            Intent voltar = new Intent(this, MainActivity.class);
            voltar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(voltar);
            finish();
        });
    }
}