package org.mgobea.pooclasesabstractas.form;

import org.mgobea.pooclasesabstractas.form.elementos.*;
import org.mgobea.pooclasesabstractas.form.elementos.select.Opcion;

public class EjemploForm {
    public static void main(String[] args) {

        // Una clase Abstracta no se puede instanciar. Salvo que la implemente "al vuelo" como una clase anónima:
        ElementoForm inputAnonimo = new ElementoForm("nombre") {
            @Override
            public String dibujarHtml() {
                return "<input type=\"text\" name=\"" + this.nombre + "\" value=\"" + this.valor + "\"></input>";
            }
        };

        // Voy construyendo entonces mi formulario:
        InputForm username = new InputForm("username"); // Por defecto es de tipo text. Se puede cambiar con setTipo
        InputForm password = new InputForm("clave", "password");
        InputForm email = new InputForm("email", "email");
        InputForm edad = new InputForm("edad", "number");

        TextareaForm experiencia = new TextareaForm("experiencia", 5, 20);

        SelectForm lenguajes = new SelectForm("lenguajes"); // La lista de opciones se puede agregar con addOpcion

        Opcion java = new Opcion("Java", "java");
        Opcion python = new Opcion("Python", "python");
        Opcion javascript = new Opcion("JavaScript", "javascript");
        Opcion kotlin = new Opcion("Kotlin", "kotlin");
        Opcion go = new Opcion("Go", "go");
        Opcion csharp = new Opcion("C#", "csharp");
        Opcion php = new Opcion("PHP", "php");
        Opcion ruby = new Opcion("Ruby", "ruby");
        Opcion swift = new Opcion("Swift", "swift");
        Opcion rust = new Opcion("Rust", "rust");
        Opcion typescript = new Opcion("TypeScript", "typescript");
        Opcion scala = new Opcion("Scala", "scala");
        Opcion R = new Opcion("R", "r");
        Opcion perl = new Opcion("Perl", "perl");

        lenguajes.addOpcion(java).
                addOpcion(python).
                addOpcion(javascript).
                addOpcion(kotlin).
                addOpcion(go).
                addOpcion(csharp).
                addOpcion(php).
                addOpcion(ruby).
                addOpcion(swift).
                addOpcion(rust).
                addOpcion(typescript).
                addOpcion(scala).
                addOpcion(R).
                addOpcion(perl); // Encadenamiento de llamadas dado que retorna la misma instancia

        username.setValor("mgobea");
        password.setValor("123456");
        email.setValor("gobeamariano@gmail.com");
        edad.setValor("36");
        java.setSelected(true);

    }
}
