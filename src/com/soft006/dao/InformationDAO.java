package com.soft006.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 2017/12/19.
 */
public interface InformationDAO {
    List<String> getNames(String account) throws SQLException;
}
