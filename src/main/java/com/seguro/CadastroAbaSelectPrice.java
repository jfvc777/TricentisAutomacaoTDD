package com.seguro;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastroAbaSelectPrice extends CadastrarSeguroPO {

    /******************Aba Select Price*********************/
    @FindBy(xpath = "//button[@id='nextsendquote']")
    private WebElement btnNextElement;

    @FindBy(xpath = "//p[contains(text(),'Please, complete the first three steps to see the ')]")
    private WebElement lblMensagemErro;

    protected String optPlano = "//body/div[@id='site-content']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/section[4]/section[1]/div[1]/table[1]/tfoot[1]/tr[1]/th[2]/label[%s]/span[1]";

    public CadastroAbaSelectPrice() {
        carregarPageFactory();
    }

    private WebElement selecaoPlano(String param) {
        String formatar = param.toLowerCase();
        switch (formatar) {
            case "silver":
                param = String.format(optPlano, "1");
                break;
            case "gold":
                param = String.format(optPlano, "2");
                break;
            case "platinum":
                param = String.format(optPlano, "3");
                break;
            case "ultimate":
                param = String.format(optPlano, "4");
                break;
        }
        return stringToWebElement(param);
    }

    public void clicarPlano(String param) {
        elementExist(selecaoPlano(param));
        selecaoPlano(param).click();
    }

    public CadastroAbaSendQuote selecionarBtnNext() {
        elementExist(btnNextElement);
        this.btnNextElement.click();
        return new CadastroAbaSendQuote();
    }

    private void validarMSGErro(String param) {
        elementExist(lblMensagemErro);
        String validao = lblMensagemErro.getText();
        assertEquals(param, validao);
    }

    public void mensagemConfirmacao(String param) throws InterruptedException {
        validarMSGErro(param);
        Thread.sleep(5000);
    }


}

