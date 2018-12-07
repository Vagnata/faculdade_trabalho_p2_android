package com.example.jonathas.room379aula;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeletarAnuncioFragment extends Fragment {
    EditText ed1;
    Button bt1;

    public DeletarAnuncioFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deletar_anuncio, container, false);

        ed1 = view.findViewById(R.id.editTextDeletarPorId);
        bt1 = view.findViewById(R.id.buttonDeletarPorId);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(ed1.getText().toString());
                String msg = "Não foi possível encontrar o anúncio com o ID: " + id;
                Anuncio anuncio = new Anuncio(id);

                if (MainActivity.myAppDatabase.buscaAnuncio(anuncio)) {
                    MainActivity.myAppDatabase.myDAO().deletarAnuncio(anuncio);
                    msg = "Anúncio deletado com sucesso";
                }

                ed1.setText("");
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
