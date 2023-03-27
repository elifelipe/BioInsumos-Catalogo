package com.elifelipe.bioinsumoscatalogo.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.elifelipe.bioinsumoscatalogo.R;
import com.elifelipe.bioinsumoscatalogo.adapter.PragasAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configuraTollbar();
    }

    public void configuraTollbar(){
        //configura toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar );
    }

    public void buttonbiologicos(View view){
        Intent intent = new Intent(this, PragasBiologicos.class);
        startActivity(intent);
    }

}
