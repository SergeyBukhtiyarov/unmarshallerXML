package com.example.unmarshallerxml;

import com.example.unmarshallerxml.entity.OnOffDaily;
import com.example.unmarshallerxml.entity.Region;
import com.example.unmarshallerxml.repo.RegionRepository;
import com.example.unmarshallerxml.service.*;
import org.jsoup.Connection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.List;

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

    @Autowired
    RegionsLoaderService regionsLoaderService;



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

    @Test
    public void loadRegionsFromSiteBR() throws IOException {
        List<Region> regions = regionsLoaderService.loadRegions();
        saveToDBService.saveRegionsToDB(regions);



    }
}




