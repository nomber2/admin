package com.soft006.dao.impl;

import com.soft006.dao.DepartmentDAO;
import com.soft006.utils.JDBCUtil;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Admin on 2017/12/21.
 */
public class DepartmentDAOImpl implements DepartmentDAO{
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public String getName(Integer id) throws SQLException {
        String sql = "SELECT name FROM t_department WHERE id = ? ";
        Map<String,Object> map = jdbcUtil.executeQuerySingle(sql,new Object[]{id});
        return map.get("name").toString();
    }
}
