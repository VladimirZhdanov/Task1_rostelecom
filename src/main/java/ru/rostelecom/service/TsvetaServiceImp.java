package ru.rostelecom.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rostelecom.dao.layers.TsvetaDAO;
import ru.rostelecom.model.Tsveta;
import ru.rostelecom.service.layers.TsvetaService;

import java.util.List;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
@Component
@Service("TsvetaService")
public class TsvetaServiceImp implements TsvetaService {
    //private static final Logger LOGGER = LoggerFactory.getLogger(TsvetaServiceImp.class);

    private TsvetaDAO tsvetaDAO;

    @Autowired
    public TsvetaServiceImp(TsvetaDAO tsvetaDAO) {
        this.tsvetaDAO = tsvetaDAO;
    }

    /**
     * Gets all colors.
     *
     * @return - List<Tsveta>
     */
    @Override
    @Transactional(readOnly = true)
    public List<Tsveta> getAll() {
        return tsvetaDAO.getAll();
    }
}
