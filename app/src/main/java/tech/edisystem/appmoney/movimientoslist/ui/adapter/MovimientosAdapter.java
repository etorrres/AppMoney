package tech.edisystem.appmoney.movimientoslist.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tech.edisystem.appmoney.OnItemClickListener;
import tech.edisystem.appmoney.R;
import tech.edisystem.appmoney.movimientoslist.entity.Movimiento;
import tech.edisystem.appmoney.databinding.MovimientoItemBinding;


public class MovimientosAdapter extends RecyclerView.Adapter<MovimientosAdapter.ViewHolder> {

    private List<Movimiento> dataset;

    private OnItemClickListener<Movimiento> managerEventClick;

    public MovimientosAdapter(List<Movimiento> dataset, OnItemClickListener<Movimiento> managerEventClick){
        copiarDataSet(dataset);
        this.managerEventClick = managerEventClick;
    }

    @NonNull
    @Override
    public MovimientosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovimientoItemBinding binding = MovimientoItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovimientosAdapter.ViewHolder holder, int position) {
        Movimiento movimientoShow = dataset.get(position);
        holder.binding.ivMonto.setText(Double.toString(movimientoShow.getMontoMov());
        holder.binding.ivFecha.setText(movimientoShow.getFechaMov());
        if(movimientoShow.getTipoMov() == 1){
            holder.binding.imgTipo.setImageResource(R.drawable.ic_ingreso_24);
        }else if (movimientoShow.getTipoMov() == 2){
            holder.binding.imgTipo.setImageResource(R.drawable.ic_egreso_24);
        }
    }

    @Override
    public int getItemCount() {return dataset.size(); }

    public void setItems(List<Movimiento> datasetNuevo){
        copiarDataSet(datasetNuevo);
        notifyDataSetChanged();
    }

    private void copiarDataSet(List<Movimiento> datasetNuevo) {
        if(this.dataset == null){
            this.dataset = new ArrayList<>();
        }
        this.dataset.clear();
        datasetNuevo.forEach( d-> {
            this.dataset.add(d);
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        MovimientoItemBinding binding;

        public ViewHolder(MovimientoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setOnClickListener(final Movimiento movimientoSelect, final OnItemClickListener<Movimiento> listener){
            this.binding.cardMovimiento.setOnClickListener(v-> listener.onItemClick(movimientoSelect,1));
        }

    }
}
