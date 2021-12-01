package com.pruebassaber311.generararchivos.services;

import com.google.gson.Gson;
import com.pruebassaber311.generararchivos.dtos.Item;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

@Service
public class ProcesarArchivoService implements IProcesarArchivoService {

    @Override
    public void Crear(List<Item> items) {
        try {
            String folder = "";
            String grado = "9";
            if (!items.isEmpty()){
                folder = grado + "/" + String.join("-", items.iterator().next().getTestName().split(":"));
                new File(folder).mkdirs();
                String pathPrincipal = folder + "/" + String.join("-", items.iterator().next().getTestName().split(":")) + ".json";
                PrintWriter archivoRespaldo = new PrintWriter(pathPrincipal);
                archivoRespaldo.println(new Gson().toJson(items));
                archivoRespaldo.close();

                for (Item i : items){

                    folder = grado + "/" + String.join("-", items.iterator().next().getTestName().split(":")) + "/" + i.getItemNumero();
                    new File(folder).mkdir();

                    i.setContent("<b style=color:orange;font-size:20px;>" + i.getTestName() + " - Cuadernillo 2 </b><br>" +
                            "<b style=color:orange;font-size:20px;>Saber " + grado + ".°</b>" + i.getContent());

                    i.setContent(String.join("tabindex='15'>\n        <p class=\"txt-jty\"><b>" + i.getOrder() + ".</b> ", i.getContent().split("tabindex='15 '>\n        <p class=\"txt-jty\">")));

                    i.setContent(String.join("https://s3.amazonaws.com/pruelec2017/mediaContent/", i.getContent().split("\\{\\{rutaBase}}")));
                    i.setContent(String.join("type=\"hidden\"", i.getContent().split("type=\"radio\"")));
                    i.setContent(String.join("type=\"hidden\" style=\"visibility:hidden;\"", i.getContent().split("type=\"button\"")));
                    i.setContent(String.join("type=\"hidden\" style=\"visibility:hidden;\"", i.getContent().split("type='button'")));
                    i.setContent(String.join("<table style=\"border:1px solid black; border-collapse:collapse;\">", i.getContent().split("<table class=\"table table-sm table-bordered table-striped table-responsive\" >")));
                    i.setContent(String.join("<th style=\"border:1px solid black;\">", i.getContent().split("<th>")));
                    i.setContent(String.join("<th scope=\"row\" style=\"width:40%; border:1px solid black;\">", i.getContent().split("<th scope=\"row\" style=\"width:40%\">")));
                    i.setContent(String.join("<td style=\"border:1px solid black;\">", i.getContent().split("<td>")));

                    i.setContent(String.join("type=\"hidden\" name=\"resp\" value=\"A\"/><br><b>A.</b>", i.getContent().split("type=\"hidden\" name=\"resp\" value=\"A\"/>")));
                    i.setContent(String.join("type=\"hidden\" name=\"resp\" value=\"B\"/><br><b>B.</b>", i.getContent().split("type=\"hidden\" name=\"resp\" value=\"B\"/>")));
                    i.setContent(String.join("type=\"hidden\" name=\"resp\" value=\"C\"/><br><b>C.</b>", i.getContent().split("type=\"hidden\" name=\"resp\" value=\"C\"/>")));
                    i.setContent(String.join("type=\"hidden\" name=\"resp\" value=\"D\"/><br><b>D.</b>", i.getContent().split("type=\"hidden\" name=\"resp\" value=\"D\"/>")));
                    i.setContent(String.join("type=\"hidden\" name=\"resp\" value=\"E\"/><br><b>E.</b>", i.getContent().split("type=\"hidden\" name=\"resp\" value=\"E\"/>")));
                    i.setContent(String.join("type=\"hidden\" name=\"resp\" value=\"F\"/><br><b>F.</b>", i.getContent().split("type=\"hidden\" name=\"resp\" value=\"F\"/>")));
                    i.setContent(String.join("type=\"hidden\" name=\"resp\" value=\"G\"/><br><b>G.</b>", i.getContent().split("type=\"hidden\" name=\"resp\" value=\"G\"/>")));
                    i.setContent(String.join("type=\"hidden\" name=\"resp\" value=\"H\"/><br><b>H.</b>", i.getContent().split("type=\"hidden\" name=\"resp\" value=\"H\"/>")));
                    i.setContent(String.join("type=\"hidden\" name=\"resp\" value=\"I\"/><br><b>I.</b>", i.getContent().split("type=\"hidden\" name=\"resp\" value=\"I\"/>")));

                    if (i.getItemNumero().contains("P")){
                        i.setContent(i.getContent() + "<br><b>" + i.getItemNumero().substring(0, 5) + "</b>");
                    }else{
                        i.setContent(i.getContent() + "<br><b>" + String.join("", i.getItemNumero().split("I_")) + "</b>");
                    }

                    String path = folder + "/" + i.getItemNumero() + ".html";

                    PrintWriter archivoRespuestas = new PrintWriter(path);
                    archivoRespuestas.println(i.getContent());
                    archivoRespuestas.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
