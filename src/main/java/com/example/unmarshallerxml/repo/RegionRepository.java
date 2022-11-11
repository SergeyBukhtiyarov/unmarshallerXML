package com.example.unmarshallerxml.repo;

import com.example.unmarshallerxml.entity.OnOffHourly;
import com.example.unmarshallerxml.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,Long> {
}
