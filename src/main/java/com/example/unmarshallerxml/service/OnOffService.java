package com.example.unmarshallerxml.service;

import com.example.unmarshallerxml.entity.OnOffDaily;
import org.jsoup.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.bind.JAXBException;
import java.io.File;

@Service
public class OnOffService {

    @Autowired
    OnOffJsoupLoaderService onOffJsoupLoaderService;

    @Autowired
    TempFileService tempFileService;

    @Autowired
    JAXBParserXMLtoJavaObjectService jaxbParserXMLtoJavaObjectService;

    public OnOffDaily getOnOffDaily(String data, int region) throws JAXBException {


        Connection.Response response = onOffJsoupLoaderService.load(data,region);
        File file = tempFileService.createTempService(response);
        OnOffDaily onOffDaily = jaxbParserXMLtoJavaObjectService.unmarshallFile(file);


        return onOffDaily;
    }



}
