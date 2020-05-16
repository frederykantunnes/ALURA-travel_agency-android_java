package br.com.frederykantunnes.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.frederykantunnes.aluraviagens.R;
import br.com.frederykantunnes.aluraviagens.model.Pacote;
import br.com.frederykantunnes.aluraviagens.util.FormatDiaUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle("Resumo");
        Pacote pacote  = getExtraData(savedInstanceState);
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
        ImageView imagem = findViewById(R.id.resumo_imagem);
        TextView cidade = findViewById(R.id.resumo_cidade);
        TextView dias = findViewById(R.id.resumo_dias);
        TextView data = findViewById(R.id.resumo_data);
        TextView valor = findViewById(R.id.resumo_valor);
        Button pagar = findViewById(R.id.resumo_botao_pagar);

        eventClick(pacote, imagem, cidade, dias, data, valor, pagar);
    }

    private void eventClick(final Pacote pacote, ImageView imagem, TextView cidade, TextView dias, TextView data, TextView valor, Button pagar) {
        setData(imagem, cidade, dias, data, valor, pacote);
        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
                intent.putExtra("pacote", pacote);
                startActivity(intent);
                finish();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void setData(ImageView imagem, TextView cidade, TextView dias, TextView data, TextView valor, Pacote pacote) {
        imagem.setImageResource(R.drawable.recife);
        cidade.setText(pacote.getCidade());
        dias.setText(pacote.getDias()+ FormatDiaUtil.getDiasFormat(pacote.getDias()));
        valor.setText(pacote.getValor());
        data.setText(FormatDiaUtil.getTimeDuration(pacote.getDias()));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
