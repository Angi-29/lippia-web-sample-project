package lippia.web;


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

}
