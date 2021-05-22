package br.com.sicredi.simulacao;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public abstract class ConfiguracoesAPI {

    @BeforeClass
    public static void definicaoAPIURL() {
        //Contexto: Dada a definição de uma URL REST API
        RestAssured.baseURI = "http://localhost/";
        RestAssured.port = 8080;
        RestAssured.basePath = "/api";
    }

}


