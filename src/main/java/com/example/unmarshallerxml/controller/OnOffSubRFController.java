package com.example.unmarshallerxml.controller;

import com.example.unmarshallerxml.entity.OnOffDaily;
import com.example.unmarshallerxml.exceptions.OnOffDailyNotLoadedException;
import com.example.unmarshallerxml.service.OnOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping("/api-on-off")
public class OnOffSubRFController {

    @Autowired
    OnOffService onOffService;

    @GetMapping("/load")
    public ResponseEntity<OnOffDaily> getOnOffbyDateAndRegion(@RequestParam(name = "date") String date,
                                                              @RequestParam(name = "region") int region) throws JAXBException {
        OnOffDaily onOffDaily;
        try {
            onOffDaily = onOffService.getOnOffDaily(date, region);
        } catch (OnOffDailyNotLoadedException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<>(onOffDaily, HttpStatus.OK);
    }

}
