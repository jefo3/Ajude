package com.example.login.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import com.example.login.objetos.Caso;
import com.example.login.objetos.RepositorioCaso;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    ListView lista;
    ArrayList<Caso> b;
    ArrayAdapter<Caso> adapter;

    int selected = -1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        lista = root.findViewById(R.id.ListaCasosDash);
        b = new ArrayList<Caso>();
        Caso caso1 = new Caso("Cachorro Atropelado", "cachorro atropelado na rua 12 e precisa de cirurgia", 1200);
        Caso caso2 = new Caso("Gato Atropelado", "Gata atropelado na rua 12 e precisa de cirurgia", 1300);

        b.add(caso1);
        b.add(caso2);

        RepositorioCaso.setCasos(b);

        adapter = new ArrayAdapter<Caso>(getActivity(), android.R.layout.simple_list_item_1, b);
        lista.setAdapter(adapter);


        lista.setSelector(android.R.color.holo_blue_bright );

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = position;
            }
        });


        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inf){
        inf.inflate(R.menu.menu_dashboard, menu);

        super.onCreateOptionsMenu(menu, inf);
    }



    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add:
                adicionar();
                break;
            case R.id.editar:
                editar();
                break;
            case R.id.del:
                deletar();
                break;
        }

        return true;
    }

    private void adicionar(){
        Intent telaAddCaso = new Intent(getContext(), AddCaso.class);
        startActivityForResult(telaAddCaso, Constantes.REQUEST_ADD);
    }

    private void editar(){
        Intent telaAddCaso = new Intent(getContext(), AddCaso.class);

        telaAddCaso.putExtra("titulo", b.get(selected).getTitulo());
        telaAddCaso.putExtra("descricao", b.get(selected).getDescricao());
        telaAddCaso.putExtra("valor", b.get(selected).getValor());
        telaAddCaso.putExtra("id", b.get(selected).getId());

        startActivityForResult(telaAddCaso, Constantes.REQUEST_EDIT);
    }

    private void deletar(){
        if(selected >= 0){
            b.remove(selected);
            adapter.notifyDataSetChanged();
        }
    }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(resultCode == Constantes.RESULT_ADD){

            if(data.getExtras() != null){
                String titulo = data.getExtras().get("titulo").toString();
                String descricao = data.getExtras().get("descricao").toString();
                Double valor = (Double) data.getExtras().get("valor");

                if(requestCode == Constantes.REQUEST_ADD && resultCode == Constantes.RESULT_ADD){
                    Caso casos = new Caso(titulo, descricao, valor);

                    b.add(casos);
                    adapter.notifyDataSetChanged();
                }else if(requestCode == Constantes.REQUEST_EDIT && resultCode == Constantes.RESULT_ADD){
                    int idCaso = (int) data.getExtras().get("id");

                    for(Caso x: b){
                        if(x.getId() == idCaso){
                            x.setTitulo(titulo);
                            x.setDescricao(descricao);
                            x.setValor(valor);
                        }
                    }

                    adapter.notifyDataSetChanged();
                }

                RepositorioCaso.setCasos(b);
            }


        }




    }





}