package org.mgobea.pooclasesabstractas.form;

import org.mgobea.pooclasesabstractas.form.elementos.*;
import org.mgobea.pooclasesabstractas.form.elementos.select.Opcion;
import org.mgobea.pooclasesabstractas.form.validador.*;

import java.util.ArrayList;
import java.util.List;

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
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextareaForm experiencia = new TextareaForm("experiencia", 5, 20);

        // Ejemplo de instanciación desde una clase abstracta --> Clase anónima
        ElementoForm saludo = new ElementoForm() {
            @Override
            public String dibujarHtml() {
                return "<input disabled name='"+ this.nombre+ "' value=\""+ this.valor+ "\">";
            }
        };

        saludo.setValor("Hola, ¿Que tal? Este campo está deshabilitado");

        SelectForm lenguajes = new SelectForm("lenguajes"); // La lista de opciones se puede agregar con addOpcion
        lenguajes.addValidador(new NoNulo());

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

        //python.setSelected(true);

        username.setValor("mgobea");
        password.setValor("123456");
        email.setValor("gobeamariano@gmail.com");
        edad.setValor("36");
        java.setSelected(true);
        experiencia.setValor("Tengo experiencia en Java, Python y JavaScript");

        /*
        List<ElementoForm> elementos = new ArrayList<> (); // Inicializo la lista de elementos con un ArrayList vacío que es una implementación de List
        elementos.add(username);
        elementos.add(password);
        elementos.add(email);
        elementos.add(edad);
        elementos.add(lenguajes);
        elementos.add(experiencia);
        */

        // Otra forma de armar el array list es:
        List<ElementoForm> elementos = List.of(saludo, username, password, email, edad, lenguajes, experiencia);

        // Forma tradicional de recorrer la Lista
        for(ElementoForm e: elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }

        System.out.println("------------------------");

        // Forma nueva de recorrer una lista usando la Api Collections
        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }); // Usamos una lambda function al interior del forEach

        // Validamos si son válidos todos los elementos del form y en caso contrario imprimimos los errores
        elementos.forEach(e -> {
            if(!e.esValido()) {
                e.getErrores().forEach(err -> {
                    System.out.println(e.getNombre()+": "+err);
                });
            }
        });
    }
}
