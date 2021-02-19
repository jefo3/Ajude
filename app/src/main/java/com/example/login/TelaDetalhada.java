package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.TextView;

public class TelaDetalhada extends AppCompatActivity {
    TextView edTextTitulo;
    TextView edTextDescricao;
    TextView edTextValor;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_detalhada);

        edTextTitulo = findViewById(R.id.edTexTitulo);
        edTextDescricao = findViewById(R.id.edTextDescricao);
        edTextValor = findViewById(R.id.edTextValor);

        if(getIntent().getExtras() != null) {

            String titulo = getIntent().getExtras().get("titulo").toString();
            String descricao = getIntent().getExtras().get("descricao").toString();
            String valor = getIntent().getExtras().get("valor").toString();

            id = (int) getIntent().getExtras().get("id");

            edTextTitulo.setText(titulo);
            edTextDescricao.setText(descricao);
            edTextValor.setText(valor);



        }

    }

    public void ajudar(View view){
        String numero = "6282596914";

        Intent wpp = new Intent("android.intent.action.MAIN");
        wpp.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
        wpp.putExtra("jid", PhoneNumberUtils.stripSeparators("55"+numero) + "@s.whatsapp.net");


        startActivity(wpp);
    }
}