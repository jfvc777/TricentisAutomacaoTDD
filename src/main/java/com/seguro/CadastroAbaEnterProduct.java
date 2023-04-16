package com.seguro;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroAbaEnterProduct extends CadastrarSeguroPO {

    /******************Aba Enter Product*********************/
    @FindBy(xpath = "//input[@id='startdate']")
    private WebElement cmpStartDate;
    @FindBy(xpath = "//select[@id='insurancesum']")
    private WebElement cmbInsuranceSum;
    @FindBy(xpath = "//select[@id='meritrating']")
    private WebElement cmbMeritRating;
    @FindBy(xpath = "//select[@id='damageinsurance']")
    private WebElement cmbDamageInsurance;
    @FindBy(xpath = "//select[@id='courtesycar']")
    private WebElement cmbCourtesyCar;
    @FindBy(xpath = "//button[@id='nextselectpriceoption']")
    private WebElement btnNextProduct;

    protected String optionalProduct = "//body/div[@id='site-content']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/section[3]/div[5]/p[1]/label[%s]";
    protected String optionalProductTruck = "//body/div[@id='site-content']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/section[3]/div[4]/p[1]/label[%s]/span";

    public CadastroAbaEnterProduct() {
        carregarPageFactory();
    }

    public void preencherStartDate(String param) {
        elementExist(cmpStartDate);
        param = formataData(param);
        this.cmpStartDate.sendKeys(param);
    }

    public void selecionarInsurance(String param) {
        clicarCombo(cmbInsuranceSum, param);
    }

    public void selecionarMerit(String param) {
        clicarCombo(cmbMeritRating, param);
    }

    public void selecionarDamage(String param) {
        clicarCombo(cmbDamageInsurance, param);
    }

    public void selecionarCourtesy(String param) {
        clicarCombo(cmbCourtesyCar, param);
    }


    private WebElement selecaoOptionalProducts(String param) {
        String formatar = param.toLowerCase();
        switch (formatar) {
            case "euro protection":
                param = String.format(optionalProduct, "1");
                break;
            case "legal defense insurance":
                param = String.format(optionalProduct, "2");
                break;
        }
        return stringToWebElement(param);
    }

    private WebElement selecaoOptionalProductsTruck(String param) {
        String formatar = param.toLowerCase();
        switch (formatar) {
            case "euro protection":
                param = String.format(optionalProductTruck, "1");
                break;
            case "legal defense insurance":
                param = String.format(optionalProductTruck, "2");
                break;
        }
        return stringToWebElement(param);
    }

    public void clicarOpctionalProduct(String param) {
        elementExist(selecaoOptionalProducts(param));
        selecaoOptionalProducts(param).click();
    }

    public CadastroAbaSelectPrice selecionarBtnNext() {
        elementExist(btnNextProduct);
        this.btnNextProduct.click();
        return new CadastroAbaSelectPrice();
    }

    public void clicarOpctionalProductTruck(String param) {
        elementExist(selecaoOptionalProductsTruck(param));
        selecaoOptionalProductsTruck(param).click();
    }

}
