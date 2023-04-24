package tech.edisystem.appmoney.movimientoslist.ui;

import static android.app.Activity.RESULT_OK;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import tech.edisystem.appmoney.OnItemClickListener;
import tech.edisystem.appmoney.crearmovimiento.ui.CrearMovimientoActivity;
import tech.edisystem.appmoney.databinding.FragmentFirstBinding;
import tech.edisystem.appmoney.eMoneyApp;
import tech.edisystem.appmoney.movimientoslist.entity.Movimiento;
import tech.edisystem.appmoney.movimientoslist.ui.adapter.MovimientosAdapter;

public class FirstFragment extends Fragment implements OnItemClickListener<Movimiento> {

    private FragmentFirstBinding binding;

    private MovimientosAdapter adaptador;

    private eMoneyApp app;

    private MovimientoViewModel movimientoViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState){
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        app = eMoneyApp.getInstance();
        movimientoViewModel = new ViewModelProvider(this).get(MovimientoViewModel.class);

        adaptador = new MovimientosAdapter(new ArrayList<>(), this);

        movimientoViewModel.getMovimientoDataset().observe(this, movimientos -> {
                adaptador.setItems(movimientos);
                validarDataset();
        });

        setupReciclerView();

        return binding.getRoot();

    }

    private void validarDataset() {
        if(adaptador.getItemCount() == 0){
            binding.tvWarning.setVisibility(View.VISIBLE);
            binding.ivWarning.setVisibility(View.VISIBLE);
            binding.rvMovimientos.setVisibility(View.VISIBLE);
        }else{
            binding.tvWarning.setVisibility(View.INVISIBLE);
            binding.ivWarning.setVisibility(View.INVISIBLE);
            binding.rvMovimientos.setVisibility(View.INVISIBLE);
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {super.onResume();}

    private void setupReciclerView(){
        LinearLayoutManager layoutLineal = new LinearLayoutManager(this.getContext());
        binding.rvMovimientos.setLayoutManager(layoutLineal);
        binding.rvMovimientos.setAdapter(adaptador);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(Movimiento data, int type){
        Intent intent = new Intent(this.getContext(), CrearMovimientoActivity.class);
        intent.putExtra("MOVIMIENTO_ID", data.getIdMovimiento());
        intent.putExtra("MOVIMIENTO_MONTO", data.getMontoMov());
        intent.putExtra("MOVIMIENTO_MOTIVO", data.getMotivoMov());
        intent.putExtra("MOVIMIENTO_TIPO", data.getTipoMov());
        intent.putExtra("MOVIMIENTO_FECHA", data.getFechaMov());
        intent.putExtra("MOVIMIENTO_GPS", data.getGpsMov());
        startActivityForResult(intent, 6, ActivityOptions.makeSceneTransitionAnimation(this.getActivity()).toBundle());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(resultCode == 6){
            if(resultCode == RESULT_OK){
                int id = data.getIntExtra("ID", 0);
                double monto = data.getDoubleExtra("MONTO",0);
                String motivo = data.getStringExtra("MOTIVO");
                int tipo = data.getIntExtra("TIPO", 0);
                String fecha = data.getStringExtra("FECHA");
                String gps = data.getStringExtra("GPS");

                Movimiento actualizar = new Movimiento(monto,fecha,motivo,tipo,gps);
                actualizar.setIdMovimiento(id);
                movimientoViewModel.update(actualizar);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}