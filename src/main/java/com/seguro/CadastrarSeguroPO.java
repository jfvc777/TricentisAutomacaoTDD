package com.seguro;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastrarSeguroPO extends utilTestePO{

    /******************Paginas*********************/
    @FindBy(css = "#nav_camper")
    private WebElement optCamper;
    @FindBy(css = "#nav_automobile")
    private WebElement optAutomobile;
    @FindBy(css = "#nav_motorcycle")
    private WebElement optMotorcycle;
    @FindBy(css = "#nav_truck")
    private WebElement optTruck;
    @FindBy(id = "#selectedinsurance")
    private WebElement lblInsurance;

    /******************Aba Enter Vehicle Data*********************/
    @FindBy(xpath = "//a[@id='entervehicledata']")
    private WebElement lblAbaEnterVehicle;
    @FindBy(xpath = "//button[@id='nextenterinsurantdata']")
    private WebElement btnNextEnterVehicule;
    /******************Aba Enter Insurant Data*********************/
    @FindBy(xpath = "//a[@id='enterinsurantdata']")
    private WebElement lblAbaEnterInsurance;
    @FindBy(xpath = "//button[@id='nextenterproductdata']")
    private WebElement btnNextEnterProduct;
    /******************Aba Enter Product Data*********************/
    @FindBy(xpath = "//a[@id='enterproductdata']")
    private WebElement lblAbaProduct;
    /******************Aba Select Price Option*********************/
    @FindBy(xpath = "//a[@id='selectpriceoption']")
    private WebElement lblAbaSelectPrice;
    /******************Aba Select Send Quote*********************/
    @FindBy(xpath = "//a[@id='sendquote']")
    private WebElement lblAbaSendQuote;

    public void logarSite() throws IOException {
        String urlSite = lerProperties("src/main/resources/param_site", "url_site");
        inicializarBrowser(urlSite);
    }

    private String escolherAbaValidacao(String aba) {
        String abaSelecionada = "";
        String[] parsearAba = new String[0];

        switch (aba) {
            case "Enter Vehicle Data":
                abaSelecionada = this.lblAbaEnterVehicle.getText();
                break;
            case "Enter Insurant Data":
                abaSelecionada = this.lblAbaEnterInsurance.getText();
                break;
            case "Enter Product Data":
                abaSelecionada = this.lblAbaProduct.getText();
                break;
            case "Select Price Option":
                abaSelecionada = this.lblAbaSelectPrice.getText();
                break;
            case "Send Quote":
                abaSelecionada = this.lblAbaSendQuote.getText();
                break;
        }

        parsearAba = abaSelecionada.split("\n");
        abaSelecionada = parsearAba[0];

        return abaSelecionada;
    }

    public void compararAba(String aba) {
        String comparacaoAba = escolherAbaValidacao(aba);
        assertEquals(aba, comparacaoAba);

    }

    public String formataData(String param) {
        String formato = param;
        String[] formatoParse = new String[0];
        formatoParse = param.split("/");

        if (Integer.parseInt(formatoParse[0]) > 12) {
            formato = formatoParse[1] + "/" + formatoParse[0] + "/" + formatoParse[2];
        }

        return formato;
    }

    public String adicionarMesDataAtual(String param) {
        String formato = param;
        String[] formatoParse = new String[0];
        formatoParse = param.split("/");
        int mes = Integer.parseInt(formatoParse[1]) + 2;
        int dia = Integer.parseInt(formatoParse[0]);

        if (Integer.parseInt(formatoParse[0]) > 12) {
            if (mes > 12) {
                mes = 01;
            }

            if (dia > 27) {
                dia = 27;
            }
            formato = mes + "/" + dia + "/" + formatoParse[2];
        }
        return formato;
    }

    public void clicarCombo(WebElement param, String element) {
        elementExist(param);
        Select sltOb = new Select(param);
        sltOb.selectByVisibleText(element);
    }

    public void clicarOpcao(String opcao) {
        opcao = opcao.toLowerCase();
        switch (opcao) {
            case "automobile":
                elementExist(optAutomobile);
                optAutomobile.click();
                break;
            case "truck":
                elementExist(optTruck);
                optTruck.click();
                break;
            case "motorcycle":
                elementExist(optMotorcycle);
                optMotorcycle.click();
                break;
            case "camper":
                elementExist(optCamper);
                optCamper.click();
                break;
        }
    }


}
