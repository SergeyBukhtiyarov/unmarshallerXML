package com.example.unmarshallerxml;

import com.example.unmarshallerxml.entity.OnOffDaily;
import com.example.unmarshallerxml.entity.OnOffHourly;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

@SpringBootTest
public class UnmarshallerRow {



    @Test
    public void unmarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(OnOffHourly.class);
        javax.xml.bind.Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        OnOffHourly onOffHourly = (OnOffHourly) unmarshaller.unmarshal(new File("/Users/sergejb/Desktop/OnOffrow.xml"));

            System.out.println(onOffHourly.getHour());
            System.out.println(onOffHourly.getSub_rf_id());
            System.out.println(onOffHourly.getDate());
//            onOffHourlyRepository.save(onOffHourly);


    }
}







