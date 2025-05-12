package lippia.web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import lippia.web.services.LoginService;
import lippia.web.services.RegistroService;
import lippia.web.utils;

public class RegistroSteps {
    private String email;

    @Given("El usuario se encuentra en la pagina de Automation Practice Site")
    public void elUsuarioSeEncuentraEnLaPaginaDeAutomationPracticeSite() {
        LoginService.navegarWeb();
    }

    @When("Hace clic en el menu {string}")
    public void haceClicEnElMenu(String nombreMenu) {
        RegistroService.clickMenuCuenta();

    }

    @And("Ingresa las credenciales con correo {string} y contraseña {string}")
    public void ingresaLasCredencialesConCorreoYContraseña(String emailOpcion, String password) {
        email = utils.correoAleatorio(emailOpcion);
        RegistroService.enterCredentials(email, password);
    }

    @And("Hace clic en el boton {string}")
    public void haceClicEnElBotón(String nomBtn) {
        RegistroService.clicBtn(nomBtn);
    }

    @Then("El usuario visualiza el mensaje {string}")
    public void elUsuarioVisualizaElMensaje(String msj) {
        if(msj.equalsIgnoreCase("Hello emailOK")){
            boolean flag = RegistroService.buscarNombreCorreo(email);
            Assert.assertTrue("[WARNING] No se registro de forma correcta", flag);
        }

        if(msj.equalsIgnoreCase("Please provide a valid email address.")){
            boolean flag = RegistroService.buscarErrorMsj();
            Assert.assertTrue("[WARNING] No es el resultado esperado", flag);
        }


        if(msj.equalsIgnoreCase("invalid Email-id")){
            boolean flag = RegistroService.buscarHello();
            Assert.assertFalse("[WARNING] No es el resultado esperado", flag);
        }


    }
}
