package com.elifelipe.bioinsumoscatalogo.api;

import com.elifelipe.bioinsumoscatalogo.adapter.PragasAdapter;
import com.elifelipe.bioinsumoscatalogo.model.Data;
import com.elifelipe.bioinsumoscatalogo.model.Pragas;
import com.elifelipe.bioinsumoscatalogo.model.Resultado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiService {
    @GET("produtos-biologicos")
    Call<Resultado> recuperaBiologicos(@Header("Authorization") String authHeader);

    @GET("pragas")
    Call<List<Pragas>> buscarPragas();
}

