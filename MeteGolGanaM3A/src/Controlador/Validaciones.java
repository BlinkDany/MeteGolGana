package Controlador;

import javax.swing.JOptionPane;

public class Validaciones {

    //para llamar a las validaciones crean un objeto y solo llaman al metodo y ya
    public void ValidarTelefonos(java.awt.event.KeyEvent evento, String telf) {

        int codigo1 = evento.getKeyChar();
        boolean numeros1 = codigo1 >= 48 && codigo1 <= 57;
        boolean retroceso = codigo1 == 8;

        if (!(numeros1 || retroceso)) {
            evento.consume();
            JOptionPane.showMessageDialog(null, "Sólo se permiten números");
        }

        if (telf.trim().length()== 15) {
            evento.consume();
            JOptionPane.showMessageDialog(null, "El numero de telefono no debe exceder de los 15 caracteres");
        }
    }

    public void ValidarCedulas(java.awt.event.KeyEvent evento, String ced) {

        int codigo1 = evento.getKeyChar();
        boolean numeros1 = codigo1 >= 48 && codigo1 <= 57;
        boolean retroceso = codigo1 == 8;

        if (!(numeros1 || retroceso)) {
            evento.consume();
            JOptionPane.showMessageDialog(null, "Sólo se permiten números para la cedula");
        }

        if (ced.length() == 10) {
            evento.consume();
            JOptionPane.showMessageDialog(null, "La cedula no debe exceder de los 10 caracteres");
        }
    }

    public void ValidarNombres(java.awt.event.KeyEvent evento, String nombres) { //tambien sirve para cadenas de texto mas largas 

        char nombre = evento.getKeyChar();
        boolean mayusculas = nombre >= 65 && nombre <= 90;
        boolean minusculas = nombre >= 97 && nombre <= 122;
        boolean espacio = nombre == 32;
        boolean reto = nombre == 8;
        boolean especial = nombre == 164;
        boolean especial1 = nombre == 165;

        if (!(mayusculas || minusculas || espacio || reto || especial || especial1)) {
            evento.consume();
            JOptionPane.showMessageDialog(null, "Sólo se permiten letras para este campo");
        }
    }

    public boolean correos(String email) {

        return email.matches("^([A-Za-z0-9_-]+)@([A-Za-z]+)*(\\.[a-z]{2,})$");
    }
    
    

    public boolean matricula(String matricul) {

        return matricul.matches("^([A-Z]{3})*(\\-[0-9]{4})$");
    }

    public boolean dimenciones(String dimen) {

        return dimen.matches("^([0-9]{1,3})x([0-9]{1,3})$");
    }

    public boolean fecha(String fech) {

        return fech.matches("^([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})$");
    }

   /* public boolean hora(String hor) {

        return hor.matches("^([01]\\d|2[0-3]):([0-5]\\d)$");
    }*/

    public void Decimales(java.awt.event.KeyEvent evento, String cod) {

        int codigo1 = evento.getKeyChar();
        boolean numeros1 = codigo1 >= 48 && codigo1 <= 57;
        boolean punto = codigo1 == 46;
        boolean coma = codigo1 == 44;
        boolean retroceso = codigo1 == 8;

        if (!(numeros1 || retroceso || punto || coma)) {
            evento.consume();
            JOptionPane.showMessageDialog(null, "Sólo se permiten números o numeros con decimales");
        }

        if (cod.trim().length() == 6) {
            evento.consume();
            JOptionPane.showMessageDialog(null, "El codigo numerico no debe exceder de los 7 caracteres");
        }
    }

    public void validaNomMaterial(java.awt.event.KeyEvent evento) {

        int dato = evento.getKeyChar();
        boolean numeros = dato >= 48 && dato <= 57;
        boolean backspace = dato == 8;
        boolean espacio = dato == 32;
        boolean mayusculas = dato >= 65 && dato <= 90;
        boolean minusculas = dato >= 97 && dato <= 122;
        boolean punto = dato == 46;
        boolean guion = dato == 45;
        boolean tildesMinusculas = dato >= 160 && dato <= 163;
        boolean tildeE = dato == 130;
        boolean ñ = dato == 164;
        boolean Ñ = dato == 165;
        boolean ETILDE = dato == 144;
        boolean ATILDE = dato == 181;
        boolean ITILDE = dato == 214;
        boolean OTILDE = dato == 224;
        boolean UTILDE = dato == 233;

        if (!(mayusculas || backspace || ETILDE || ATILDE || ITILDE || OTILDE || UTILDE || Ñ || espacio || minusculas || tildeE || tildesMinusculas || numeros)) {

            evento.consume();
            JOptionPane.showMessageDialog(null, "Digito Incorrecto");
            System.out.println("Dato es:" + dato);

        }
    }

    public void Enteros(java.awt.event.KeyEvent evento, String cod) {

        int codigo1 = evento.getKeyChar();
        boolean numeros1 = codigo1 >= 48 && codigo1 <= 57;
        boolean retroceso = codigo1 == 8;

        if (!(numeros1 || retroceso)) {
            evento.consume();
            JOptionPane.showMessageDialog(null, "Sólo se permiten números");
        }

        if (cod.trim().length() == 2) {
            evento.consume();
            JOptionPane.showMessageDialog(null, "El codigo numerico no debe exceder de los 3 caracteres");
        }
    }

    public boolean validarCedula(String cedula) {
        boolean validar = false;
        /*Divide la cadena en los 10 numeros
        Integer.parseInt sirve para transformar una cadena a entero. 
        subString es un metodo de string(Desde, hasta)*/
        if (cedula.matches("\\d{10}")) {
            int d1 = Integer.parseInt(cedula.substring(0, 1));
            int d2 = Integer.parseInt(cedula.substring(1, 2));
            int d3 = Integer.parseInt(cedula.substring(2, 3));
            int d4 = Integer.parseInt(cedula.substring(3, 4));
            int d5 = Integer.parseInt(cedula.substring(4, 5));
            int d6 = Integer.parseInt(cedula.substring(5, 6));
            int d7 = Integer.parseInt(cedula.substring(6, 7));
            int d8 = Integer.parseInt(cedula.substring(7, 8));
            int d9 = Integer.parseInt(cedula.substring(8, 9));
            int d10 = Integer.parseInt(cedula.substring(9));

            //Multiplica todas la posciones impares * 2 y las posiciones pares se multiplica 1
            d1 = d1 * 2;
            if (d1 > 9) {
                d1 = d1 - 9;
            }

            d3 = d3 * 2;
            if (d3 > 9) {
                d3 = d3 - 9;
            }

            d5 = d5 * 2;
            if (d5 > 9) {
                d5 = d5 - 9;
            }

            d7 = d7 * 2;
            if (d7 > 9) {
                d7 = d7 - 9;
            }

            d9 = d9 * 2;
            if (d9 > 9) {
                d9 = d9 - 9;
            }

            // SUMA TODOS LOS  NUMEROS PARES E IMPARES
            int sumpar = d2 + d4 + d6 + d8;
            int sumimp = d1 + d3 + d5 + d7 + d9;
            int total = sumpar + sumimp;

            //DIVIDO MI DECENA SUPERIRO PARA 10 Y SI EL RESULTADO ES DIFERENTE DE 0 SUMA 1
            double decenasuperior = total;
            while (decenasuperior % 10 != 0) {
                decenasuperior = decenasuperior + 1;
            }

            if ((decenasuperior - total) == d10) {
                validar = true;
            }
        }

        return validar;
    }


}
