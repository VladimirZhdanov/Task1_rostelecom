package ru.rostelecom.dao.oracle;

import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.rostelecom.dao.PropertyLoader;
import ru.rostelecom.dao.layers.TsvetaDAO;
import ru.rostelecom.dao.mappers.TsvetaMapper;
import ru.rostelecom.exceptions.DAOException;
import ru.rostelecom.model.Tsveta;

import static ru.rostelecom.constants.Constants.NULL_WAS_PASSED;


/**
 * ClassRoom DAO.
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
@Repository
public class TsvetaOracle implements TsvetaDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(TsvetaOracle.class);

    private PropertyLoader propertyLoader;
    private Properties properties;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertTsveta;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public TsvetaOracle(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insertTsveta = new SimpleJdbcInsert(dataSource).withTableName("tsvreta");
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        properties = new Properties();
        propertyLoader = new PropertyLoader();
        init();
    }

    /**
     * Initialisation properties.
     */
    private void init() {
        propertyLoader.loadProperty(properties, "properties/queriesOracle.properties");
    }

    /**
     * Gets color by id.
     *
     * @param id - id
     * @return - color
     * @throws DAOException - DAOException
     */
    @Override
    public Tsveta getById(int id) throws DAOException {
        LOGGER.debug("Invoke method getById({})", id);
        String sql = properties.getProperty("getById");

        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new TsvetaMapper());
        } catch (EmptyResultDataAccessException e) {
            LOGGER.warn("Can't find record by passed id: {}", id);
            throw new DAOException("Can't find record by passed id", e);
        }
    }

    /**
     * Gets all colors.
     *
     * @return - List<Tsveta>
     */
    @Override
    public List<Tsveta> getAll() {
        String sql = properties.getProperty("getAll");
        return jdbcTemplate.query(sql, new TsvetaMapper());
    }

    /**
     * Inserts color to the table.
     *
     * @param tsveta - color
     * @return - boolean
     * @throws DAOException - DAOException
     */
    @Override
    public boolean insert(Tsveta tsveta) throws DAOException {
        LOGGER.debug("Insert classRoom: {}", tsveta);
        if (tsveta == null) {
            LOGGER.error(NULL_WAS_PASSED);
            throw new IllegalArgumentException(NULL_WAS_PASSED);
        }
        String sql = properties.getProperty("insert");

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", tsveta.getId())
                .addValue("color_number", tsveta.getColorNumber())
                .addValue("name", tsveta.getName());

        try {
            int result = namedParameterJdbcTemplate.update(sql, namedParameters);
            return result > 0;
        } catch (DuplicateKeyException e) {
            LOGGER.warn("Unique index or primary key violation");
            throw new DAOException("Unique index or primary key violation", e);
        }
    }

    /**
     * Updates a color.
     *
     * @param tsveta - color
     * @return - boolean
     * @throws DAOException - DAOException
     */
    @Override
    public boolean update(Tsveta tsveta) throws DAOException {
        LOGGER.debug("Update classRoom: {}", tsveta);
        if (tsveta == null) {
            LOGGER.error(NULL_WAS_PASSED);
            throw new IllegalArgumentException(NULL_WAS_PASSED);
        }

        String sql = properties.getProperty("update");
        boolean result = jdbcTemplate.update(sql, tsveta.getName(), tsveta.getColorNumber(), tsveta.getId()) > 0;
        if (!result) {
            LOGGER.warn("The record does not exist: {}", tsveta);
            throw new DAOException("The record does not exist");
        }
        return true;
    }

    /**
     * Deletes a record from the table.
     *
     * @param tsveta - color
     * @return - Tsveta
     * @throws DAOException - DAOException
     */
    @Override
    public Tsveta delete(Tsveta tsveta) throws DAOException {
        LOGGER.debug("Delete classRoom: {}", tsveta);
        if (tsveta == null) {
            LOGGER.error(NULL_WAS_PASSED);
            throw new IllegalArgumentException(NULL_WAS_PASSED);
        }
        String sql = properties.getProperty("delete");
        boolean result = jdbcTemplate.update(sql, tsveta.getId()) > 0;
        if (!result) {
            LOGGER.warn("The class record not exist: {}", tsveta);
            throw new DAOException("The record does not exist");
        }
        return tsveta;
    }
}