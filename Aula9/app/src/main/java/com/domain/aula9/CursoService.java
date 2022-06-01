package com.domain.aula9;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CursoService {

    @POST("courses")
    Call<CursoResponse> createRequestPost(@Body CursoPost cursoPost);

    @PUT("courses/{identificador}")
    Call<CursoResponse> createRequestPut(@Body CursoPost cursoPost, @Path("identificador") int id);

    @DELETE("courses/{id}")
    Call<Object> delete(@Path("id") int id);
}
