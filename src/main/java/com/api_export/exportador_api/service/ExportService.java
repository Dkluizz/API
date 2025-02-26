package com.api_export.exportador_api.service;

import org.springframework.stereotype.Service;

import com.api_export.exportador_api.util.CsvUtil;
import com.api_export.exportador_api.util.XmlUtil;

import java.util.List;
import java.util.Map;

@Service
public class ExportService {
    

    public String exportToCsv(List<Map<String,Object>> data){
        return CsvUtil.convertToCsv(data);
    }

     public String exportToXml(List<Map<String, Object>> data) {
        return XmlUtil.convertToXml(data);
    }
}
