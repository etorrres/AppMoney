package tech.edisystem.appmoney.movimientoslist.entity;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MovimientoDao {

    @Insert
    void insert(Movimiento nuevo);

    @Update
    void update(Movimiento actualizar);

    @Query("DELETE FROM movimiento_table")
    void deleteAllMovimientos();
    @Delete
    void delete(Movimiento eliminar);
    @Query("SELECT * FROM movimiento_table order by fechaMov asc")
    LiveData<List<Movimiento>> mostrarMovimientos();

}
