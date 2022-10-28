package com.example.unmarshallerxml.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OnOffJsoupLoaderService {

    public Connection.Response load(String date,int region) {

        Connection.Response response;
        try {
            response = Jsoup
                    .connect("https://br.so-ups.ru/webapi/Public/Export/Xml/OnOffCount." +
                            "aspx?date=" + date + "&priceZonesIds=" + region + "&notCheckedColumnsNames=&zone=1&IsSubRf=true")
                    .method(Connection.Method.GET)
                    .ignoreContentType(true)
                    .execute();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

        return response;
    }
}
