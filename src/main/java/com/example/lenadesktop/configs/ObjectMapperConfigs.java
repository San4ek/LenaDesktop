package com.example.lenadesktop.configs;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperConfigs {

    private static ObjectMapper objectMapper;

    public static ObjectMapper getObjectMapper() {
        if (objectMapper==null) {
            objectMapper=new ObjectMapper();
        }

        return objectMapper;
    }
}
