package tech.edisystem.appmoney.movimientoslist.adapter;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tech.edisystem.appmoney.OnItemClickListener;
/*
import tech.edisystem.appmoney.movimientoslist.entity.Egresos;
import tech.edisystem.appmoney.movimientoslist.entity.Movimiento;

 */
import tech.edisystem.appmoney.movimientoslist.entity.Movimiento;

public class MovimientosAdapter extends RecyclerView.Adapter<MovimientosAdapter.ViewHolder> {

    private List<Movimiento> dataset;

    private OnItemClickListener<Movimiento> managerEventClick;

    public MovimientosAdapter(List<Movimiento> dataset, OnItemClickListener<Movimiento> managerEventClick){
        copiarDataSet(dataset);
        this.managerEventClick = managerEventClick;
    }

    private void copiarDataSet(List<Movimiento> dataset) {
    }

}
