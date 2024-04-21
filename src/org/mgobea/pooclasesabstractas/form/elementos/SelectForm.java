package org.mgobea.pooclasesabstractas.form.elementos;

import org.mgobea.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.List;

public class SelectForm extends ElementoForm{

    private List<Opcion> opciones; // List es una interfaz, ArrayList es una clase que implementa esa interfaz

    public SelectForm(String nombre) {
        super(nombre);
        this.opciones = new ArrayList<Opcion>(); // Inicializo la lista de opciones con un ArrayList vacío que es una implementación de List
    }

    public SelectForm(String nombre, List<Opcion> opciones) {
        super(nombre); // Llamo al padre directamente. Podría ser this(nombre) también y llamo al constructor de la misma clase. Que luego llama al padre.
        this.opciones = opciones;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public SelectForm addOpcion(Opcion opcion) {
        this.opciones.add(opcion);// Agrego una opción a la lista de opciones. El tamaño de la lista se incrementa solo. A diferencia de un array que hay que redimensionar.
        return this; // Devuelvo la misma instancia para poder encadenar llamadas
        // Un ejemplo de retornar la misma instancia es el método append de la clase StringBuilder donde puedo encadenar uno con otro..
    }

    @Override
    public String dibujarHtml() {
        StringBuilder sb = new StringBuilder("<select name='");
        sb.append(this.nombre)
                .append("'>");
        for (Opcion opcion : this.opciones) {
            sb.append("<option value='")
                    .append(opcion.getValor())
                    .append("'");
            if (opcion.isSelected()) {
                sb.append(" selected");
                this.valor = opcion.getValor();
            }
            sb.append(">").append(opcion.getNombre())
                    .append("</option>");
        }
        sb.append("</select>");
        return sb.toString();
    }
}
