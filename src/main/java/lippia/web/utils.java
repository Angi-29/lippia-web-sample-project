package lippia.web;


import java.text.DecimalFormat;

public class utils {

    public static String correoAleatorio(String email) {
        int numero = (int) (Math.random() * 1000);

        switch (email) {
            case "emailOK":
                return email + "_" + numero + "@gmail.com";
            case "emailInvalidSinArroba":
                return email + "_" + numero + "gmail.com";
            default:
                return " ";
        }

    }


    public static String formatiarNumero(Double valor) {
        // Formato con separador de miles y dos decimales
        DecimalFormat formato = new DecimalFormat("#,##0.00");
        return formato.format(valor);
    }
}
