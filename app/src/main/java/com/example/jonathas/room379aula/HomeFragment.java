package com.example.jonathas.room379aula;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    Button btAdicionar, btListar, btAlterar, btDeletar;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btAdicionar = view.findViewById(R.id.buttonInserirUsuario);
        btAlterar = view.findViewById(R.id.buttonAlterarUsuario);
        btListar = view.findViewById(R.id.buttonListarUsuario);
        btDeletar = view.findViewById(R.id.buttonDeletarUsuario);


        btDeletar.setOnClickListener(this);
        btAdicionar.setOnClickListener(this);
        btAlterar.setOnClickListener(this);
        btListar.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonInserirUsuario:
                this.getFragment(new AdicionarAnuncioFragment());
                break;
            case R.id.buttonListarUsuario:
                this.getFragment(new ListarAnunciosFragment());
                break;
            case R.id.buttonAlterarUsuario:
                this.getFragment(new AlterarAnuncioFragment());
                break;
            case R.id.buttonDeletarUsuario:
                this.getFragment(new DeletarAnuncioFragment());
                break;
        }

    }

    private void getFragment(Fragment destinyFragment)
    {
        MainActivity.fragmentManager.beginTransaction().
                replace(R.id.frameConteiner,destinyFragment).addToBackStack(null).commit();
    }
}
