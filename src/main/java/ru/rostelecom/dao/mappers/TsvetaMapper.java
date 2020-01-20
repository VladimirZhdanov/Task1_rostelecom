package ru.rostelecom.dao.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import ru.rostelecom.model.Tsveta;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class TsvetaMapper implements RowMapper<Tsveta> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TsvetaMapper.class);

    public Tsveta mapRow(ResultSet rs, int rowNum) throws SQLException {
        LOGGER.debug("ResultSet: {}, rowNum: {}", rs, rowNum);
        Tsveta tsveta = new Tsveta();
        tsveta.setId(rs.getInt("id"));
        tsveta.setColorNumber(rs.getString("color_number"));
        tsveta.setName(rs.getString("name"));
        LOGGER.debug("Returned: {}", tsveta);
        System.out.println("===================" + tsveta);
        return tsveta;
    }
}
