package com.domain.aula9;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CursoService {

    @POST("courses")
    Call<CursoResponse> createRequestPost(@Body CursoPost cursoPost);

    @PUT("course/{curso_id}")
    Call<CursoResponse> createRequestPut(@Body CursoPost cursoPost, @Path("curso_id") int id);

}
