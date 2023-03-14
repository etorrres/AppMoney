package tech.edisystem.appmoney.movimientoslist.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ingresos_table")
public class Ingresos {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idIngreso")
    private Integer idIngreso;

    @NonNull
    @ColumnInfo(name = "montoIngreso")
    private String montoIngreso;

    @NonNull
    @ColumnInfo(name = "fechaIngreso")
    private String fechaIngreso;

    @NonNull
    @ColumnInfo(name = "motivoIngreso")
    private String motivoIngreso;

    public Ingresos(@NonNull String montoIngreso, @NonNull String fechaIngreso, @NonNull String motivoIngreso){
        this.montoIngreso = montoIngreso;
        this.fechaIngreso = fechaIngreso;
        this.motivoIngreso = motivoIngreso;
    }

    @NonNull
    public String getMontoIngreso() {
        return montoIngreso;
    }

    public void setMontoIngreso(@NonNull String montoIngreso) {
        this.montoIngreso = montoIngreso;
    }

    @NonNull
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(@NonNull String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @NonNull
    public String getMotivoIngreso() {
        return motivoIngreso;
    }

    public void setMotivoIngreso(@NonNull String motivoIngreso) {
        this.motivoIngreso = motivoIngreso;
    }
}
