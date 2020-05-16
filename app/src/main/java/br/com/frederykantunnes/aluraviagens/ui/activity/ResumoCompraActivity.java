package br.com.frederykantunnes.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.frederykantunnes.aluraviagens.R;
import br.com.frederykantunnes.aluraviagens.model.Pacote;
import br.com.frederykantunnes.aluraviagens.util.FormatDiaUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle("Resumo da Compra");
        Pacote pacote = getExtraData(savedInstanceState);
        preencherCampos(pacote);

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

    private void preencherCampos(Pacote pacote) {
        preencheCidade(pacote);
        preenchePeriodo(pacote);
        preencheValor(pacote);
        preencheImagem(pacote);
    }

    private void preencheImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem);
        imagem.setTransitionName(pacote.getFoto());
    }

    private void preencheValor(Pacote pacote) {
        TextView valor = findViewById(R.id.resumo_compra_valor);
        valor.setText(pacote.getValor());
    }

    private void preenchePeriodo(Pacote pacote) {
        TextView periodo = findViewById(R.id.resumo_compra_periodo);
        periodo.setText(FormatDiaUtil.getTimeDuration(pacote.getDias()));
    }

    private void preencheCidade(Pacote pacote) {
        TextView cidade = findViewById(R.id.resumo_compra_cidade);
        cidade.setText(pacote.getCidade());
    }
}
