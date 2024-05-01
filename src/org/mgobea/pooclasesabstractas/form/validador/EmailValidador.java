package org.mgobea.pooclasesabstractas.form.validador;

public class EmailValidador extends Validador{

        protected String mensaje = "El formato del correo electrónico es inválido";
        private final static String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

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
            return (valor != null && valor.matches(EmailValidador.EMAIL_REGEX));
        }
}
