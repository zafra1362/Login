package com.example.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MiLoginViewModel extends AndroidViewModel {

    Executor executor;

    SimuladorLogin simulador;

    MutableLiveData<String> cuota = new MutableLiveData<>();

    public MiLoginViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        simulador = new SimuladorLogin();
    }


    public void calcular(String usuario, String contrasena) {

        final SimuladorLogin.DatosLogin datosLogin = new SimuladorLogin.DatosLogin(usuario, contrasena);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                simulador.calcular(datosLogin, new SimuladorLogin.LlamadaVuelta() {
                    @Override
                    public void cuandoHayaErrorDeUsuarioValido() {
                        cuandoHayaErrorDeUsuarioValido();
                    }

                    @Override
                    public void cuandoHayaErrorDeContrasenaValido() {
                    cuandoHayaErrorDeContrasenaValido();
                    }

                    @Override
                    public void cuandoHayaErrorDeContrasenaCorta(int minimo) {
                        cuandoHayaErrorDeContrasenaCorta(6);
                    }

                    @Override
                    public void cuandoSeaCorrecto() {
                    cuandoSeaCorrecto();
                    }
                });
            }
        });
    }
}
