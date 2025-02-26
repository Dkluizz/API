package com.api_export.exportador_api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.core.ParameterizedTypeReference;
import java.util.List;
import java.util.Map;

@Service
public class ApiService {
    
    private final WebClient webCliente;

    public ApiService(WebClient.Builder webClientBuilder ){
        this.webCliente = webClientBuilder.build();

    }

    public List<Map<String,Object>> searchApi(String url, String key){

        return webCliente.get().uri(url)
        .header("Authorization", key != null ? "Bearer " + key : "")
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<List<Map<String, Object>>>(){})
        .block(); // Adiciona a chave, se houver
    }
}
