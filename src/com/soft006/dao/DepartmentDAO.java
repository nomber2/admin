package com.soft006.dao;

import java.sql.SQLException;

/**
 * Created by Admin on 2017/12/21.
 */
public interface DepartmentDAO {

    /**
     * 根据id得到部门名字
     * @return
     * @throws SQLException
     */
    String getName(Integer id) throws SQLException;
}
