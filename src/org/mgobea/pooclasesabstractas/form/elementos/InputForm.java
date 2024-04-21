package org.mgobea.pooclasesabstractas.form.elementos;

public class InputForm extends ElementoForm {

    private String tipo = "text";

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public InputForm(String nombre) {
        super(nombre);
    }

    public InputForm(String nombre, String tipo) {
        this(nombre); // Podría ser super(nombre) también y llamo al constructor de la clase padre directamente.
        this.tipo = tipo;
    }

    @Override
    public String dibujarHtml() {
        return "<input type=\"" + this.tipo // el \" es para escapar las comillas
                + "\" name=\"" + this.nombre
                + "\" value=\"" + this.valor
                + "\"></input>";
    }

}
