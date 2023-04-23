package tech.edisystem.appmoney.crearmovimiento.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import tech.edisystem.appmoney.R;
import tech.edisystem.appmoney.movimientoslist.ui.MovimientoViewModel;

public class CrearMovimientoActivity extends AppCompatActivity {

    private ActivityCrearMovimientoBinding binding;

    private int idMovimiento;

    private MovimientoViewModel movimientoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        movimientoViewModel = new ViewModelProvider( this).get(MovimientoViewModel.class);

        binding = ActivityCrearMovimientoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        obtenerDatosIntent(getIntent());
        setSupportActionBar(binding.toolbar);

       binding.btnGuardar.setOnClickListener(v-> {
           Intent resultado = new Intent();
           resultado.putExtra("ID", idMovimiento);

           setResult(Activity.RESULT_OK, resultado);
           finish();
       });
    }

    private void obtenerDatosIntent(Integer intent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.eliminar_movimiento, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        return super.onOptionsItemSelected(item);
    }
}