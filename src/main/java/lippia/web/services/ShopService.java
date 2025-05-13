package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.ShopConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class ShopService extends ActionManager {
    public static void navegarWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url.shop"));
    }

    public static void clicTituloProducto(String nomProducto) {
        String lblProducto = String.format(ShopConstants.LBL_NOMBRE_PRODUCTO, nomProducto);
        WebActionManager.waitVisibility(lblProducto).click();
    }

    public static void ordenarProducto(String ordenarProducto) {
        // Localizar el elemento <select>
        WebElement selectElemento = WebActionManager.waitVisibility(ShopConstants.SELECT_ORDER_ELEMENT);
        // Crear objeto Select
        Select select = new Select(selectElemento);
        // Seleccionar por texto visible
        select.selectByVisibleText(ordenarProducto); // Cambiá esto según lo que quieras seleccionar

    }

    public static String obtenerPrimerElementoDeListaDeProducto() {
        WebElement titulo = WebActionManager.waitVisibility(ShopConstants.LBL_PRIMER_ELEMENTO_LISTA).findElement(By.tagName("h3"));
        return titulo.getText();
    }
}
