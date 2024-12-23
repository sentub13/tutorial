package com.pxp.SQLite.demo.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ParseData {
    public String getJsonData(Object data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String response = objectMapper.writeValueAsString(data);
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Error :", e);
        }
    }
}
