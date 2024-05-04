package org.mgobea.pooclasesabstractas.form.validador;

import org.mgobea.pooclasesabstractas.form.validador.mensaje.MensajeFormateable;

public class LargoValidador extends Validador implements MensajeFormateable {

    protected String mensaje = "El campo %s debe tener mínimo %d caracteres y máximo %d caracteres"; // Plantilla de mensaje
    private int min;
    private int max = Integer.MAX_VALUE;

    public LargoValidador() {
    }

    public LargoValidador(int min, int max) {
        this();
        this.min = min;
        this.max = max;
    }

    // Setter de min y max
    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

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
        // this.mensaje = String.format(this.mensaje, this.min, this.max); // Seteo el contenido del mensaje con los valores de min y max
        if (valor == null) {
            return true; // Busca evitar el NullPointerException
        }
        int largo = valor.length();

        return (largo >= this.min && largo <= this.max);
    }

    @Override
    public String getMensajeFormateado(String campo) {
        return String.format(this.mensaje, campo, this.min, this.max);
    }
}
