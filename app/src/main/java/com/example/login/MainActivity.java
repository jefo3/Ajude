package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView edTextEmail;
    TextView edTextSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTextEmail = findViewById(R.id.edTextEmail);
        edTextSenha = findViewById(R.id.edTextSenha);
    }

    public void TelaCadastro(View view){
        Intent telaCastro = new Intent(this, Cadastrar.class);
        startActivity(telaCastro);
    }

    public void TelaPrincipal(View view){

        if(edTextEmail.getText().toString().equals("root" ) && edTextSenha.getText().toString().equals("1234")){
            Intent telaPrincipal = new Intent(this, Casos.class);
            startActivity(telaPrincipal);
        }else{
            Toast.makeText(this, "Email ou Senha incorreto", Toast.LENGTH_LONG).show();
        }

    }

}