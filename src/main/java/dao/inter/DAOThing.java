package dao.inter;

import java.util.List;

public interface DAOThing <T, K>{

    void insert (T b) throws DAOException;

    List<T> getall() throws DAOException;

    T getone(K id) throws DAOException;
}
