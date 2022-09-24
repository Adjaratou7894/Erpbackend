package com.example.erpbackend.Controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "hello", description = "Importer et tirer en même temps")
@RequestMapping("/import")
@AllArgsConstructor
public class ImportTriePostulant {

}
