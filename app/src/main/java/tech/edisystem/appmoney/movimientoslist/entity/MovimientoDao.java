package tech.edisystem.appmoney.movimientoslist.entity;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface MovimientoDao {

@Insert
void insert(Egresos nuevo);

}
