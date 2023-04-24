package tech.edisystem.appmoney.movimientoslist.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "movimiento_table")
public class Movimiento {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idMovimiento")
    private Integer idMovimiento;

    @NonNull
    @ColumnInfo(name = "montoMov")
    private double montoMov;

    @NonNull
    @ColumnInfo(name = "fechaMov")
    private String fechaMov;

    @NonNull
    @ColumnInfo(name = "motivoMov")
    private String motivoMov;

    @NonNull
    @ColumnInfo(name = "tipoMov")
    private Integer tipoMov;

    @NonNull
    @ColumnInfo(name = "gpsMov")
    private String gpsMov;

    public Movimiento(@NonNull double montoMov, @NonNull String fechaMov, @NonNull String motivoMov, @NonNull Integer tipoMov, @NonNull String gpsMovi){
        this.montoMov = montoMov;
        this.fechaMov = fechaMov;
        this.motivoMov = motivoMov;
        this.tipoMov = tipoMov;
        this.gpsMov = gpsMovi;
    }

    @NonNull
    public Integer getIdMovimiento(){return idMovimiento;}

    public void setIdMovimiento(@NonNull Integer idMovimiento) {this.idMovimiento = idMovimiento;}

    public double getMontoMov(){return montoMov = montoMov;}

    public String getFechaMov(){return fechaMov = fechaMov;}

    public String getMotivoMov() {return motivoMov = motivoMov;}

    public String getGpsMov() {return  gpsMov = gpsMov;}

    public Integer getTipoMov() {return tipoMov = tipoMov;}

    public void setMontoMov(double montoMov) {
        this.montoMov = montoMov;
    }

    public void setFechaMov(@NonNull String fechaMov) {
        this.fechaMov = fechaMov;
    }

    public void setMotivoMov(@NonNull String motivoMov) {
        this.motivoMov = motivoMov;
    }

    public void setTipoMov(@NonNull Integer tipoMov) {
        this.tipoMov = tipoMov;
    }

    public void setGpsMov(@NonNull String gpsMov) {
        this.gpsMov = gpsMov;
    }
}
