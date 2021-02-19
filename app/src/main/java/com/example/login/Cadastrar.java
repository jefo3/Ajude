package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.objetos.Usuario;

public class Cadastrar extends AppCompatActivity {

    TextView edNome;
    TextView edEmail;
    TextView edTelefone;
    TextView edSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        edNome = findViewById(R.id.edNome);
        edEmail = findViewById(R.id.edEmail);
        edTelefone = findViewById(R.id.edTelefone);
        edSenha = findViewById(R.id.edSenha);
    }

    public void cadastro(View view){
        Usuario user = new Usuario();

        String nome = edNome.getText().toString();
        String email = edEmail.getText().toString();
        String telefone = edTelefone.getText().toString();
        String senha = edSenha.getText().toString();

        user.setNome(nome);
        user.setEmail(email);
        user.setTelefone(telefone);
        user.setSenha(senha);

        Toast.makeText(this, "Usuario "+nome+" criado com sucesso", Toast.LENGTH_LONG).show();
        finish();
    }

    public void Cancelar(View view ){
        finish();
    }
}