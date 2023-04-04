package com.elifelipe.bioinsumoscatalogo.api;

import com.elifelipe.bioinsumoscatalogo.model.Data;
import com.elifelipe.bioinsumoscatalogo.model.DataRetornoItem;
import com.elifelipe.bioinsumoscatalogo.model.DataRetornoItemInoculante;
import com.elifelipe.bioinsumoscatalogo.model.Resultado;
import com.elifelipe.bioinsumoscatalogo.model.ResultadoInoculantes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("produtos-biologicos")
    Call<Resultado> recuperaBiologicos(@Header("Authorization") String authHeader);

    @GET("produtos-biologicos/{registro-produto}")
    Call <DataRetornoItem> recuperaBiologicosPesquisa(
            @Path("registro-produto") String registro,
            @Header("Authorization") String authHeader);

    @GET("inoculantes")
    Call<ResultadoInoculantes> recuperaInoculantes(@Header("Authorization") String authHeader);

    @GET("inoculantes/{registroProduto}")
    Call<DataRetornoItemInoculante> recuperaInoculantesPesquisa(
            @Path("registroProduto") String registro,
            @Header("Authorization") String authHeader);
}

