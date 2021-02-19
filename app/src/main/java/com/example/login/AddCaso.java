package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddCaso extends AppCompatActivity {

    TextView edTitulo;
    TextView edDescricao;
    TextView edValor;

    int id;

    boolean isEditar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_caso);

        edTitulo = findViewById(R.id.edTexTitulo);
        edDescricao = findViewById(R.id.edTextDescricao);
        edValor = findViewById(R.id.edTextValor);


        if(getIntent().getExtras() != null) {

            String titulo = getIntent().getExtras().get("titulo").toString();
            String descricao = getIntent().getExtras().get("descricao").toString();
            String valor = getIntent().getExtras().get("valor").toString();

            id = (int) getIntent().getExtras().get("id");

            edTitulo.setText(titulo);
            edDescricao.setText(descricao);
            edValor.setText(valor);


            isEditar = true;
        }
    }

    public void cancelar(View view){
        setResult(Constantes.RESULT_CANCEL);
        finish();
    }

    public void adicionar(View view){
        Intent intent = new Intent();

        String titulo = edTitulo.getText().toString();
        String descricao = edDescricao.getText().toString();
        double valor = Double.parseDouble( edValor.getText().toString());

        intent.putExtra("titulo", titulo);
        intent.putExtra("descricao", descricao);
        intent.putExtra("valor", valor);

        if(isEditar){
            intent.putExtra("id", id);
        }

        setResult(Constantes.RESULT_ADD, intent);
        finish();
    }


}