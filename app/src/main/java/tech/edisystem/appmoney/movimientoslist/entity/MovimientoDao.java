package tech.edisystem.appmoney.movimientoslist.entity;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MovimientoDao {
/*
@Insert
void insert(Egresos nuevoEgreso);

@Insert
void insert(Ingresos nuevoIngreso);
@Delete
void delete(Egresos eliminarEgreso);

@Delete
void delete(Ingresos eliminarIngreso);

@Query("DELETE FROM egresos_table")
void deleteAllEgresos();

@Query("DELETE FROM ingresos_table")
void deleteAllIngresos();

@Query("SELECT * FROM egresos_table order by fechaEgreso asc")
LiveData<List<Egresos>> mostrarEgresos();


@Query("SELECT * FROM egresos_table WHERE fechaEgreso = :fechaEgreso")
LiveData<List<Egresos>> mostrarEgresoFecha(String fechaEgreso);
*/
    @Insert
    void insert(Movimiento nuevo);

    @Query("DELETE FROM movimientos_table")
    void deleteAllMovimientos();
    @Delete
    void delete(Movimiento eliminar);
    @Query("SELECT * FROM movimientos_table order by fechaMov asc")
    LiveData<List<Movimiento>> mostrarMovimientos();


}
