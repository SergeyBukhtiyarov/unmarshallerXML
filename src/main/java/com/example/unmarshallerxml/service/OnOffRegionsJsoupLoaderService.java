package com.example.unmarshallerxml.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OnOffRegionsJsoupLoaderService {

//  Connection.Response response;
//
//    public Connection.Response loadRegions() {
//        try {
//            response = Jsoup.connect("https://br.so-ups.ru")
//                    .method(Connection.Method.GET)
//                    .ignoreContentType(true)
//                    .execute();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println();
//        return response;
//
//
//    }

    Document doc;
    public Document loadRegions() {

        try {
            doc = Jsoup.connect("https://br.so-ups.ru/webapi/api/dict/GetDictionaries")
                    .ignoreContentType(true)
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return doc;
    }

    public Elements getElement(Document doc) {
        Elements title = doc.getElementsByTag("regions");
        return title;
    }


}
