package com.soft006.dao.impl;

import com.soft006.dao.RPDAO;
import com.soft006.model.RP;
import com.soft006.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 2017/12/19.
 */
public class RPDAOImpl implements RPDAO{
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
    @Override
    public List<RP> getALL() throws SQLException {
        String sql = "SELECT * FROM t_rp ";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getRPList(list);

    }

    @Override
    public List<RP> get(String account) throws SQLException {
        String sql = "SELECT * FROM t_rp WHERE account = ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql,new Object[]{account});
        return getRPList(list);
    }

    @Override
    public List<RP> queryLike(String keywords) throws SQLException {
        String sql = "Select * FROM t_rp WHERE CONCAT(kind,name) LIKE ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql, new Object[]{"%" + keywords + "%"});
        return getRPList(list);
    }

    @Override
    public List<RP> queryBy(String condition) throws SQLException {
        String sql = "SELECT * FROM t_rp " + condition;
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getRPList(list);
    }

    private List<RP> getRPList(List<Object> list) {
        List<RP> rpList = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            RP rp = new RP(map.get("account").toString(), map.get("kind").toString(),
                    map.get("name").toString(), (Date) map.get("time"));
            //给id设置值
            rp.setId((Integer) map.get("id"));
            rpList.add(rp);
        }
        return rpList;
    }
}
