package com.domain.aula9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etNomeCurso;
    private EditText etIdCurso;
    private Button btCadastrar;
    private Button btEditar;

    private CursoService service;
    private CursoResponse cursoResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNomeCurso = findViewById(R.id.etNomeCurso);
        etIdCurso = findViewById(R.id.etIdCurso);
        btCadastrar = findViewById(R.id.btCadastrar);
        btEditar = findViewById(R.id.btEditar);

        service = new RetrofitConfig()
                .criarService();

        CursoPost sendCursoBody = new CursoPost();

        btCadastrar.setOnClickListener(view -> {
            sendCursoBody.setName(etNomeCurso.getText().toString());
            executarRequestPost(sendCursoBody);
        });

        btEditar.setOnClickListener(view -> {
            sendCursoBody.setName(etNomeCurso.getText().toString());
            executarRequestPut(sendCursoBody, cursoResponse.getId());
        });

    }

    private void executarRequestPost(CursoPost cursoPost) {
        service.createRequestPost(cursoPost).enqueue(new Callback<CursoResponse>() {
            @Override
            public void onResponse(Call<CursoResponse> call, Response<CursoResponse> response) {
                cursoResponse = response.body();
                Toast.makeText(getApplicationContext(), "Sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<CursoResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Falha na request", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void executarRequestPut(CursoPost cursoPut, int id) {
        service.createRequestPut(cursoPut, id).enqueue(new Callback<CursoResponse>() {
            @Override
            public void onResponse(Call<CursoResponse> call, Response<CursoResponse> response) {
                Toast.makeText(getApplicationContext(), "Sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<CursoResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Falha na request", Toast.LENGTH_LONG).show();
            }
        });
    }
}