package com.api_export.exportador_api.util;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class CsvUtil {

    public static String convertToCsv(List<Map<String, Object>> data) {
        if (data.isEmpty()) return "";

        // Pegando os cabeçalhos (chaves do primeiro objeto)
        String headers = String.join(",", data.get(0).keySet());

        // Convertendo os valores para CSV
        String rows = data.stream()
                .map(row -> row.values().stream()
                        .map(value -> value != null ? value.toString() : "")
                        .collect(Collectors.joining(",")))
                .collect(Collectors.joining("\n"));

        return headers + "\n" + rows;
    }
}