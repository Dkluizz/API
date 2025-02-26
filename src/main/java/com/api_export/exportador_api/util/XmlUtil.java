package com.api_export.exportador_api.util;

import java.util.List;
import java.util.Map;

public class XmlUtil {

    public static String convertToXml(List<Map<String, Object>> data) {
        StringBuilder xml = new StringBuilder();
        xml.append("<root>\n");

        for (Map<String, Object> row : data) {
            xml.append("  <item>\n");
            for (Map.Entry<String, Object> entry : row.entrySet()) {
                xml.append("    <").append(entry.getKey()).append(">")
                        .append(entry.getValue())
                        .append("</").append(entry.getKey()).append(">\n");
            }
            xml.append("  </item>\n");
        }

        xml.append("</root>");
        return xml.toString();
    }
}