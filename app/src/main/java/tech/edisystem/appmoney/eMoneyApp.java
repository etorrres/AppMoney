package tech.edisystem.appmoney;

import android.app.Application;

public class eMoneyApp extends Application {

    private static eMoneyApp instancia;

    public static eMoneyApp getInstance(){
        if(instancia == null){
            synchronized (eMoneyApp.class){
                if(instancia == null){
                    instancia = new eMoneyApp();
                }
            }

        }
        return instancia;
    }

}
