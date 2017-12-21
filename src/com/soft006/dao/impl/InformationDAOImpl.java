package com.soft006.dao.impl;

import com.soft006.dao.InformationDAO;
import com.soft006.model.Information;
import com.soft006.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 2017/12/20.
 */
public class InformationDAOImpl implements InformationDAO{
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public List<String> getNames(String account) throws SQLException {
        String sql = "SELECT name FROM t_information WHERE account = ? ";
        Map<String,Object> map = jdbcUtil.executeQuerySingle(sql,new Object[]{account});
        List<String> list = new ArrayList<>();
        if (map.size() != 0) {
            list.add(map.get("name").toString());
            return list;
        }
        return null;
    }
}
