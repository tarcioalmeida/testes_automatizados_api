package br.com.sicredi.simulacao;

import io.restassured.http.ContentType;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.*;

//Feature: Verificar se CPF  possui ou não possui restrições
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RestricaoTest extends ConfiguracoesAPI{

    //Cenário 1
    @Test
    public void testCenario1GetAPartirDeCpfComRestricaoStatusCode200(){

        String cpfParametro = "60094146012";

        //Dado que eu defino o parâmetro do header content type como "application/json"
        //E defino como parâmetro um CPF que possui restrições
        given()
                .contentType(ContentType.JSON)
                .pathParam("cpf", cpfParametro).

        //Quando envio a solicitação GET com o CPF parametrizado
        when()
                .get("/v1/restricoes/{cpf}").

        //Então eu recebo o status code 200
        then()
                .assertThat()
                .statusCode(200);

    }

    //Cenário 2
    @Test
    public void testCenario2GetAPartirDeCpfSemRestricaoStatusCode204(){

        String cpfParametro = "17822386034";

        //Dado que eu defino o parâmetro do header content type como "application/json"
        //E defino como parâmetro um CPF que não possui restrições
        given()
                .contentType(ContentType.JSON)
                .pathParam("cpf", cpfParametro).

        //Quando envio a solicitação GET com o CPF parametrizado
        when()
                .get("/v1/restricoes/{cpf}").

        //Então eu recebo o status code 204
        then()
                .assertThat()
                .statusCode(204);

    }
}
