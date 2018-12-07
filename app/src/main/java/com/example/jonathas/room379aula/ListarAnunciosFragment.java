package com.example.jonathas.room379aula;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListarAnunciosFragment extends Fragment {

    TextView textView;


    public ListarAnunciosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_listar_anuncios, container, false);

        textView = view.findViewById(R.id.textViewListarUsuarios);

        List<Anuncio> anuncioList = MainActivity.myAppDatabase.myDAO().listarAnuncios();

        String info = "";

        for (Anuncio anuncio: anuncioList) {
            int id = anuncio.getId();
            String descricao = anuncio.getDescricao();
            String nomeAnunciante = anuncio.getNomeAnunciante();
            int quantidade = anuncio.getQuantidade();
            double valor = anuncio.getValor();

            info = info + "\n\n" +
                    "ID: " + id +
                    "\n" + "Descrição: " + descricao +
                    "\n" + "Anunciante: " + nomeAnunciante +
                    "\n" + "Quantidade: " + quantidade +
                    "\n" + "Valor: " + valor;
        }
        textView.setText(info);

        return view;

    }

}
