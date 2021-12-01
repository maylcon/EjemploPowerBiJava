package com.pruebassaber311.generararchivos.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @JsonProperty("ItemId")
    private int ItemId;
    @JsonProperty("Content")
    private String Content;
    @JsonProperty("OrderVisual")
    private int OrderVisual;
    @JsonProperty("Sesion")
    private int Sesion;
    @JsonProperty("Total")
    private int Total;
    @JsonProperty("TestName")
    private String TestName;
    @JsonProperty("Type")
    private String Type;
    @JsonProperty("ItemNumero")
    private String ItemNumero;
    @JsonProperty("ItemChild")
    private int ItemChild;
    @JsonProperty("Order")
    private int Order;
    @JsonProperty("TotalVisual")
    private int TotalVisual;
    @JsonProperty("RecursosItem")
    private String RecursosItem;
    @JsonProperty("IdEstado")
    private String IdEstado;
    @JsonProperty("IdCombo")
    private int IdCombo;
    @JsonProperty("Code")
    private String Code;
}
