package com.seguro;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastroAbaSendQuote extends CadastrarSeguroPO {
    /******************Aba Send Quote*********************/
    @FindBy(xpath = "//input[@id='email']")
    private WebElement cmpEmail;
    @FindBy(xpath = "//input[@id='phone']")
    private WebElement cmpPhone;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement cmpUserName;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement cmpPassword;
    @FindBy(xpath = "//input[@id='confirmpassword']")
    private WebElement cmpConfirmPass;
    @FindBy(xpath = "//textarea[@id='Comments']")
    private WebElement txtComents;
    @FindBy(xpath = "//button[@id='sendemail']")
    private WebElement btnNext;
    @FindBy(xpath = "//h2[contains(text(),'Sending e-mail success!')]")
    private WebElement lblSucesso;
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    private WebElement btnOK;

    public CadastroAbaSendQuote() {
        carregarPageFactory();
    }


    public void preencherEmail(String param) {
        elementExist(cmpEmail);
        this.cmpEmail.sendKeys(param);
    }

    public void preencherPhone(String param) {
        elementExist(cmpPhone);
        this.cmpPhone.sendKeys(param);
    }

    public void preencherUsername(String param) {
        elementExist(cmpUserName);
        this.cmpUserName.sendKeys(param);
    }

    public void preencherPass(String param) {
        elementExist(cmpPassword);
        this.cmpPassword.sendKeys(param);
    }

    public void preencherConfPass(String param) {
        elementExist(cmpConfirmPass);
        this.cmpConfirmPass.sendKeys(param);
    }

    public void preencherComments(String param) {
        elementExist(txtComents);
        this.txtComents.sendKeys(param);
    }

    public void clicarBtnNext() throws InterruptedException {
        elementExist(btnNext);
        this.btnNext.click();
        Thread.sleep(4000);
    }

    private void validarMSGSucesso(String param) {
        elementExist(lblSucesso);
        String validao = lblSucesso.getText();
        assertEquals(param, validao);
    }

    private void clicarOK() {
        elementExist(btnOK);
        this.btnOK.click();
        fecharBrowser();
    }

    public void mensagemConfirmacao(String param) throws InterruptedException {
        validarMSGSucesso(param);
        clicarOK();
        Thread.sleep(21000);
    }


}

