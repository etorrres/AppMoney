package tech.edisystem.appmoney.database;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import tech.edisystem.appmoney.movimientoslist.entity.Movimiento;
import tech.edisystem.appmoney.movimientoslist.entity.MovimientoDao;

public class MovimientoRepository {

    private MovimientoDao movimientoDao;
    private LiveData<List<Movimiento>> movimientosDataset;

    public MovimientoRepository(Application app){
        MovimientosDatabase db = MovimientosDatabase.getDatabase(app);
        movimientoDao = db.movimientoDao();
        movimientosDataset = movimientoDao.mostrarMovimientos();

    }

    public LiveData<List<Movimiento>> getMovimientosDataset() {
        return movimientosDataset;
    }
    public void insert(Movimiento nuevo){
        MovimientosDatabase.databaseWriteExecutor.execute(() ->{
            movimientoDao.insert(nuevo);
        });
    }

    public void update(Movimiento actualizar){
        MovimientosDatabase.databaseWriteExecutor.execute(() ->{
            movimientoDao.update(actualizar);
        });
    }

    public void delete(Movimiento eliminar){
        MovimientosDatabase.databaseWriteExecutor.execute(() ->{
            movimientoDao.delete(eliminar);
        });
    }

    public void deleteAll(){
        MovimientosDatabase.databaseWriteExecutor.execute(() ->{
            movimientoDao.deleteAllMovimientos();
        });
    }
}
