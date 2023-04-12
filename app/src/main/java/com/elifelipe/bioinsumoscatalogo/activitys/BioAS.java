package com.elifelipe.bioinsumoscatalogo.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.elifelipe.bioinsumoscatalogo.R;

public class BioAS extends AppCompatActivity {

    private TextView textViewE;
    private ImageView imageViewG;
    private TextView textViewF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_as);
        configuraTollbar();

        textViewE = findViewById(R.id.textViewC);
        imageViewG = findViewById(R.id.imageViewC);
        textViewF = findViewById(R.id.textViewD);

    }
    private void configuraTollbar() {
        //configura toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setTitle("Controle biológico");
        setSupportActionBar( toolbar );
    }
}