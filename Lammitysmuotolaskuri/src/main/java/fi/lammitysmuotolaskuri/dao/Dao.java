
package fi.lammitysmuotolaskuri.dao;

import java.sql.*;
import java.util.*;

public interface Dao<T, K> {
    void create(T object) throws SQLException;
    T read(String name) throws SQLException;
    void update(T object) throws SQLException;
    void delete(String name) throws SQLException;
}
