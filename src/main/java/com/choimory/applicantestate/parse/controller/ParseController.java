package com.choimory.applicantestate.parse.controller;

import com.choimory.applicantestate.parse.dto.Output;
import com.choimory.applicantestate.parse.service.ParseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parse")
@RequiredArgsConstructor
public class ParseController {
    private final ParseService parseService;

    @GetMapping
    public Output parse() throws Exception {
        return parseService.parse();
    }
}
