package com.choimory.applicantestate.parse.service;

import com.choimory.applicantestate.parse.dto.Output;
import com.choimory.applicantestate.parse.dto.RawData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.Random;

@Service
@AllArgsConstructor
public class ParseService {
    private final ObjectMapper objectMapper;
    private static final String FILE_PATH = "rawdata";
    private static final String FILE_NAME = "rawdata";
    private static final String EXTENSION = ".json";

    public Output parse() throws Exception {
        // 무작위의 RAWDATA 읽기
        int fileNumber = new Random().nextInt(10) + 1;
        InputStream inputStream = new ClassPathResource(FILE_PATH + File.separator + FILE_NAME + fileNumber + EXTENSION).getInputStream();
        RawData rawData = objectMapper.readValue(inputStream, RawData.class);

        // Output으로 변환 및 반환
        return Output.to(rawData);
    }
}
