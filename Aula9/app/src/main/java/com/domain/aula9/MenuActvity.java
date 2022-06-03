package com.domain.aula9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MenuActvity extends AppCompatActivity {

    private Button btCurso;
    private Button btDepartamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_actvity);

        btCurso = findViewById(R.id.btCurso);
        btDepartamento = findViewById(R.id.btDepartamento);

        btDepartamento.setOnClickListener();

        btCurso.setOnClickListener(view -> {

            Intent mensageiro = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mensageiro);

        });

    }
}