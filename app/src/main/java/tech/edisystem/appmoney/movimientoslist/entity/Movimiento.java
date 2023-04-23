package tech.edisystem.appmoney.movimientoslist.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "movimientos_table")
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
    private String motivoEgreso;

    @NonNull
    @ColumnInfo(name = "gpsMov")
    private String gpsMovi;

    public Movimiento(@NonNull double montoMov, @NonNull String fechaMov, @NonNull String motivoEgreso, @NonNull String gpsMovi){
        this.montoMov = montoMov;
        this.fechaMov = fechaMov;
        this.motivoEgreso = motivoEgreso;
        this.gpsMovi = gpsMovi;
    }

    public Integer getIdMovimiento(){return idMovimiento;}

    public void setIdMovimiento(@NonNull Integer idMovimiento) {this.idMovimiento = idMovimiento;}

    public double getMontoMov(){return montoMov = montoMov;}

    public String getFechaMov(){return fechaMov = fechaMov;}

    public String getMotivoEgreso() {return motivoEgreso = motivoEgreso;}

    public String getGpsMovi() {return  gpsMovi = gpsMovi;}
}
