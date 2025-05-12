package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import lippia.web.services.LoginService;
import lippia.web.services.RegistroService;

public class LoginSteps extends PageSteps {


    @Given("El usuario se encuentra en la pagina de login de Clockify")
    public void home() {
        LoginService.navegarWeb();
    }

    @When("Hace clic en {string}")
    public void haceClicEn(String nombreMenu) {
        LoginService.clickMiCuenta();

    }

    @And("Ingresa su correo {string} y contraseña {string}")
    public void ingresaSuCorreoYContraseña(String email, String password) {
        LoginService.inputCredenciales(email, password);
    }

    @And("Hace clic en el boton {string} para continuar")
    public void haceClicEnElBotonParaContinuar(String nomBtn) {
        LoginService.clickBtn(nomBtn);
    }

    @Then("Se muestra el mensaje {string}")
    public void seMuestraElMensaje(String msjEsperado) {
        String mensajeActual = LoginService.obtenerMensaje();
        Assert.assertEquals("[ERROR] El mensaje mostrado no es el esperado.",
                msjEsperado, mensajeActual);

        }

}
