package com.pruebassaber311.generararchivos.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AzureAd {
    // Can be set to 'MasterUser' or 'ServicePrincipal'
    private String authenticationMode;

    // URL used for initiating authorization request
    private String authorityUri;

    // Client Id (Application Id) of the AAD app
    private String clientId;

    // Id of the Azure tenant in which AAD app is hosted. Required only for Service Principal authentication mode.
    private String tenantId;

    // Scope of AAD app. Use the below configuration to use all the permissions provided in the AAD app through Azure portal.
    private String[] scope;

    // Master user email address. Required only for MasterUser authentication mode.
    private String pbiUsername;

    // Master user email password. Required only for MasterUser authentication mode.
    private String pbiPassword;

    // Client Secret (App Secret) of the AAD app. Required only for ServicePrincipal authentication mode.
    private String clientSecret;
}
