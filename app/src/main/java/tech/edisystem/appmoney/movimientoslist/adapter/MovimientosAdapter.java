package tech.edisystem.appmoney.movimientoslist.adapter;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tech.edisystem.appmoney.OnItemClickListener;
import tech.edisystem.appmoney.movimientoslist.entity.Egresos;

public class MovimientosAdapter extends RecyclerView.Adapter<MovimientosAdapter.ViewHolder> {

    private List<Egresos> dataset;

    private OnItemClickListener<Egresos> managerEventClick;

    public MovimientosAdapter(List<Egresos> dataset, OnItemClickListener<Egresos> managerEventClick){
        copiarDataSet(dataset);
        this.managerEventClick = managerEventClick;
    }

    private void copiarDataSet(List<Egresos> dataset) {
    }

}
