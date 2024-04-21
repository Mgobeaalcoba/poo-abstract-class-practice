package org.mgobea.pooclasesabstractas.form.elementos;

abstract public class ElementoForm {

    protected String valor; // Es protected para que las clases hijas puedan acceder a él
    protected String nombre;

    public ElementoForm() {

    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    // Una clase con un método abstracto necesariamente debe ser abstracta
    abstract public String dibujarHtml();
}
