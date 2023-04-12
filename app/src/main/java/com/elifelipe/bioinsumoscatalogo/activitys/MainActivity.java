package com.elifelipe.bioinsumoscatalogo.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.elifelipe.bioinsumoscatalogo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configuraTollbar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_embrapa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(this, Biologicos.class);
                startActivity(intent);
                Toast.makeText(this, "Produtos Biologicos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                intent = new Intent(this, Inoculantes.class);
                startActivity(intent);
                Toast.makeText(this, "Produtos Inoculantes", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                return true;
            case R.id.subitem1:
                intent = new Intent(this, ControleBiologico.class);
                startActivity(intent);
                Toast.makeText(this, "Controle Biologico", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem2:
                intent = new Intent(this, BioAS.class);
                startActivity(intent);
                Toast.makeText(this, "BioAs", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void configuraTollbar(){
        //configura toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar );
    }

    public void buttonbiologicos(View view){
        Intent intent = new Intent(this, Biologicos.class);
        startActivity(intent);
    }

    public void buttonInoculantes(View view){
        Intent intent = new Intent(this, Inoculantes.class);
        startActivity(intent);
    }


}
