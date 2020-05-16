package br.com.frederykantunnes.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.frederykantunnes.aluraviagens.R;
import br.com.frederykantunnes.aluraviagens.model.Pacote;

public class PagamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle("Pagamento");
        Pacote pacote;
        pacote = getExtraData(savedInstanceState);
        loadElements(pacote);
    }

    private Pacote getExtraData(Bundle savedInstanceState) {
        Pacote pacote;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                pacote = null;
            } else {
                pacote = (Pacote) extras.getSerializable("pacote");
            }
        } else {
            pacote = (Pacote) savedInstanceState.getSerializable("pacote");
        }
        return pacote;
    }

    private void loadElements(Pacote pacote) {
        TextView valor = findViewById(R.id.pagamento_valor);
        EditText cartao_numero = findViewById(R.id.pagamento_numero_cartao);
        EditText cartao_nome = findViewById(R.id.pagamento_nome_cartao);
        EditText cartao_dia = findViewById(R.id.pagamento_dia_venc);
        EditText cartao_ano = findViewById(R.id.pagamento_ano_venc);
        EditText cartao_cvv = findViewById(R.id.pagamento_cvv);
        Button botao_finalizar = findViewById(R.id.pagamento_botao_finalizar);
        valor.setText(pacote.getValor());
        eventClick(botao_finalizar, pacote);


    }

    private void eventClick(Button botao_finalizar, final Pacote pacote) {
        botao_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                intent.putExtra("pacote", pacote);
                startActivity(intent);
                finish();
            }
        });
    }
}
