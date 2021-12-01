package com.pruebassaber311.generararchivos.services;

import io.github.satya64.powerbi.api.PowerBiClient;
import org.springframework.web.util.UriBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class PbiEmbedService {
    private final AadService aadService;
    private final String urlPowerBiServiceApiRoot = "https://api.powerbi.com";

    public PbiEmbedService(AadService aadService)
    {
        this.aadService = aadService;
    }

    public PowerBiClient GetPowerBIClient() throws MalformedURLException, URISyntaxException {
        // var tokenCredentials = new TokenCredentials(aadService.GetAccessToken(), "Bearer");
        URL tempUrl = new URL(urlPowerBiServiceApiRoot);
        PowerBiClient powerBiClient = PowerBiClient.getInstance("Bearer " + aadService.GetAccessToken());

        return powerBiClient;
    }

}
