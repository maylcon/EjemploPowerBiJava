package com.pruebassaber311.generararchivos.dtos;

import io.github.satya64.powerbi.api.model.EmbedToken;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmbedParams {
    // Type of the object to be embedded
    private String Type;

    // Report to be embedded
    private List<EmbedReport> EmbedReport;

    // Embed Token for the Power BI report
    private EmbedToken EmbedToken;
}
