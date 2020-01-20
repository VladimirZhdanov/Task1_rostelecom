package ru.rostelecom.dao.layers;

import ru.rostelecom.exceptions.DAOException;
import ru.rostelecom.model.Tsveta;

import java.util.List;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public interface TsvetaDAO {

    /**
     * Gets color by id.
     *
     * @param id - id
     * @return - color
     * @throws DAOException - DAOException
     */
    Tsveta getById(int id) throws DAOException;

    /**
     * Gets all colors.
     *
     * @return - List<Tsveta>
     */
    List<Tsveta> getAll();

    /**
     * Inserts color to the table.
     *
     * @param tsveta - color
     * @return - boolean
     * @throws DAOException - DAOException
     */
    boolean insert(Tsveta tsveta) throws DAOException;

    /**
     * Updates a color.
     *
     * @param tsveta - color
     * @return - boolean
     * @throws DAOException - DAOException
     */
    boolean update(Tsveta tsveta) throws DAOException;

    /**
     * Deletes a record from the table.
     *
     * @param tsveta - color
     * @return - Tsveta
     * @throws DAOException - DAOException
     */
    Tsveta delete(Tsveta tsveta) throws DAOException;
}
