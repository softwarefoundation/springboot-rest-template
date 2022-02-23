package com.softwarefoundation.restcontroller;

import com.softwarefoundation.dto.CepDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/cep")
public class ViaCepRestController {

    @GetMapping(value = "/{cep}")
    public ResponseEntity<?> consultarCep(@PathVariable("cep") String cep){
        RestTemplate restTemplate = new RestTemplate();
        String urlViaCep = "https://viacep.com.br/ws/".concat(cep).concat("/json");

        log.info("Consulta ViaCep: {}", urlViaCep);
        ResponseEntity<CepDto> response = restTemplate.getForEntity(urlViaCep, CepDto.class);

        return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
    }

}
