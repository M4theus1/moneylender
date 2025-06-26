package com.desafio.url.controller;

import com.desafio.url.model.Url;
import com.desafio.url.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<Map<String, String>> shortenUrl(@RequestBody Map<String, String> request){

        if(!request.containsKey("url")){
            return ResponseEntity.badRequest().body(Map.of("error", "Campo 'url' é obrigatório"));
        }

        String originalUrl = request.get("url");

        if(originalUrl == null || originalUrl.trim().isEmpty()){
            return ResponseEntity.badRequest().body(Map.of("error", "A URL não pode estar vazia"));
        }

        try{
            new java.net.URL(originalUrl);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "A URL fornecida é inválida"));
        }

        String shortUrl = urlService.shortenUrl(originalUrl);
        Map<String, String> response = new HashMap<String, String>();
        response.put("url", "https://xxx.com/" + shortUrl);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Object> redirectToOriginalUrl(@PathVariable String shortUrl){

        Optional<Url> urlOptional = urlService.getOriginalUrl(shortUrl);
        if(urlOptional.isPresent()){
            Url url = urlOptional.get();
            System.out.println("Redirecionando para: " + url.getOriginalUrl());
            return ResponseEntity.status(302).location(URI.create(url.getOriginalUrl())).build();
        }

        System.out.println("Url não encontrada ou expirada: " + shortUrl);
        return ResponseEntity.notFound().build();
    }



}


