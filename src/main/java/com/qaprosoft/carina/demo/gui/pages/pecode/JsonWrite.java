package com.qaprosoft.carina.demo.gui.pages.pecode;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JsonWrite {
    private static final Logger LOGGER = LogManager.getLogger(JsonWrite.class);

    public void jsonWriteToFile() {

        LoginData loginData = new LoginData();
        loginData.setUsername("testUser");
        loginData.setPassword("1234");

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/pecode/JsonPecode.json"), loginData);
            LOGGER.info("Data was write to JSonFile successfully");


        } catch (JsonGenerationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
