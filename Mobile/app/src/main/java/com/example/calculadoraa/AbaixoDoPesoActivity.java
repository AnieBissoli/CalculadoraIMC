package com.example.calculadoraa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AbaixoDoPesoActivity extends AppCompatActivity {

    TextView textoPeso, textoAltura, textoIMC, textoClassificacao, textoMensagem;
    ImageView imagemCategoria;
    Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abaixo_do_peso);

        // Pegando os dados da intent
        Intent intent = getIntent();
        double peso = intent.getDoubleExtra("peso", 0);
        double altura = intent.getDoubleExtra("altura", 0);
        double imc = intent.getDoubleExtra("imc", 0);

        // Inicializando os componentes da tela
        textoPeso = findViewById(R.id.textoPeso);
        textoAltura = findViewById(R.id.textoAltura);
        textoIMC = findViewById(R.id.textoIMC);
        textoClassificacao = findViewById(R.id.textoClassificacao);
        textoMensagem = findViewById(R.id.textoMensagem);
        imagemCategoria = findViewById(R.id.imagemCategoria);
        btnFechar = findViewById(R.id.btnFechar);

        // Definindo os valores nos componentes
        textoPeso.setText("Peso: " + peso + " kg");
        textoAltura.setText("Altura: " + altura + " m");

        String imcFormatado = String.format(getString(R.string.texto_imc_formatado), imc);
        textoIMC.setText(imcFormatado);

        textoClassificacao.setText("Classificação: Abaixo do Peso");
        textoMensagem.setText(R.string.mensagem_abaixo_peso);
        imagemCategoria.setImageResource(R.drawable.abaixo_peso);

        // Botão de fechar
        btnFechar.setOnClickListener(v -> {
            Intent voltar = new Intent(AbaixoDoPesoActivity.this, MainActivity.class);
            voltar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(voltar);
            finish();
        });
    }
}
