package org.mgobea.pooclasesabstractas.form.elementos.select;

public class Opcion {
    private String valor;
    private String nombre;
    private boolean selected;

    public Opcion() {
        this.selected = false;
    }

    public Opcion(String valor, String nombre) {
        this();
        this.valor = valor;
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
