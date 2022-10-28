package com.example.unmarshallerxml.service;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jsoup.Connection;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class TempFileService {

//    List<File> files = new ArrayList<>();

    public  File createTempService(Connection.Response response) {
        File file = null;
        try {
            file = File.createTempFile("onOffDailyFile", ".brDailyTemp");
           try (OutputStream outputStream = new FileOutputStream(file)){
               IOUtils.copy(response.bodyStream(),outputStream);
           }

//            files.add(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            file.deleteOnExit();
        }

        return file;
    }
}
