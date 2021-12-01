package com.pruebassaber311.generararchivos.services;

import com.microsoft.aad.adal4j.AuthenticationResult;
import com.pruebassaber311.generararchivos.dtos.AzureAd;
import lombok.val;

public class AadService {

    private final AzureAd azureAd;

    public AadService(AzureAd azureAd) {
        this.azureAd = azureAd;
    }

    public String GetAccessToken(){
        AuthenticationResult authenticationResult = null;
        if(azureAd.getAuthenticationMode().equalsIgnoreCase("masteruser")){
            //IPublicClientApplication clientApp = PublicClientApplicationBuilder.Create(azureAd.getClientId()).WithAuthority(azureAd.getAuthorityUri()).Build();
        }
        return null;
    }
}
