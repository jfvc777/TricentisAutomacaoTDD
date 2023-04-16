package TesteMotocycle;

import com.seguro.*;
import org.junit.jupiter.api.*;

import java.awt.*;
import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ValidarMotocycle {

    static CadastrarSeguroPO cadastrarSeguroPO = new CadastrarSeguroPO();
    CadastroAbaEnterVehicleData cadEnterVehicle = new CadastroAbaEnterVehicleData();
    CadastroAbaEnterInsurantData cadEnterInsurant = new CadastroAbaEnterInsurantData();
    CadastroAbaEnterProduct cadEnterProduct = new CadastroAbaEnterProduct();
    CadastroAbaSelectPrice cadSelectPrice = new CadastroAbaSelectPrice();
    CadastroAbaSendQuote cadSendQuote = new CadastroAbaSendQuote();

    @BeforeAll
    public static void dado_que_estamos_indo_para_Tricentise() throws IOException {
        cadastrarSeguroPO.logarSite();
    }

    @Test
    @Order(1)
    public void quando_selecionamos_Motorcycle() {
        cadastrarSeguroPO.clicarOpcao("Motorcycle");
    }


    @Test
    @Order(2)
    public void e_estou_na_aba_EnterVehicleData() {
        cadastrarSeguroPO.compararAba("Enter Vehicle Data");
    }

    @Test
    @Order(3)
    public void e_seleciono_no_campo_Make_a_marca() {
        cadEnterVehicle.selecionarMake("Toyota");
    }

    @Test
    @Order(4)
    public void selecionoNoCampoModelOModelo() throws Throwable {
        cadEnterVehicle.selecionarModel("Three-Wheeler");
    }

    @Test
    @Order(5)
    public void preenchoNoCampoCylinderCapacityOValor() throws Throwable {
        cadEnterVehicle.preencherCylinder("1");
    }

    @Test
    @Order(6)
    public void e_preencho_no_campo_Engine_Performance() {
        cadEnterVehicle.preencherEngine("2000");
    }

    @Test
    @Order(7)
    public void e_preencho_No_Campo_Date_Of_ManufactureA_Data() throws Throwable {
        cadEnterVehicle.preencherDateManuFacture("10/09/2020");
    }

    @Test
    @Order(8)
    public void selecionoNoCampoNumberOfSeatsONumero() throws Throwable {
        cadEnterVehicle.selecionarNumberSeats2("3");
    }

    @Test
    @Order(9)
    public void preenchoNoCampoListPriceOValor() throws Throwable {
        cadEnterVehicle.preencherListPrice("500");
    }

    @Test
    @Order(10)
    public void preenchoNoCampoAnnualMileageOValor() throws Throwable {
        cadEnterVehicle.preencherAnualMill("100000");
    }

    @Test
    @Order(11)
    public void clicoNoBotaoNextDaAbaEnterVehicle() {
        cadEnterVehicle.selecionarBtnNext();
    }

    @Test
    @Order(12)
    public void souDirecionadoParaAAba() throws Throwable {
        cadastrarSeguroPO.compararAba("Enter Insurant Data");
    }

    @Test
    @Order(13)
    public void preenchoNoCampoFirstNameOValor() throws Throwable {
        cadEnterInsurant.preencherFirsName("Roberto");
    }

    @Test
    @Order(14)
    public void preenchoNoCampoLastNameOValor() throws Throwable {
        cadEnterInsurant.preencherLastName("Lans");
    }

    @Test
    @Order(15)
    public void preenchoNoCampoDateOfBirthOValor() throws Throwable {
        cadEnterInsurant.preencherDateBirth("10/10/1990");
    }

    @Test
    @Order(16)
    public void selecionoNoCampoGenderOValor() throws Throwable {
        cadEnterInsurant.clicarOpcaoGender("Male");
    }

    @Test
    @Order(17)
    public void preenchoNoCampoStreetAddressOValor() throws Throwable {
        cadEnterInsurant.preencherStreet("Avenida Donato 222");
    }

    @Test
    @Order(18)
    public void selecionoNoCampoCountryOValor() throws Throwable {
        cadEnterInsurant.selecionarCountry("Brazil");
    }

    @Test
    @Order(19)
    public void preenchoNoCampoZipCodeOValor() throws Throwable {
        cadEnterInsurant.preencherZipCode("01234");
    }

    @Test
    @Order(20)
    public void preenchoNoCampoCityOValor() throws Throwable {
        cadEnterInsurant.preencherCity("Sao Paulo");
    }

    @Test
    @Order(21)
    public void selecionoNoCampoOccupationOValor() throws Throwable {
        cadEnterInsurant.selecionarOcupation("Employee");
    }

    @Test
    @Order(22)
    public void selecionoNoCampoHobbiesOValor() throws Throwable {
        cadEnterInsurant.clicarOpcaoHobies("Speeding");
    }

    @Test
    @Order(23)
    public void preenchoNoCampoWebsiteOValor() throws Throwable {
        cadEnterInsurant.preencherWebSite("wwww.googke.com");
    }

    @Test
    @Order(24)
    public void anexoAImagenDesejadaNaOpcaoPicture() throws AWTException, InterruptedException {
        cadEnterInsurant.carregarImagen();
    }

    @Test
    @Order(25)
    public void clicoNoBotaoNextDaAbaEnterInsurant() {
        cadEnterInsurant.selecionarBtnNext();
    }

    @Test
    @Order(26)
    public void souDirecionadoParaAAbaEnterProductData() throws Throwable {
        cadastrarSeguroPO.compararAba("Enter Product Data");
    }

    @Test
    @Order(27)
    public void preenchoNoCampoStartDateOValorRequerido() throws InterruptedException {
        cadEnterVehicle.preencherDateManuAtual();
    }

    @Test
    @Order(28)
    public void selecionoNoCampoInsuranceSumOValor() throws Throwable {
        cadEnterProduct.selecionarInsurance("5.000.000,00");
    }

    @Test
    @Order(29)
    public void selecionoNoCampoDamageInsuranceOValor() throws Throwable {
        cadEnterProduct.selecionarDamage("Partial Coverage");
    }

    @Test
    @Order(30)
    public void selecionoNoCampoOptionalProductsOValorDaOpcaoAutomobile() {
        cadEnterProduct.clicarOpctionalProductTruck("Euro Protection");
    }

    @Test
    @Order(31)
    public void clicoNoBotaoNextDaAbaEnterProduct() {
        cadEnterProduct.selecionarBtnNext();
    }

    @Test
    @Order(32)
    public void souDirecionadoParaAAbaPriceOption() throws Throwable {
        cadastrarSeguroPO.compararAba("Select Price Option");
    }

    @Test
    @Order(33)
    public void selecionoOPlano() throws Throwable {
        cadSelectPrice.clicarPlano("SILVER");
    }

    @Test
    @Order(34)
    public void clicoNoBotaoNextDaAbaSelectPrice() {
        cadSelectPrice.selecionarBtnNext();
    }

    @Test
    @Order(35)
    public void souDirecionadoParaAAbaSendQuote() throws Throwable {
        cadastrarSeguroPO.compararAba("Send Quote");
    }

    @Test
    @Order(36)
    public void preenchoOEmail() throws Throwable {
        cadSendQuote.preencherEmail("johnCastle@teste.com");
    }

    @Test
    @Order(37)
    public void preenchoONumeroTelefonico() throws Throwable {
        cadSendQuote.preencherPhone("11964871234");
    }

    @Test
    @Order(38)
    public void preenchoONomeDeUsuario() throws Throwable {
        cadSendQuote.preencherUsername("jhonTeste01");
    }

    @Test
    @Order(39)
    public void preenchoASenha() throws Throwable {
        cadSendQuote.preencherPass("Testing2022");
    }

    @Test
    @Order(40)
    public void preenchoAConfirmacaoDaSenha() throws Throwable {
        cadSendQuote.preencherConfPass("Testing2022");
    }

    @Test
    @Order(41)
    public void preenchoNoCampoCommentsOComentario() throws Throwable {
        cadSendQuote.preencherComments("È um teste em JUNIT");
    }

    @Test
    @Order(42)
    public void clicoNoBotaoNextDaAbaSendQuote() throws InterruptedException {
        cadSendQuote.clicarBtnNext();
    }

    @Test
    @Order(43)
    public void validamosQueOMensagemDeConfirmacaoContemEClicarNoBotaoOK() throws Throwable {
        cadSendQuote.mensagemConfirmacao("Sending e-mail success!");
    }


    @AfterAll
    public static void finalizandoCaso() throws IOException {
        cadastrarSeguroPO.fecharBrowser();
    }


}
