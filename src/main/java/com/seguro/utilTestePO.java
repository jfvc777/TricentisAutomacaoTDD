package com.seguro;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class utilTestePO {

    public static WebDriver browser;

    public static WebDriver getBrowser(){
        return browser;
    }

    private WebDriver driverBrowser() {
        System.setProperty("webdriver.chrome.driver", "BrowserDriver/chromedriver.exe");
        browser = new ChromeDriver();
        return browser;
    }

    public boolean elementExist(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement stringToWebElement(String param){
        return browser.findElement(By.xpath(param));
    }

    private static Properties obterProperties(String nomeArquivo) throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("./" + nomeArquivo + ".properties");
        prop.load(file);
        return prop;
    }

    public static String lerProperties(String nomeArquivo, String nomeLinha) throws IOException {
        String linha = "";
        Properties prop = obterProperties(nomeArquivo);
        linha = prop.getProperty(nomeLinha);
        return linha;
    }

    public void carregarPageFactory(){
        PageFactory.initElements(browser, this);
    }



    public void inicializarBrowser(String url) {
        WebDriver driver = driverBrowser();
        PageFactory.initElements(driver, this);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void fecharBrowser(){
        getBrowser().quit();
    }

    public String getReportConfigPath() throws IOException {
        String reportConfigPath = lerProperties("param_site","url_extent");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public String getDataAtual(){
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        return data;
    }


}
