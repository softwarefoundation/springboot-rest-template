package com.softwarefoundation.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CepDto implements Serializable {

   private String cep;
   private String logradouro;
   private String complemento;
   private String bairro;
   private String localidade;
   private String uf;
   private String ibge;
   private String gia;
   private String ddd;
   private String siafi;

}
