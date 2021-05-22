package br.com.sicredi.simulacao;

import br.com.sicredi.dto.SimulacaoDTO;

import io.restassured.http.ContentType;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

import static io.restassured.RestAssured.*;

//Feature: Testar métodos CRUD de Simulações

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimulacaoTest extends ConfiguracoesAPI {

    //Cenário 1
    @Test
    public void testCenario1GetParaRetornarTodasSimulacoesEStatusCode200(){

        //Dado que eu defino o parâmetro do header content type como "application/json"
        given()
                .contentType(ContentType.JSON).

        //Quando envio a solicitação GET
        when()
                .get("/v1/simulacoes").

        //Então eu recebo o status code 200
        then()
                .assertThat()
                .statusCode(200);

    }

    //Cenário 2
    @Test
    public void testCenario2PostComPreenchimentoDeTodasInformacoesEStatusCode201(){

        String nome = "Tarcio Almeida";
        String cpf = "21548643092";
        String email = "email01@email.com";
        BigDecimal valor = BigDecimal.valueOf(2000);
        int parcelas = 3;
        boolean seguro = true;
        SimulacaoDTO simulacaoDTO = new SimulacaoDTO(nome, cpf, email, valor, parcelas, seguro);


        //Dado que eu defino o parâmetro do header content type como "application/json"
        // E defino o body com nome, cpf, email, valor, parcelas e seguro
        given()
                .contentType(ContentType.JSON)
                .body(simulacaoDTO.converterParaJson()).

        //Quando envio a solicitação POST
        when()
                .post("/v1/simulacoes").

        //Então eu recebo o status code 201
        then()
                .assertThat()
                .statusCode(201);

    }

    //Cenário 3
    @Test
    public void testCenario3PostComPreenchimentoIncompletoEStatusCode400(){

        String nome = "Tarcio Almeida 02";
        String cpf = "19080661058";
        String email = null;
        BigDecimal valor = BigDecimal.valueOf(2000);
        int parcelas = 3;
        boolean seguro = true;
        SimulacaoDTO simulacaoDTO = new SimulacaoDTO(nome, cpf, email, valor, parcelas, seguro);

        //Dado que eu defino o parâmetro do header content type como "application/json"
        // E defino o body com todas as informações preenchidas
        given()
                .contentType(ContentType.JSON)
                .body(simulacaoDTO.converterParaJson()).

        //Quando envio a solicitação POST
        when()
                .post("/v1/simulacoes").

        //Então eu recebo o status code 400
        then()
                .assertThat()
                .statusCode(400);

    }

    //Cenário 4
    @Test
    public void testCenario4PostComCPFJaExistenteEStatusCode409(){

        String nome = "Tarcio Almeida 03";
        String cpf = "17822386034";
        String email = "email3@email.com";
        BigDecimal valor = BigDecimal.valueOf(30000);
        int parcelas = 12;
        boolean seguro = false;
        SimulacaoDTO simulacaoDTO = new SimulacaoDTO(nome, cpf, email, valor, parcelas, seguro);

        //Dado que eu defino o parâmetro do header content type como "application/json"
        // E defino o body com todas as informações preenchidas
        // E com um CPF já existente nas simulações
        given()
                .contentType(ContentType.JSON)
                .body(simulacaoDTO.converterParaJson()).

        //Quando envio a solicitação POST
        when()
                .post("/v1/simulacoes").

        //Então eu recebo o status code 409
        then()
                .assertThat()
                .statusCode(409);

    }

    //Cenário 5
    @Test
    public void testCenario5GetAPartirDeCpfAssociadoASimulacaoExistenteStatusCode200(){

        String cpfParametro = "17822386034";

        //Dado que eu defino o parâmetro do header content type como "application/json"
        // E defino como parâmetro um CPF associado à uma simulação existente
        given()
                .contentType(ContentType.JSON)
                .pathParam("cpf", cpfParametro).

        //Quando envio a solicitação GET com o CPF parametrizado
        when()
                .get("/v1/simulacoes/{cpf}").

        //Então eu recebo o status code 200
        then()
                .assertThat()
                .statusCode(200);

    }

    //Cenário 6
    @Test
    public void testCenario6GetAPartirDeCpfNaoAssociadoASimulacaoExistenteStatusCode404(){

        String cpfParametro = "12345678900";

        //Dado que eu defino o parâmetro do header content type como "application/json"
        //E defino como parâmetro um CPF associado à uma simulação não existente
        given()
                .contentType(ContentType.JSON)
                .pathParam("cpf", cpfParametro).

        //Quando envio a solicitação GET com o CPF parametrizado
        when()
                .get("/v1/simulacoes/{cpf}").

        //Então eu recebo o status code 404
        then()
                .assertThat()
                .statusCode(404);

    }

    //Cenário 7
    @Test
    public void testCenario7PutAPartirDeCpfAssociadoASimulacaoExistenteStatusCode200(){

        String nome = "Tarcio Almeida 04";
        String cpf = null;
        String cpfParametro = "66414919004";
        String email = "email04@email.com";
        BigDecimal valor = BigDecimal.valueOf(2000);
        int parcelas = 40;
        boolean seguro = true;
        SimulacaoDTO simulacaoDTO = new SimulacaoDTO(nome, cpf, email, valor, parcelas, seguro);

        //Dado que eu defino o parâmetro do header content type como "application/json"
        //E defino como parâmetro um CPF que é associado à uma simulação existente
        //E defino um body com as informações a serem alteradas
        given()
                .contentType(ContentType.JSON)
                .pathParam("cpf", cpfParametro)
                .body(simulacaoDTO.converterParaJson()).

        //Quando envio a solicitação PUT com o CPF parametrizado
        when()
                .put("/v1/simulacoes/{cpf}").

        //Então eu recebo o status code 200
        then()
                .assertThat()
                .statusCode(200);

    }

    //Cenário 8
    @Test
    public void testCenario8PutAPartirDeCpfNaoAssociadoASimulacaoExistenteStatusCode404(){

        String nome = "Tarcio Almeida 05";
        String cpf = null;
        String cpfParametro = "12345678900";
        String email = "email05@email.com";
        BigDecimal valor = BigDecimal.valueOf(10000);
        int parcelas = 36;
        boolean seguro = true;
        SimulacaoDTO simulacaoDTO = new SimulacaoDTO(nome, cpf, email, valor, parcelas, seguro);

        //Dado que eu defino o parâmetro do header content type como "application/json"
        //E defino como parâmetro um CPF que é não é associado à uma simulação existente
        //E defino um body com as informações a serem alteradas
        given()
                .contentType(ContentType.JSON)
                .pathParam("cpf", cpfParametro)
                .body(simulacaoDTO.converterParaJson()).

        //Quando envio a solicitação PUT com o CPF parametrizado
        when()
                .put("/v1/simulacoes/{cpf}").

        //Então eu recebo o status code 404
        then()
                .assertThat()
                .statusCode(404);

    }


    //Cenário 9
    @Test
    public void testCenario9DeleteAPartirDeID(){

        String idParametro = "11";

        //Dado que eu defino o parâmetro do header content type como "application/json"
        //E defino como parâmetro um ID que é associado à uma simulação existente
        given()
                .contentType(ContentType.JSON)
                .pathParam("id", idParametro).

        //Quando envio a solicitação DELETE com o ID parametrizado
        when()
                .delete("/v1/simulacoes/{id}").

        //Então eu recebo o status code 200
        then()
                .assertThat()
                .statusCode(200);

    }

    //Cenário 10: não estava definido na documentação técnica

}
