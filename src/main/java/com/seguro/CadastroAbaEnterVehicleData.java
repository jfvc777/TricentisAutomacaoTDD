package com.seguro;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroAbaEnterVehicleData extends CadastrarSeguroPO {
    /******************OPCAO GERAL*********************/
    @FindBy(name = "Enter Vehicle Data")
    private WebElement lblAbaEnterVehicle;
    @FindBy(xpath = "//select[@id='make']")
    private WebElement cmbMake;
    @FindBy(xpath = "//input[@id='engineperformance']")
    private WebElement cmpEngineer;
    @FindBy(xpath = "//input[@id='dateofmanufacture']")
    private WebElement cmpDatemanu;
    @FindBy(xpath = "//select[@id='numberofseats']")
    private WebElement cmbNumberSeats1;
    @FindBy(xpath = "//select[@id='fuel']")
    private WebElement cmbFuel;
    @FindBy(xpath = "//input[@id='listprice']")
    private WebElement cmpListPrice;
    @FindBy(xpath = "//input[@id='licenseplatenumber']")
    private WebElement cmpLicensePlateNumber;
    @FindBy(xpath = "//input[@id='annualmileage']")
    private WebElement cmpAnualMil;
    /******************OPCAO TRUCK*********************/
    @FindBy(xpath = "//input[@id='payload']")
    private WebElement cmpPayload;
    @FindBy(xpath = "//input[@id='totalweight']")
    private WebElement cmpTotalWeight;
    /******************OPCAO MOTORCYCLE*********************/
    @FindBy(xpath = "//select[@id='model']")
    private WebElement cmbModel;
    @FindBy(xpath = "//input[@id='cylindercapacity']")
    private WebElement cmpCylinder;
    @FindBy(xpath = "//select[@id='numberofseatsmotorcycle']")
    private WebElement cmbNumberSeats2;





    @FindBy(xpath = "//button[@id='nextenterinsurantdata']")
    private WebElement btnNextEnterVehicule;
    @FindBy(xpath = "//input[@id='startdate']")
    private WebElement cmpStartDate;


    protected String sltOpcao = "//body/div[@id='site-content']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/section[1]/div[7]/p[1]/label[%s]";
    protected String sltOpcaoCamper = "//body/div[@id='site-content']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/section[1]/div[5]/p[1]/label[%s]/span";
    private WebElement selecaoOpcaoRight(String opcao) {
        String formatar = opcao.toLowerCase();
        switch (formatar) {
            case "yes":
                sltOpcao = String.format(sltOpcao, "1");
                break;
            case "no":
                sltOpcao = String.format(sltOpcao, "2");
                break;
        }
        return stringToWebElement(sltOpcao);
    }

    private WebElement selecaoOpcaoRightCamper(String opcao) {
        String formatar = opcao.toLowerCase();
        switch (formatar) {
            case "yes":
                sltOpcaoCamper = String.format(sltOpcaoCamper, "1");
                break;
            case "no":
                sltOpcaoCamper = String.format(sltOpcaoCamper, "2");
                break;
        }
        return stringToWebElement(sltOpcaoCamper);
    }

    public CadastroAbaEnterVehicleData(){
        carregarPageFactory();
    }

    public void clicarOpcaoRight(String opcao) {
        elementExist(selecaoOpcaoRight(opcao));
        selecaoOpcaoRight(opcao).click();
    }

    public void clicarOpcaoRightCamper(String opcao) {
        elementExist(selecaoOpcaoRightCamper(opcao));
        selecaoOpcaoRightCamper(opcao).click();
    }

    public void selecionarMake(String param) {
        clicarCombo(cmbMake, param);
    }

    public void selecionarModel(String param) {
        clicarCombo(cmbModel, param);
    }

    public void preencherEngine(String param) {
        elementExist(cmpEngineer);
        this.cmpEngineer.sendKeys(param);
    }

    public void preencherCylinder(String param) {
        elementExist(cmpCylinder);
        this.cmpCylinder.sendKeys(param);
    }

    public void preencherDateManuFacture(String param) {
        elementExist(cmpDatemanu);
        param = formataData(param);
        this.cmpDatemanu.sendKeys(param);
    }

    public void preencherDateManuAtual() throws InterruptedException {
        elementExist(cmpStartDate);
        String param = adicionarMesDataAtual(getDataAtual());
        //browser.wait(8000);
        this.cmpStartDate.sendKeys(param);
    }

    public void selecionarNumberSeats1(String param) {
        clicarCombo(cmbNumberSeats1, param);
    }

    public void selecionarNumberSeats2(String param) {
        clicarCombo(cmbNumberSeats2, param);
    }

    public void selecionarFuelType(String param) {
        clicarCombo(cmbFuel, param);
    }

    public void preencherPayload(String param) {
        elementExist(cmpPayload);
        this.cmpPayload.sendKeys(param);
    }

    public void preencherTotalWeight(String param) {
        elementExist(cmpTotalWeight);
        this.cmpTotalWeight.sendKeys(param);
    }

    public void preencherListPrice(String param) {
        elementExist(cmpListPrice);
        this.cmpListPrice.sendKeys(param);
    }

    public void preencherLicensePlate(String param) {
        elementExist(cmpLicensePlateNumber);
        this.cmpLicensePlateNumber.sendKeys(param);
    }

    public void preencherAnualMill(String param) {
        elementExist(cmpAnualMil);
        this.cmpAnualMil.sendKeys(param);
    }

    public CadastroAbaEnterInsurantData selecionarBtnNext() {
        elementExist(btnNextEnterVehicule);
        this.btnNextEnterVehicule.click();
        return new CadastroAbaEnterInsurantData();
    }

}