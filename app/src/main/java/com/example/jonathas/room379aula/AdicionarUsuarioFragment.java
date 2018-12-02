package com.example.jonathas.room379aula;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdicionarUsuarioFragment extends Fragment {

    EditText editTextId, editTextQuantidade, editTextDescricao, editTextNomeAnunciante, editTextValor;
    Button buttonSalvarUsuario;


    public AdicionarUsuarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_adicionar_usuario, container, false);

        editTextId = view.findViewById(R.id.editTextInserirAnuncioId);
        editTextQuantidade = view.findViewById(R.id.editTextInserirAnuncioQuantidade);
        editTextDescricao = view.findViewById(R.id.editTextInserirAnuncioDescricao);
        editTextNomeAnunciante = view.findViewById(R.id.editTextInserirAnuncioNomeAnunciante);
        editTextValor = view.findViewById(R.id.editTextInserirAnuncioValor);
        buttonSalvarUsuario = view.findViewById(R.id.buttonInserirUsuarioBanco);

        buttonSalvarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(editTextId.getText().toString());
                int quantidade = Integer.parseInt(editTextQuantidade.getText().toString());
                String descricao = editTextDescricao.getText().toString();
                String nomeAnunciante = editTextNomeAnunciante.getText().toString();
                double  valor = Double.parseDouble(editTextValor.getText().toString());

                Anuncio anuncio = new Anuncio(id, quantidade, descricao, nomeAnunciante, valor);

                MainActivity.myAppDatabase.myDAO().
                        inserirAnuncio(anuncio);

                editTextId.setText("");
                editTextId.setText("");
                editTextDescricao.setText("");
                editTextNomeAnunciante.setText("");
                editTextValor.setText("");

                Toast.makeText(getActivity(), "Anúncio criado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
