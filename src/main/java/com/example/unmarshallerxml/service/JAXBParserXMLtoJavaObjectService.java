package com.example.unmarshallerxml.service;

import com.example.unmarshallerxml.entity.OnOffDaily;
import com.example.unmarshallerxml.entity.OnOffHourly;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Service
public class JAXBParserXMLtoJavaObjectService {

    public OnOffDaily unmarshallFile(File file) throws JAXBException {
        OnOffDaily onOffDaily;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(OnOffDaily.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            onOffDaily = (OnOffDaily) unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return onOffDaily;
    }

}
