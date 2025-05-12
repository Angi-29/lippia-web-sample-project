@Login

Feature: Login

  Background:
    Given El usuario se encuentra en la pagina de Automation Practice Site

  @LoginExitoso @Smoke
  Scenario Outline: MY ACCOUNT - LOGIN - "<titulo>"
    When Hace clic en "Mi cuenta"
    And Ingresa su correo "<email>" y contraseña "<password>"
    And Hace clic en el boton "Login" para continuar
    Then Se muestra el mensaje "<mensaje>"

    Examples:
      | titulo               | email   | password       | mensaje       |
      | Login Exitoso | emailOK@gmail.com | 123456??ssS??? | Hello emailOK |
      #| Registration with invalid Email-id | emailInvalidSinArroba | 123456??ssS??? | invalid Email-id                      |
      #| Registration with empty Email-id   |                       | 123456??ssS??? | Please provide a valid email address. |
      #| Registration with empty password and  Email-id |       |          |   Please provide a valid email address.      |


