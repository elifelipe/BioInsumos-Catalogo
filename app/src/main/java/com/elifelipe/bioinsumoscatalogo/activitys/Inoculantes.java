package com.elifelipe.bioinsumoscatalogo.activitys;

import static android.content.ContentValues.TAG;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.elifelipe.bioinsumoscatalogo.R;
import com.elifelipe.bioinsumoscatalogo.adapter.AdapterInoculantes;
import com.elifelipe.bioinsumoscatalogo.api.ApiService;
import com.elifelipe.bioinsumoscatalogo.helper.RetrofitConfig;
import com.elifelipe.bioinsumoscatalogo.model.Data2;
import com.elifelipe.bioinsumoscatalogo.model.Resultado;
import com.elifelipe.bioinsumoscatalogo.model.ResultadoInoculantes;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Inoculantes extends AppCompatActivity {

    public RecyclerView recyclerView;
    public AdapterInoculantes adapterInoculantes;

    private List<Data2> dataList2 = new ArrayList<>();

    private ResultadoInoculantes resultadoInoculantes;

    private Retrofit retrofit;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inoculantes);
        retrofit = RetrofitConfig.getRetrofit();
        configuraTollbar();
        recuperaDados();
        TrasProgressBar();
    }

    public void TrasProgressBar(){
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
    }




    private void configuraTollbar() {
        //configura toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setTitle("Inoculantes");
        setSupportActionBar( toolbar );
    }


    private void recuperaDados(){
        ApiService apiService = retrofit.create(ApiService.class);

        apiService.recuperaInoculantes("Bearer 5e5f5869-3889-321c-a40b-bd70ec3c26e7").enqueue(new Callback<ResultadoInoculantes>() {
            @Override
            public void onResponse(Call<ResultadoInoculantes> call, Response<ResultadoInoculantes> response) {
                Log.d("resultado", "resultado: " + response.toString() );
                progressBar.setVisibility(View.GONE);
                if( response.isSuccessful() ){
                    resultadoInoculantes = response.body();
                    dataList2 = resultadoInoculantes.data;
                    Log.d("resultado", "resultado: " + dataList2.get(1) );

                    configuraRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<ResultadoInoculantes> call, Throwable t) {

            }


        });

    }

    public void configuraRecyclerView() {

        adapterInoculantes = new AdapterInoculantes(dataList2);
        recyclerView = findViewById(R.id.biologicos_recycler_inoclulantes);
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapterInoculantes);
        } else {
            Log.e(TAG, "recyclerView é nulo");
        }

    }
}