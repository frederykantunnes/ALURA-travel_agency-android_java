package br.com.frederykantunnes.aluraviagens.ui.activity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.frederykantunnes.aluraviagens.R;
import br.com.frederykantunnes.aluraviagens.dao.PacoteDAO;
import br.com.frederykantunnes.aluraviagens.model.Pacote;
import br.com.frederykantunnes.aluraviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String APP_BAR_TITLE = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(APP_BAR_TITLE);
        configuraLista();
    }

    private void configuraLista() {
        List<Pacote> minhalista = PacoteDAO.lista();
        ListView lista = findViewById(R.id.list_item );
        lista.setAdapter(new ListaPacotesAdapter(minhalista, ListaPacotesActivity.this));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
                intent.putExtra("pacote", PacoteDAO.lista().get(position));
                startActivity(intent);
            }
        });
    }
}
