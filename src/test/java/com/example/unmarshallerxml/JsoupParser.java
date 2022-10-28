package com.example.unmarshallerxml;

import com.example.unmarshallerxml.entity.OnOffDaily;
import com.example.unmarshallerxml.service.JAXBParserXMLtoJavaObjectService;
import com.example.unmarshallerxml.service.OnOffJsoupLoaderService;
import com.example.unmarshallerxml.service.SaveToDBService;
import com.example.unmarshallerxml.service.TempFileService;
import org.jsoup.Connection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

@SpringBootTest
public class JsoupParser {


    @Autowired
    OnOffJsoupLoaderService onOffLoaderService;
    @Autowired
    TempFileService tempFileService;

    @Autowired
    SaveToDBService saveToDBService;

    @Autowired
    JAXBParserXMLtoJavaObjectService jaxbParserService;

    @Test
    public void getXmlResponseFromWebsite() throws IOException, JAXBException {

        String date = "2022.01.10";
        int region = 36;

        Connection.Response response = onOffLoaderService.load(date, region);
        File file = tempFileService.createTempService(response);
        OnOffDaily onOffDaily = jaxbParserService.unmarshallFile(file);
        saveToDBService.save(onOffDaily);



        System.out.println(onOffDaily);
    }
}




