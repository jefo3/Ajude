package com.example.login.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.login.AddCaso;
import com.example.login.Constantes;
import com.example.login.R;
import com.example.login.TelaDetalhada;
import com.example.login.objetos.Caso;
import com.example.login.objetos.RepositorioCaso;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ListView lista;
    ArrayList<Caso> a;
    ArrayAdapter<Caso> adapter;

    int selected = -1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        lista = root.findViewById(R.id.ListaCasosHome);



        a = RepositorioCaso.getCasos();


        adapter = new ArrayAdapter<Caso>(getActivity(), android.R.layout.simple_list_item_1, a);
        lista.setAdapter(adapter);


        lista.setSelector(android.R.color.holo_blue_bright );

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = position;


                Intent telaDathe = new Intent(getActivity(), TelaDetalhada.class);


                telaDathe.putExtra("titulo", a.get(selected).getTitulo());
                telaDathe.putExtra("descricao", a.get(selected).getDescricao());
                telaDathe.putExtra("valor", a.get(selected).getValor());
                telaDathe.putExtra("id", a.get(selected).getId());

                startActivity(telaDathe);
            }

        });


        return root;
    }

}