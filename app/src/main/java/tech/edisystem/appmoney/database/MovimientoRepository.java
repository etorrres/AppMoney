package tech.edisystem.appmoney.database;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import tech.edisystem.appmoney.movimientoslist.entity.Egresos;
import tech.edisystem.appmoney.movimientoslist.entity.Ingresos;
import tech.edisystem.appmoney.movimientoslist.entity.MovimientoDao;

public class MovimientoRepository {

    private MovimientoDao movimientoDao;
    private LiveData<List<Ingresos>> ingresoDataset;
    private LiveData<List<Ingresos>> egresosDataset;

    public MovimientoRepository(Application app){
        MovimientosDatabase db = MovimientosDatabase.getDatabase(app);
        movimientoDao = db.movimientoDao();
        ingresoDataset = movimientoDao.mostrarIngresos();
    }

    public LiveData<List<Ingresos>> getIngresosDataset() {
        return ingresoDataset;
    }

    public void insert(Ingresos nuevo){
        MovimientosDatabase.databaseWriteExecutor.execute(() ->{
            movimientoDao.insert(nuevo);
        });
    }

    public void delete(Ingresos eliminar){
        MovimientosDatabase.databaseWriteExecutor.execute(() ->{
            movimientoDao.delete(eliminar);
        });
    }

    public void deleteAll(){
        MovimientosDatabase.databaseWriteExecutor.execute(() ->{
            movimientoDao.deleteAllIngresos();
        });
    }
}
