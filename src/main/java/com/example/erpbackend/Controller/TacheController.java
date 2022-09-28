package com.example.erpbackend.Controller;


import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "hello", description = "controller permettant d'ajouter une tache")
@AllArgsConstructor
@RequestMapping("/tache")
@CrossOrigin(origins = "http://localhost:8100")
public class TacheController {

}