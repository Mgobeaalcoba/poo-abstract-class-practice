package org.mgobea.pooclasesabstractas.form.elementos;

import org.mgobea.pooclasesabstractas.form.validador.Validador;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm {

    protected String valor; // Es protected para que las clases hijas puedan acceder a él
    protected String nombre;

    private List<Validador> validadores;
    private List<String> errores;

    public ElementoForm() {
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    public ElementoForm addValidador(Validador validador) {
        this.validadores.add(validador);
        return this;
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<String> getErrores() {
        return this.errores;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean esValido() {
        for(Validador v: this.validadores) {
            if(!v.esValido(this.valor)) {
                this.errores.add(v.getMensaje());
            }
        }
        return this.errores.isEmpty();
    }

    // Una clase con un método abstracto necesariamente debe ser abstracta
    abstract public String dibujarHtml();
}
