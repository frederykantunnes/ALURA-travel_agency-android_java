package br.com.frederykantunnes.aluraviagens.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.frederykantunnes.aluraviagens.model.Pacote;

public class PacoteDAO {
    public static List<Pacote> lista(){
        List<Pacote>  list = new ArrayList<>(Arrays.asList(
                new Pacote("R$ 200,00", 3, "Princesa Isabel", "@drawable/recife"),
                new Pacote("R$ 300,00", 1, "Sao Paulo", "@drawable/recife"),
                new Pacote("R$ 250,00", 5, "Fortaleza", "@drawable/recife"),
                new Pacote("R$ 200,00", 4, "Recife", "@drawable/recife"),
                new Pacote("R$ 300,00", 2, "Sao Paulo", "@drawable/recife"),
                new Pacote("R$ 250,00", 1, "Fortaleza", "@drawable/recife")
        ));
        return list;
    }
}
