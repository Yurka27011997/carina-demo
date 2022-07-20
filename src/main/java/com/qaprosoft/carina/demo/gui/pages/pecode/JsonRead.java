package com.qaprosoft.carina.demo.gui.pages.pecode;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonRead {
    private static final Logger LOGGER = LogManager.getLogger(JsonRead.class);

    public LoginData jsonReadFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        LoginData loginData = new LoginData();

        try{
            LOGGER.info("Reading JSON from a file: ");

            BufferedReader br = new BufferedReader (new FileReader("src/main/resources/pecode/JsonPecode.json"));

            loginData = mapper.readValue(br, LoginData.class);

            String username = loginData.getUsername();
            String password = loginData.getPassword();

            LOGGER.info("Username: " + username);
            LOGGER.info("Password: " + password);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return loginData;


    }




}
