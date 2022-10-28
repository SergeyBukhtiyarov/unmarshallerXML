package com.example.unmarshallerxml.service;

import com.example.unmarshallerxml.entity.OnOffDaily;
import com.example.unmarshallerxml.entity.OnOffHourly;
//import com.example.unmarshallerxml.repo.OnOffDailyRepository;
import com.example.unmarshallerxml.repo.OnOffHourlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveToDBService {
//    @Autowired
//    OnOffDailyRepository onOffDailyRepository;

    @Autowired
    OnOffHourlyRepository onOffHourlyRepository;

    public  void save(OnOffDaily onOffDaily) {
        for (OnOffHourly onOffHourly : onOffDaily.getOnOffHourlyList()) {
           onOffHourlyRepository.save(onOffHourly);

        }
    }

}
