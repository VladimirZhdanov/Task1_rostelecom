package ru.rostelecom.web.controllers;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rostelecom.model.Tsveta;
import ru.rostelecom.service.layers.TsvetaService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
@Controller
@RequestMapping("/")
public class HomeControllers {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeControllers.class);

    @Autowired
    public void setTsvetaService(TsvetaService tsvetaService) {
        this.tsvetaService = tsvetaService;
    }

    private TsvetaService tsvetaService;

    @GetMapping(value = {"/", "home"})
    public String showPage() {
        return "home";
    }

    @ModelAttribute("allColors")
    public List<Tsveta> allColors() {
        List<Tsveta> tsvetas = tsvetaService.getAll();
        JSONArray js = new JSONArray(tsvetas);
        return getAllTsveta(js);
    }

    private List<Tsveta> getAllTsveta(JSONArray jsonArray){
        com.google.gson.Gson gn = new com.google.gson.Gson();
        List<Tsveta> list = new ArrayList<>();
        for (Object obj : jsonArray) {
            String result = obj.toString();
            Tsveta coutriResult = gn.fromJson(result, Tsveta.class);
            list.add(coutriResult);
        }
        LOGGER.info(list.toString());
        return list;
    }
}
