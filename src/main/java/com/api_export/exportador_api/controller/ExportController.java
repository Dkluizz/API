package com.api_export.exportador_api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api_export.exportador_api.service.ApiService;
import com.api_export.exportador_api.service.ExportService;

@RestController
@RequestMapping("/export")
public class ExportController {
    
    private final ApiService apiService;
    private final ExportService exportService;

    public ExportController (ApiService apiService, ExportService exportService){
        this.apiService = apiService;
        this.exportService = exportService;

    }

    @PostMapping("/csv")
    public ResponseEntity<String> exportToCsv(@RequestParam String url, @RequestParam(required = false) String chave) {
        List<Map<String, Object>> data = apiService.searchApi(url, chave);
        String csv = exportService.exportToCsv(data);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data.csv")
                .header(HttpHeaders.CONTENT_TYPE, "text/csv")
                .body(csv);
    }

    @PostMapping("/xml")
    public ResponseEntity<String> exportToXml(@RequestParam String url, @RequestParam(required = false) String chave) {
        List<Map<String, Object>> data = apiService.searchApi(url, chave);
        String xml = exportService.exportToXml(data);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data.xml")
                .header(HttpHeaders.CONTENT_TYPE, "application/xml")
                .body(xml);
    }
}
