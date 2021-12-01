package com.pruebassaber311.generararchivos.dtos;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmbedReport {
    // Id of Power BI report to be embedded
    private UUID ReportId;

    // Name of the report
    private String ReportName;

    // Embed URL for the Power BI report
    private String EmbedUrl;
}
