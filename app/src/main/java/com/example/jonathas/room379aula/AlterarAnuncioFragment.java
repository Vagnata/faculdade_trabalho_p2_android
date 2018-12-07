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
public class AlterarAnuncioFragment extends Fragment {

    EditText editTextId, editTextQuantidade, editTextDescricao, editTextNomeAnunciante, editTextValor;
    Button btAt;

    public AlterarAnuncioFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alterar_anuncio, container, false);

        editTextId = view.findViewById(R.id.editTextAlterarAnuncioId);
        editTextQuantidade = view.findViewById(R.id.editTextAlterarAnuncioQuantidade);
        editTextDescricao = view.findViewById(R.id.editTextAlterarAnuncioDescricao);
        editTextNomeAnunciante = view.findViewById(R.id.editTextAlterarAnuncioNomeAnunciante);
        editTextValor = view.findViewById(R.id.editTextAlterarAnuncioValor);
        btAt = view.findViewById(R.id.buttonAlterarUsuario);

        btAt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(editTextId.getText().toString());
                int quantidade = Integer.parseInt(editTextQuantidade.getText().toString());
                String descricao = editTextDescricao.getText().toString();
                String nomeAnunciante = editTextNomeAnunciante.getText().toString();
                double valor = Double.parseDouble(editTextValor.getText().toString());

                Anuncio anuncio = new Anuncio(id, quantidade, descricao, nomeAnunciante, valor);

                MainActivity.myAppDatabase.myDAO().atualizarAnuncio(anuncio);

                Toast.makeText(getActivity(), "Anúncio atualizado com sucesso!",
                        Toast.LENGTH_SHORT).show();

                editTextId.setText("");
                editTextQuantidade.setText("");
                editTextDescricao.setText("");
                editTextNomeAnunciante.setText("");
                editTextValor.setText("");
            }
        });
        return view;
    }

}
