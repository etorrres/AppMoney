package tech.edisystem.appmoney.movimientoslist.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "estado_table")
public class estado {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idEstado")
    private Integer idEgreso;

    @NonNull
    @ColumnInfo(name = "saldoActual")
    private String saldoActual;

    @NonNull
    @ColumnInfo(name = "ultimoMovimientoGps")
    private String ultimoMovimientoGps;

    public estado(@NonNull Integer idEgreso, @NonNull String saldoActual, @NonNull String ultimoMovimientoGps) {
        this.idEgreso = idEgreso;
        this.saldoActual = saldoActual;
        this.ultimoMovimientoGps = ultimoMovimientoGps;
    }

    @NonNull
    public Integer getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(@NonNull Integer idEgreso) {
        this.idEgreso = idEgreso;
    }

    @NonNull
    public String getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(@NonNull String saldoActual) {
        this.saldoActual = saldoActual;
    }

    @NonNull
    public String getUltimoMovimientoGps() {
        return ultimoMovimientoGps;
    }

    public void setUltimoMovimientoGps(@NonNull String ultimoMovimientoGps) {
        this.ultimoMovimientoGps = ultimoMovimientoGps;
    }
}
