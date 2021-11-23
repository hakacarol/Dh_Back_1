package com.haka._consumir_apis;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultaCEPController {

    @GetMapping("/{cep}")
    public String consultaCEP(@PathVariable String cep) throws UnirestException {

        HttpResponse<JsonNode> jsonResponse = Unirest.get("https://brasilapi.com.br/api/cep/v1/" + cep).asJson();

        // tranformando a resposta para um obj
        JSONObject json = jsonResponse.getBody().getObject();

        return json.toString();
    }
}
