package com.domain.aula9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etNomeCurso;
    private EditText etIdCurso;
    private Button btCadastrar;
    private Button btEditar;
    private TextView tvDescricaoCurso;

    private CursoService service;
    private CursoResponse cursoAtualizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNomeCurso = findViewById(R.id.etNomeCurso);
        etIdCurso = findViewById(R.id.etIdCurso);
        btCadastrar = findViewById(R.id.btCadastrar);
        btEditar = findViewById(R.id.btEditar);
        tvDescricaoCurso = findViewById(R.id.tvCursoCadastrada);

        service = new RetrofitConfig()
                .criarService();

        CursoPost sendCursoBody = new CursoPost();

        btCadastrar.setOnClickListener(view -> {
            String texto = etNomeCurso.getText().toString();
            sendCursoBody.setName(texto);
            executarRequestPost(sendCursoBody);
        });

        Button deletar = findViewById(R.id.btDeletar);
        deletar.setOnClickListener(view -> {

            service.delete(2325).enqueue(new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Sucesso", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Erro de comunicação " + response.code(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Object> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Falha na request", Toast.LENGTH_LONG).show();
                }
            });

        });


        btEditar.setOnClickListener(view -> {
            String novoNomeDoCurso = etNomeCurso.getText().toString();
            String idDigitadoPeloUsuario = etIdCurso.getText().toString();
            int id = Integer.parseInt(idDigitadoPeloUsuario);

            CursoPost cursoPut = new CursoPost();
            cursoPut.setName(novoNomeDoCurso);

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
        });

    }

    private void executarRequestPost(CursoPost cursoPost) {
        service.createRequestPost(cursoPost).enqueue(new Callback<CursoResponse>() {
            @Override
            public void onResponse(Call<CursoResponse> call, Response<CursoResponse> response) {
                cursoAtualizado = response.body();

                String id = Integer.toString(cursoAtualizado.getId());
                etIdCurso.setText(id);
                Toast.makeText(getApplicationContext(), "Sucesso", Toast.LENGTH_LONG).show();

                tvDescricaoCurso.setText("O curso que foi cadastrado: \n " + cursoAtualizado.toString());
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