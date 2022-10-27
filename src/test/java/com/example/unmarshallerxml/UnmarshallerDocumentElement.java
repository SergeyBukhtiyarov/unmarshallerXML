//package com.example.unmarshallerxml;
//
//import com.example.unmarshallerxml.entity.OnOffDaily;
//import com.example.unmarshallerxml.entity.OnOffHourly;
//import com.example.unmarshallerxml.repo.OnOffDailyRepository;
//import com.example.unmarshallerxml.repo.OnOffHourlyRepository;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import java.io.File;
//
//@SpringBootTest
//public class UnmarshallerDocumentElement {
//    @Autowired
//    DownloadXMLService downloadXMLService;
//
//    @Autowired
//    OnOffDailyRepository onOffDailyRepository;
//    @Autowired
//    OnOffHourlyRepository onOffHourlyRepository;
//
//
//    @Test
//    public void unmarshaller() throws JAXBException {
//        JAXBContext jaxbContext = JAXBContext.newInstance(OnOffDaily.class);
//        javax.xml.bind.Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//
//        OnOffDaily onOffDaily = (OnOffDaily) unmarshaller.unmarshal(new File("/Users/sergejb/Desktop/OnOff.xml"));
//        System.out.println(onOffDaily);
//        for (OnOffHourly onOffHourly:onOffDaily.getOnOffHourlyList()){
//           onOffHourlyRepository.save(onOffHourly);
//
//
//        }
//
//
//
//
//    }
//}







