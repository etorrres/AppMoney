package tech.edisystem.appmoney.movimientoslist.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "egresos_table")
public class Egresos {


    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idEgreso")
    private Integer idEgreso;

    @NonNull
    @ColumnInfo(name = "montoEgreso")
    private String montoEgreso;

    @NonNull
    @ColumnInfo(name = "fechaEgreso")
    private String fechaEgreso;

    @NonNull
    @ColumnInfo(name = "motivoEgreso")
    private String motivoEgreso;

    public Egresos(@NonNull String montoEgreso, @NonNull String fechaEgreso, String motivoEgreso) {
        this.montoEgreso = montoEgreso;
        this.fechaEgreso = fechaEgreso;
        this.motivoEgreso = motivoEgreso;
    }

    @NonNull
    public Integer getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(@NonNull Integer idEgreso) {
        this.idEgreso = idEgreso;
    }

    @NonNull
    public String getMontoEgreso() {
        return montoEgreso;
    }

    public void setMontoEgreso(@NonNull String montoEgreso) {
        this.montoEgreso = montoEgreso;
    }

    @NonNull
    public String getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(@NonNull String fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    @NonNull
    public String getMotivoEgreso() {
        return motivoEgreso;
    }

    public void setMotivoEgreso(@NonNull String motivoEgreso) {
        this.motivoEgreso = motivoEgreso;
    }

}