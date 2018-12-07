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
public class AdicionarAnuncioFragment extends Fragment {

    EditText editTextId, editTextQuantidade, editTextDescricao, editTextNomeAnunciante, editTextValor;
    Button buttonSalvarUsuario;


    public AdicionarAnuncioFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adicionar_anuncio, container, false);

        editTextId = view.findViewById(R.id.editTextInserirAnuncioId);
        editTextQuantidade = view.findViewById(R.id.editTextInserirAnuncioQuantidade);
        editTextDescricao = view.findViewById(R.id.editTextInserirAnuncioDescricao);
        editTextNomeAnunciante = view.findViewById(R.id.editTextInserirAnuncioNomeAnunciante);
        editTextValor = view.findViewById(R.id.editTextInserirAnuncioValor);
        buttonSalvarUsuario = view.findViewById(R.id.buttonInserirUsuarioBanco);

        buttonSalvarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = editTextId.getText().toString().equals("") ? 0 : Integer.parseInt(editTextId.getText().toString());
                int quantidade = editTextQuantidade.getText().toString().equals("") ? 0 : Integer.parseInt(editTextQuantidade.getText().toString());
                String descricao = editTextDescricao.getText().toString();
                String nomeAnunciante = editTextNomeAnunciante.getText().toString();
                double valor = editTextValor.getText().toString().equals("") ? 0 : Double.parseDouble(editTextValor.getText().toString());

                Anuncio anuncio = new Anuncio(id, quantidade, descricao, nomeAnunciante, valor);

                if (validar(anuncio)) {
                    MainActivity.myAppDatabase.myDAO().
                            inserirAnuncio(anuncio);

                    editTextId.setText("");
                    editTextId.setText("");
                    editTextDescricao.setText("");
                    editTextNomeAnunciante.setText("");
                    editTextValor.setText("");

                    Toast.makeText(getActivity(), "Anúncio criado com sucesso!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private boolean validar(Anuncio anuncio){
        if (MainActivity.myAppDatabase.buscaAnuncio(anuncio) || anuncio.getId() == 0) {
            Toast.makeText(getActivity(), "ID inválido", Toast.LENGTH_LONG).show();

            return false;
        }

        if (anuncio.getQuantidade() <= 0) {
            Toast.makeText(getActivity(), "Quantidade deve ser maior que 0", Toast.LENGTH_LONG).show();

            return false;
        }

        if (anuncio.getDescricao().equals("") || anuncio.getDescricao().length() < 5) {
            Toast.makeText(getActivity(), "Descrição deve ter 5 ou mais caracteres", Toast.LENGTH_LONG).show();

            return false;
        }

        if (anuncio.getNomeAnunciante().equals("") || anuncio.getNomeAnunciante().length() < 5) {
            Toast.makeText(getActivity(), "Nome do anunciante deve ter 5 ou mais caracteres", Toast.LENGTH_LONG).show();

            return false;
        }

        if (anuncio.getValor() <= 0) {
            Toast.makeText(getActivity(), "Valor deve ser maior que 0", Toast.LENGTH_LONG).show();

            return false;
        }

        return true;
    }

}
