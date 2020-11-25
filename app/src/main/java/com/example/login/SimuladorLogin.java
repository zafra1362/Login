package com.example.login;

public class SimuladorLogin {

    public static class DatosLogin {
        public String usuario;
        public String contrasena;

        public DatosLogin(String usuario, String contrasena) {
            this.usuario = usuario;
            this.contrasena = contrasena;
        }
    }

    interface LlamadaVuelta {
        void cuandoHayaErrorDeUsuarioValido();

        void cuandoHayaErrorDeContrasenaValido();

        void cuandoHayaErrorDeContrasenaCorta(int minimo);

        void cuandoSeaCorrecto();
    }


    public void calcular(DatosLogin datosLogin, LlamadaVuelta llamadaVuelta) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }

        if (!datosLogin.usuario.equals("usuari")) {
            llamadaVuelta.cuandoHayaErrorDeUsuarioValido();
        }

        if (!datosLogin.contrasena.equals("usuari")) {
            if (datosLogin.contrasena.length() < 6) {
                llamadaVuelta.cuandoHayaErrorDeContrasenaCorta(6);
            } else {
                llamadaVuelta.cuandoHayaErrorDeContrasenaValido();
            }

            if (datosLogin.usuario.equals("usuari") && datosLogin.contrasena.equals("usuari")) {
                llamadaVuelta.cuandoSeaCorrecto();
            }
        }
    }
}
