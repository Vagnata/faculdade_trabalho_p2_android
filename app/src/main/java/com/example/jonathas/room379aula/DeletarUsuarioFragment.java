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
public class DeletarUsuarioFragment extends Fragment {
    EditText ed1;
    Button bt1;

    public DeletarUsuarioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deletar_usuario, container, false);

        ed1 = view.findViewById(R.id.editTextDeletarPorId);
        bt1 = view.findViewById(R.id.buttonDeletarPorId);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(ed1.getText().toString());
                Anuncio anuncio = new Anuncio(id);

                MainActivity.myAppDatabase.myDAO().deletarAnuncio(anuncio);
                ed1.setText("");

                Toast.makeText(getActivity(), "Anúncio deletado com sucesso", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
