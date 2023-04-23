package tech.edisystem.appmoney.movimientoslist.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import tech.edisystem.appmoney.database.MovimientoRepository;
import tech.edisystem.appmoney.movimientoslist.entity.Movimiento;

public class MovimientoViewModel extends AndroidViewModel {

    private MovimientoRepository repository;

    private final LiveData<List<Movimiento>> movimientoDataset;

    public MovimientoViewModel(@NonNull Application application) {
        super(application);
        repository = new MovimientoRepository(application);
        this.movimientoDataset = repository.getMovimientosDataset();
    }

    public LiveData<List<Movimiento>> getMovimientoDataset() {return movimientoDataset; }

    public void insert(Movimiento nuevo) {repository.insert(nuevo);}

    public void update(Movimiento actualizar) { repository.update(actualizar);}

    public void delete(Movimiento eliminar) {repository.delete(eliminar);}

    public void deleteAll(){
        repository.deleteAll();
    }

    public void deleteAllMovimientos(){repository.deleteAll();}

}
