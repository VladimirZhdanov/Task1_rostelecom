package ru.rostelecom.web.controllers;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rostelecom.model.Tsveta;
import ru.rostelecom.service.layers.TsvetaService;

import java.util.List;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
@RestController
public class RestControllers {

    private Tsveta tsveta;
    private TsvetaService tsvetaService;

    @Autowired
    public void setTsvetaService(TsvetaService tsvetaService) {
        this.tsvetaService = tsvetaService;
    }
    @Autowired
    public void setTsveta(Tsveta tsveta) {
        this.tsveta = tsveta;
    }

    @GetMapping("/getAll")
    public String getAll() {
        List<Tsveta> tsvetas = tsvetaService.getAll();

        JSONArray js = new JSONArray(tsvetas);
        String JSResult = js.toString();

        return JSResult;
    }
}
