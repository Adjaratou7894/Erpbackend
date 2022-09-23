package com.example.erpbackend.Controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "hello", description = "Gestion de la liste des Postulants")
@RequestMapping("/listepostulant")

public class ListePostulantController {
}
