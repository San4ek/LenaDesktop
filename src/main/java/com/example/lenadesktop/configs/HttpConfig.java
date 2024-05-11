package com.example.lenadesktop.configs;

import com.example.lenadesktop.RequestException;
import com.example.lenadesktop.models.ErrorResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpConfig {
    public static <T,P> T sendPostRequest(String uri, Class<T> cClass, P obj) throws RequestException {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("http://localhost:8080" + uri)).
                    header("Content-Type", "application/json").
                    POST(HttpRequest.BodyPublishers.ofString(ObjectMapperConfigs.getObjectMapper().writeValueAsString(obj))).build();

            HttpResponse<String> httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (httpResponse.statusCode() != 200) throw new RequestException(ObjectMapperConfigs.getObjectMapper().readValue(httpResponse.body(),ErrorResponse.class).getMessage());

            return ObjectMapperConfigs.getObjectMapper().readValue(httpResponse.body(), cClass);
        } catch (IOException | InterruptedException e) {
            throw new RequestException("Bad connection!");
        }
    }
}
