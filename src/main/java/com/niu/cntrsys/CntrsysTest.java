package com.niu.cntrsys;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;


import java.io.File;
import java.io.IOException;

public class CntrsysTest {
    public static Config config=null;

    public static void load(File file) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            config=mapper.readValue(file,Config.class);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void load(String path) {
        load(new File(CntrsysTest.class.getResource(path).getFile()));
    }

    public static void write(String path) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try{
            mapper.writeValue(new File(path),config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DocumentContext readJson(String path) {
        DocumentContext json = JsonPath.parse(CntrsysTest.class.getResourceAsStream(path));
        return json;
    }
}
