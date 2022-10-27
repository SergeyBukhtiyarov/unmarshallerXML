package com.example.unmarshallerxml.repo;

import com.example.unmarshallerxml.entity.OnOffDaily;
import com.example.unmarshallerxml.entity.OnOffHourly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnOffHourlyRepository extends JpaRepository<OnOffHourly,Long> {
}
