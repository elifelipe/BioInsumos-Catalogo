package com.elifelipe.bioinsumoscatalogo.api;

import com.elifelipe.bioinsumoscatalogo.model.Data;
import com.elifelipe.bioinsumoscatalogo.model.Resultado;
import com.elifelipe.bioinsumoscatalogo.model.ResultadoInoculantes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ApiService {
    @GET("produtos-biologicos")
    Call<Resultado> recuperaBiologicos(@Header("Authorization") String authHeader);

    @GET("produtos-biologicos/{registro-produto}")
    Call<Data> recuperaBiologicosPesquisa(@Header("Authorization") String authHeader, @Path("registro-produto") String registroProduto);

    @GET("inoculantes")
    Call<ResultadoInoculantes> recuperaInoculantes(@Header("Authorization") String authHeader);
}

