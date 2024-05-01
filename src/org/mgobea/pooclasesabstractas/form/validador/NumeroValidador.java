package org.mgobea.pooclasesabstractas.form.validador;

public class NumeroValidador extends Validador{

    protected String mensaje = "El campo debe ser un número";

    @Override
    public String getMensaje() {
        return this.mensaje;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        try {
            Integer.parseInt(valor); // Si no se puede convertir a entero, lanzará una excepción y retornará false
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
