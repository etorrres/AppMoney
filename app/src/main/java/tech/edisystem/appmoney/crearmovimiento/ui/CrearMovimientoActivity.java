package tech.edisystem.appmoney.crearmovimiento.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;

import tech.edisystem.appmoney.R;
import tech.edisystem.appmoney.databinding.ActivityCrearMovimientoBinding;
import tech.edisystem.appmoney.movimientoslist.entity.Movimiento;
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
           resultado.putExtra("TIPO", binding.spiTipoMovimiento.getSelectedItem().toString());
           resultado.putExtra("MONTO", binding.txtMonto.getText().toString());
           resultado.putExtra("FECHA", binding.txtFecha.getText().toString());
           resultado.putExtra("MOTIVO", binding.txtMotivo.getText().toString());
           resultado.putExtra("GPS", binding.tvUbicacion.getText().toString());

           setResult(Activity.RESULT_OK, resultado);
           finish();
       });
    }

    private void obtenerDatosIntent(Intent intent) {
        String motivo = intent.getStringExtra("MOVIMIENTO_MOTIVO");

        if(motivo != null){
            int tipo = intent.getIntExtra("MOVIMIENTO_TIPO",0);
            double monto = intent.getDoubleExtra("MOVIMIENTO_MONTO",0);
            String fecha = intent.getStringExtra("MOVIMIENTO_FECHA");
            String gps = intent.getStringExtra("MOVIMIENTO_GPS");

            binding.txtMotivo.getText().append(motivo);
            binding.spiTipoMovimiento.getSelectedItem().equals(tipo);
            binding.txtMonto.getText().append(String.valueOf(monto));
            binding.txtFecha.getText().append(fecha);
            binding.tvUbicacion.setText(gps);
            
            binding.toolbar.setTitle(R.string.title_update_move);
        }else {
            binding.btnGuardar.setText(R.string.btn_crear_movimiento);
            
            binding.toolbar.setTitle(R.string.title_new_move);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.eliminar_movimiento, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        
        int id = item.getItemId();
        
        if(id == android.R.id.home){
            onBackPressed();
        } else if (id == R.id.action_delete_movimiento) {
            Movimiento movimientoEliminar = new Movimiento(0,
                    binding.txtFecha.getText().toString(),
                    binding.txtMotivo.getText().toString(),
                    binding.spiTipoMovimiento.getSelectedItem().hashCode(),
                    binding.tvUbicacion.getText().toString());

            movimientoEliminar.setIdMovimiento(idMovimiento);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage(R.string.delete_dialog_message)
                    .setTitle(R.string.delete_dialog_title);

            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id){
                    movimientoViewModel.delete(movimientoEliminar);

                    Snackbar.make(binding.clCrearVehiculo, getString(R.string.mensaje_eliminacion_mov), Snackbar.LENGTH_LONG).show();

                    finish();
                }
            });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id){

                }
            });
        }

        return super.onOptionsItemSelected(item);
    }
}