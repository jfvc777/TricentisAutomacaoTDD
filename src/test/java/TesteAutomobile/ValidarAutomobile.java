package TesteAutomobile;

import com.seguro.*;
import org.junit.jupiter.api.*;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ValidarAutomobile {

    static CadastrarSeguroPO cadastrarSeguroPO = new CadastroAbaEnterVehicleData();
    CadastroAbaEnterVehicleData cadEnterVehicle = new CadastroAbaEnterVehicleData();
    CadastroAbaEnterInsurantData cadEnterInsurant;
    CadastroAbaEnterProduct cadEnterProduct;
    CadastroAbaSelectPrice cadSelectPrice;
    CadastroAbaSendQuote cadSendQuote;

    @BeforeAll
    public static void dado_que_estamos_indo_para_Tricentise() throws IOException {
        cadastrarSeguroPO.logarSite();
    }

    @Test
    @Order(1)
    public void quando_selecionamos_Automobile() {
        cadastrarSeguroPO.clicarOpcao("Automobile");
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
    public void e_preencho_no_campo_Engine_Performance() {
        cadEnterVehicle.preencherEngine("2000");
    }

    @Test
    @Order(5)
    public void e_preencho_No_Campo_Date_Of_ManufactureA_Data() throws Throwable {
        cadEnterVehicle.preencherDateManuFacture("10/10/2020");
    }

    @AfterAll
    public static void finalizandoCaso() throws IOException {
        cadastrarSeguroPO.fecharBrowser();
    }


}
