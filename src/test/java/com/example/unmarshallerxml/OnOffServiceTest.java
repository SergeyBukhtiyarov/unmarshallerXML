package com.example.unmarshallerxml;

import com.example.unmarshallerxml.service.OnOffJsoupLoaderService;
import com.example.unmarshallerxml.service.OnOffRegionsJsoupLoaderService;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OnOffServiceTest {
    @Autowired
    OnOffJsoupLoaderService service;

    @Autowired
    OnOffRegionsJsoupLoaderService onOffRegionsJsoupLoaderService;

    @Test
    public void loadFromBRWebsiteWithWrongDate() {
//        String date = "2022.10.10";
//        Connection.Response response = service.load(date, 36);
        //System.out.println(response.body());
//        Connection.Response response = onOffRegionsJsoupLoaderService.loadRegions();
//        System.out.println(response.bodyStream());

        Document doc = onOffRegionsJsoupLoaderService.loadRegions();
        System.out.println(doc);
      Elements title=onOffRegionsJsoupLoaderService.getElement(doc);
        System.out.println(title);

    }
}
