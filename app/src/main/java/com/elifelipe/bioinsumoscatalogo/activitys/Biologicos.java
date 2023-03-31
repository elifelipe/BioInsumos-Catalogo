package com.elifelipe.bioinsumoscatalogo.activitys;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ProgressBar;
import com.elifelipe.bioinsumoscatalogo.R;
import com.elifelipe.bioinsumoscatalogo.adapter.AdapterBiologicos;
import com.elifelipe.bioinsumoscatalogo.api.ApiService;
import com.elifelipe.bioinsumoscatalogo.helper.RetrofitConfig;
import com.elifelipe.bioinsumoscatalogo.model.Data;
import com.elifelipe.bioinsumoscatalogo.model.Resultado;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Biologicos extends AppCompatActivity {

    public RecyclerView recyclerView;
    public AdapterBiologicos adapterBiologicos;

    private List<Data> dataList = new ArrayList<>();

    private Resultado resultado;

    private Retrofit retrofit;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biologicos);
        retrofit = RetrofitConfig.getRetrofit();
        configuraTollbar();
        recuperaDados();
        configuraRecyclerView();

        TrasProgressBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    public void TrasProgressBar(){
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
    }

    private void configuraTollbar() {
        //configura toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setTitle("Biologicos");
        setSupportActionBar( toolbar );
    }

    private void recuperaDados(){
        ApiService apiService = retrofit.create(ApiService.class);

        apiService.recuperaBiologicosPesquisa("Bearer 5e5f5869-3889-321c-a40b-bd70ec3c26e7", "198").enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                Log.d("resultado", "resultado: " + response.toString() );
                progressBar.setVisibility(View.GONE);
                if( response.isSuccessful() ){
                    resultado = response.body();
                    dataList = resultado.data;

                }
            }

            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {

            }
        });
    }


    public void configuraRecyclerView() {

        adapterBiologicos = new AdapterBiologicos(dataList);
        recyclerView = findViewById(R.id.biologicos_recycler_view);
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapterBiologicos);
        } else {
            Log.e(TAG, "recyclerView é nulo");
        }
    }
}