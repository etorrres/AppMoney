package tech.edisystem.appmoney.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tech.edisystem.appmoney.movimientoslist.entity.Egresos;
import tech.edisystem.appmoney.movimientoslist.entity.Ingresos;
import tech.edisystem.appmoney.movimientoslist.entity.MovimientoDao;

@Database(entities = {Egresos.class, Ingresos.class}, version = 1, exportSchema = false)
public abstract class MovimientosDatabase extends RoomDatabase implements MovimientoDao {
    public abstract MovimientoDao movimientoDao();

    public static MovimientosDatabase movimientosDatabase;
    private static volatile MovimientosDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    //GENERADOR DE INSTANCIA USANDO PATRÓN SINGLETON
    static MovimientosDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (MovimientosDatabase.class){
                if(INSTANCE == null){
                    RoomDatabase.Callback miCallback = new RoomDatabase.Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            databaseWriteExecutor.execute(() -> {
                                MovimientoDao dao = INSTANCE.movimientoDao();
                                dao.deleteAllIngresos();

                                Ingresos nuevo = new Ingresos("100", "17/03/2023", "Ahorro");
                                dao.insert(nuevo);
                            });

                        }
                    };
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MovimientosDatabase.class, "movimientos_database").addCallback(miCallback).build();

                }
            }
        }
        return INSTANCE;
    }
}
