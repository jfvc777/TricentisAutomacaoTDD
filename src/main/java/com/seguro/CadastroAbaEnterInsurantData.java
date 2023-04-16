package com.seguro;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class CadastroAbaEnterInsurantData extends CadastrarSeguroPO {

    /******************Aba Enter Insurant Data*********************/
    @FindBy(xpath = "//a[@id='enterinsurantdata']")
    private WebElement lblAbaEnterInsurance;
    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement cmpFirstName;
    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement cmpLastName;
    @FindBy(xpath = "//input[@id='birthdate']")
    private WebElement cmpBirhDate;
    @FindBy(xpath = "//input[@id='streetaddress']")
    private WebElement cmpStreetAddress;
    @FindBy(xpath = "//select[@id='country']")
    private WebElement cmbCountry;
    @FindBy(xpath = "//input[@id='zipcode']")
    private WebElement cmpZipCode;
    @FindBy(xpath = "//input[@id='city']")
    private WebElement cmpCity;
    @FindBy(xpath = "//select[@id='occupation']")
    private WebElement cmbOcupation;
    @FindBy(xpath = "//input[@id='website']")
    private WebElement cmpWebsite;
    @FindBy(xpath = "//button[@id='nextenterproductdata']")
    private WebElement btnNextEnterProduct;
    @FindBy(xpath = "//button[@id='open']")
    private WebElement btnOpenFile;

    protected String genderOpt = "//body/div[@id='site-content']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/section[2]/div[4]/p[1]/label[%s]";
    protected String hobbiesOpt = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/section[2]/div[10]/p[1]/label[%s]";

    public CadastroAbaEnterInsurantData() {
        carregarPageFactory();
    }

    public void preencherFirsName(String param) {
        elementExist(cmpFirstName);
        this.cmpFirstName.sendKeys(param);
    }

    public void preencherLastName(String param) {
        elementExist(cmpLastName);
        this.cmpLastName.sendKeys(param);
    }

    public void preencherDateBirth(String param) {
        elementExist(cmpBirhDate);
        param = formataData(param);
        this.cmpBirhDate.sendKeys(param);
    }

    private WebElement selecaoGender(String gender) {
        String formatar = gender.toLowerCase();
        switch (formatar) {
            case "male":
                gender = String.format(genderOpt, "1");
                break;
            case "female":
                gender = String.format(genderOpt, "2");
                break;
        }
        return stringToWebElement(gender);
    }

    private WebElement selecaoHobbies(String param) {
        String formatar = param.toLowerCase();
        switch (formatar) {
            case "speeding":
                param = String.format(hobbiesOpt, "1");
                break;
            case "bungee jumping":
                param = String.format(hobbiesOpt, "2");
                break;
            case "cliff diving":
                param = String.format(hobbiesOpt, "3");
                break;
            case "skydiving":
                param = String.format(hobbiesOpt, "4");
                break;
            case "other":
                param = String.format(hobbiesOpt, "5");
                break;
        }
        return stringToWebElement(param);
    }

    public void clicarOpcaoHobies(String param) {
        elementExist(selecaoHobbies(param));
        selecaoHobbies(param).click();
    }

    public void clicarOpcaoGender(String gender) {
        elementExist(selecaoGender(gender));
        selecaoGender(gender).click();
    }

    public void preencherStreet(String param) {
        elementExist(cmpStreetAddress);
        this.cmpStreetAddress.sendKeys(param);
    }

    public void selecionarCountry(String param) {
        clicarCombo(cmbCountry, param);
    }

    public void selecionarOcupation(String param){
        clicarCombo(cmbOcupation,param);
    }

    public void preencherZipCode(String param) {
        elementExist(cmpZipCode);
        this.cmpZipCode.sendKeys(param);
    }

    public void preencherCity(String param) {
        elementExist(cmpCity);
        this.cmpCity.sendKeys(param);
    }

    public void preencherWebSite(String param) {
        elementExist(cmpWebsite);
        this.cmpWebsite.sendKeys(param);
    }

    public CadastroAbaEnterProduct selecionarBtnNext() {
        elementExist(btnNextEnterProduct);
        this.btnNextEnterProduct.click();
        return new CadastroAbaEnterProduct();
    }

    public void carregarImagen() throws AWTException, InterruptedException {
        // creating object of Robot class
        Robot rb = new Robot();
        elementExist(btnOpenFile);
        this.btnOpenFile.click();

        Thread.sleep(15000);

        StringSelection str = new StringSelection("C:\\TricentisAutomacao\\image\\imageTeste.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);


    }


}
