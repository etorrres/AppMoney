package tech.edisystem.appmoney.database;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import tech.edisystem.appmoney.movimientoslist.entity.Ingresos;
import tech.edisystem.appmoney.movimientoslist.entity.MovimientoDao;

public class MovimientoRepository {

    private MovimientoDao movimientoDao;
    private LiveData<List<Ingresos>> movimientoDataset;

    public MovimientoRepository(Application app){
        MovimientosDatabase db = MovimientosDatabase.getDatabase(app);
        movimientoDao = db.movimientoDao();
        movimientoDataset = movimientoDao.mostrarIngresos();
    }

}
