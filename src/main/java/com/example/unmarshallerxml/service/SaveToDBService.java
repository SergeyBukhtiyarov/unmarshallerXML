package com.example.unmarshallerxml.service;

import com.example.unmarshallerxml.entity.OnOffDaily;
import com.example.unmarshallerxml.entity.OnOffHourly;
import com.example.unmarshallerxml.entity.Region;
import com.example.unmarshallerxml.repo.OnOffHourlyRepository;
import com.example.unmarshallerxml.repo.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveToDBService {


    @Autowired
    OnOffHourlyRepository onOffHourlyRepository;

    @Autowired
    RegionRepository regionRepository;

    public void save(OnOffDaily onOffDaily) {
        for (OnOffHourly onOffHourly : onOffDaily.getOnOffHourlyList()) {
            onOffHourlyRepository.save(onOffHourly);

        }
    }

    public void saveRegionsToDB(List<Region> regions) {
        regionRepository.saveAll(regions);
    }

}
