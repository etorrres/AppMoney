package tech.edisystem.appmoney.movimientoslist.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.snackbar.Snackbar;

import tech.edisystem.appmoney.R;
import tech.edisystem.appmoney.crearmovimiento.ui.CrearMovimientoActivity;
import tech.edisystem.appmoney.databinding.ActivityMainBinding;
import tech.edisystem.appmoney.eMoneyApp;
import tech.edisystem.appmoney.movimientoslist.entity.Movimiento;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private eMoneyApp app;

    private double monto;
    private String motivo;
    private String fecha;
    private int tipo;
    private String gps;

    private MovimientoViewModel movimientoViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        app = eMoneyApp.getInstance();
        movimientoViewModel = new ViewModelProvider(this).get(MovimientoViewModel.class);

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(view -> {
            Intent intent = new Intent(this, CrearMovimientoActivity.class);
        });
        getWindow().setEnterTransition(new Explode());
        getWindow().setExitTransition(new Explode());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 7){
            String tipo_text="";
            if(resultCode == RESULT_OK){
                monto = data.getDoubleExtra("MONTO",0);
                fecha = data.getStringExtra("FECHA");
                motivo = data.getStringExtra("MOTIVO");
                tipo = data.getIntExtra("TIPO", 1);
                gps = data.getStringExtra("GPS");

                movimientoViewModel.insert(new Movimiento(monto, fecha, motivo, tipo, gps));

                if(tipo==1){
                    tipo_text = "Ingreso";
                } else if (tipo ==2) {
                    tipo_text = "Engreso";
                }

                String datosMovimiento = tipo_text +" de Lps. " +monto + " ("+fecha + ")";

                Snackbar.make(binding.clMainLayout, getString(R.string.mensaje_creacion_movimiento, datosMovimiento), Snackbar.LENGTH_LONG).show();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delete_all) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            // 2. Chain together various setter methods to set the dialog characteristics
            builder.setMessage(R.string.delete_all_dialog_message)
                    .setTitle(R.string.delete_dialog_title);

            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    movimientoViewModel.deleteAll();
                    Snackbar.make(binding.clMainLayout, getString(R.string.mensaje_eliminar_todo), Snackbar.LENGTH_LONG).show();
                }
            });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}