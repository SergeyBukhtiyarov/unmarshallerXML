//package com.example.unmarshallerxml.service;
//
//import com.example.unmarshallerxml.entity.OnOffDaily;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
//import org.jsoup.Connection;
//import org.jsoup.Jsoup;
//import org.springframework.stereotype.Service;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class DownloadXMLService {
//    public void getXmlResponseFromWebsite() throws IOException, JAXBException {
//        List<File> files = new ArrayList<>();
//
//
//
//        Connection.Response response = Jsoup
//                .connect("https://br.so-ups.ru/webapi/Public/Export/Xml/OnOffCount.aspx?date=2022.08.15&priceZonesIds=36&notCheckedColumnsNames=&zone=1&IsSubRf=true")
//                .method(Connection.Method.GET) //  метод запроса для использования, GET или POST.
//                .ignoreContentType(true) // значение true, чтобы тип содержимого игнорировался при анализе ответа в документе.
//                .execute(); //выполнить запрос
//
//        try {
//            File file = File.createTempFile("testingTgFile", ".atsTemp");
//            try (OutputStream outputStream = new FileOutputStream(file)) {
//                IOUtils.copy(response.bodyStream(), outputStream);
//                files.add(file);
//            } finally {
//                file.deleteOnExit();
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException("Error creating temporary TG file", e);
//        }
//
//        System.out.println(files);
//        JAXBContext jaxbContext = JAXBContext.newInstance(OnOffDaily.class);
//        javax.xml.bind.Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//        OnOffDaily onOffDaily = (OnOffDaily) unmarshaller.unmarshal(files.get(0));
//
//        System.out.println(onOffDaily);
//
//    }
//}
