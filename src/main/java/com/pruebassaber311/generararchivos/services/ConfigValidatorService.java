package com.pruebassaber311.generararchivos.services;

import com.pruebassaber311.generararchivos.dtos.AzureAd;
import com.pruebassaber311.generararchivos.dtos.PowerBI;

import java.util.UUID;

public class ConfigValidatorService {
    public static String ValidateConfig(AzureAd azureAd, PowerBI powerBI)
    {
        String message = null;
        boolean isAuthModeMasterUser = azureAd.getAuthenticationMode().equalsIgnoreCase("masteruser");
        boolean isAuthModeServicePrincipal = azureAd.getAuthenticationMode().equalsIgnoreCase("serviceprincipal");

        if (azureAd.getAuthenticationMode().isEmpty() ||  azureAd.getAuthenticationMode().isBlank())
        {
            message = "Authentication mode is not set in appsettings.json file";
        }
        else if (azureAd.getAuthorityUri().isEmpty() ||  azureAd.getAuthorityUri().isBlank())
        {
            message = "Authority is not set in appsettings.json file";
        }
        else if (azureAd.getClientId().isEmpty() || azureAd.getClientId().isBlank())
        {
            message = "Client Id is not set in appsettings.json file";
        }
        else if (isAuthModeServicePrincipal && (azureAd.getTenantId().isEmpty() || azureAd.getTenantId().isBlank()))
        {
            message = "Tenant Id is not set in appsettings.json file";
        }
        else if (azureAd.getScope() == null || azureAd.getScope().length == 0)
        {
            message = "Scope is not set in appsettings.json file";
        }
            else if (powerBI.getWorkspaceId().isEmpty() || powerBI.getWorkspaceId().isBlank())
    {
        message = "Workspace Id is not set in appsettings.json file";
    }
    else if (!IsValidGuid(powerBI.getWorkspaceId()))
    {
        message = "Please enter a valid guid for Workspace Id in appsettings.json file";
    }
    else if (powerBI.getReportId().isEmpty() || powerBI.getReportId().isBlank())
    {
        message = "Report Id is not set in appsettings.json file";
    }
    else if (!IsValidGuid(powerBI.getReportId()))
    {
        message = "Please enter a valid guid for Report Id in appsettings.json file";
    }
    else if (isAuthModeMasterUser && (azureAd.getPbiUsername().isEmpty() || azureAd.getPbiUsername().isBlank()))
    {
        message = "Master user email is not set in appsettings.json file";
    }
    else if (isAuthModeMasterUser && (azureAd.getPbiPassword().isEmpty() || azureAd.getPbiPassword().isBlank()))
    {
        message = "Master user password is not set in appsettings.json file";
    }
    else if (isAuthModeServicePrincipal && (azureAd.getClientSecret().isEmpty() || azureAd.getClientSecret().isBlank()))
    {
        message = "Client secret is not set in appsettings.json file";
    }

        return message;
    }

    /// <summary>
    /// Checks whether a string is a valid guid
    /// </summary>
    /// <param name="configParam">String value</param>
    /// <returns>Boolean value indicating validity of the guid</returns>
    private static boolean IsValidGuid(String configParam)
    {
        try{
            UUID.fromString(configParam);
            return true;
        } catch (IllegalArgumentException exception){
            return false;
        }
    }
}
