package com.example.unmarshallerxml.service;

import com.example.unmarshallerxml.entity.Region;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegionsLoaderService {


    public List<Region> loadRegions() throws IOException {

        String url = "https://br.so-ups.ru/webapi/api/dict/GetDictionaries";

        ObjectMapper mapper = new ObjectMapper();

        WebClient webClient = WebClient.create(url);
        List<Region> regions = webClient.get()


                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(s -> s.path("regions"))
                .map(s -> {
                    try {
                        return mapper.readValue(s.traverse(), new TypeReference<List<Region>>() {
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                        return new ArrayList<Region>();
                    }
                })
                .block();

        System.out.println(regions);


        RestTemplate restTemplate = new RestTemplate();
        JsonNode resp = restTemplate.getForObject(url, JsonNode.class);
//        System.out.println(resp.path("regions"));
        resp.path("regions").forEach((jsonNode) -> System.out.println(mapper.convertValue(jsonNode, Region.class)));


        return regions;
    }
}








