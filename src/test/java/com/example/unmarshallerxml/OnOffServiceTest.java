package com.example.unmarshallerxml;

import com.example.unmarshallerxml.entity.OnOffDaily;
import com.example.unmarshallerxml.service.OnOffJsoupLoaderService;
import com.example.unmarshallerxml.service.RegionsLoaderService;
import com.example.unmarshallerxml.service.OnOffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@SpringBootTest
public class OnOffServiceTest {
    @Autowired
    OnOffJsoupLoaderService service;

    @Autowired
    OnOffService onOffService;

    @Autowired
    RegionsLoaderService regionsLoaderService;

    @Test
    public void loadXMLfromSiteBR() throws JAXBException {
        String date = "2022.10.10";


        OnOffDaily onOffDaily = onOffService.getOnOffDaily(date, 36);
        System.out.println(onOffDaily);
    }

    @Test
    public void loadRegionsFromSiteBR() throws IOException {
        regionsLoaderService.loadRegions();



    }


}

