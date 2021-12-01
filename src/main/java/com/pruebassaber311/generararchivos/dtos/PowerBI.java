package com.pruebassaber311.generararchivos.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PowerBI {
    // Workspace Id for which Embed token needs to be generated
    private String WorkspaceId;

    // Report Id for which Embed token needs to be generated
    private String ReportId;
}
