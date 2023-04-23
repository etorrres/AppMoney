package tech.edisystem.appmoney.database;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import tech.edisystem.appmoney.movimientoslist.entity.Movimiento;
import tech.edisystem.appmoney.movimientoslist.entity.MovimientoDao;

public class MovimientoRepository {

    private MovimientoDao movimientoDao;
    private LiveData<List<Movimiento>> movimientosDataset;
    //private LiveData<List<Egresos>> egresosDataset;

    public MovimientoRepository(Application app){
        MovimientosDatabase db = MovimientosDatabase.getDatabase(app);
        movimientoDao = db.movimientoDao();
        movimientosDataset = movimientoDao.mostrarMovimientos();

    }
/*
    public LiveData<List<Ingresos>> getIngresosDataset() {
        return ingresoDataset;
    }

    public LiveData<List<Egresos>> getEgresosDataset() {
        return egresosDataset;
    }

    public void insert(Ingresos nuevo){
        MovimientosDatabase.databaseWriteExecutor.execute(() ->{
            movimientoDao.insert(nuevo);
        });
    }
    public void insert(Egresos nuevo){
        MovimientosDatabase.databaseWriteExecutor.execute(() ->{
            movimientoDao.insert(nuevo);
        });
    }

    public void delete(Ingresos eliminar){
        MovimientosDatabase.databaseWriteExecutor.execute(() ->{
            movimientoDao.delete(eliminar);
        });
    }
    public void delete(Egresos eliminar){
        MovimientosDatabase.databaseWriteExecutor.execute(() ->{
            movimientoDao.delete(eliminar);
        });
    }

    public void deleteAll(){
        MovimientosDatabase.databaseWriteExecutor.execute(() ->{
            movimientoDao.deleteAllIngresos();
        });
    }
    public void deleteAllEgrs(){
        MovimientosDatabase.databaseWriteExecutor.execute(() ->{
            movimientoDao.deleteAllEgresos();
        });
    }

 */
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
