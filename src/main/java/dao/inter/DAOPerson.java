package dao.inter;

import java.util.List;

public interface DAOPerson<T , K> {

    void insert (T a) throws DAOException;

    List<T> getall() throws DAOException;

    T getone(K id) throws DAOException;
}
