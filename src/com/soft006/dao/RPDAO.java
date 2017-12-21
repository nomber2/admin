package com.soft006.dao;

import com.soft006.model.RP;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 2017/12/19.
 */
public interface RPDAO {
    /**
     * 得到RP表所有数据
     * @return
     * @throws SQLException
     */
    List<RP> getALL( ) throws SQLException;

    /**
     * 得到某一个人的奖惩数据
     * @param account
     * @return
     * @throws SQLException
     */
    List<RP> get(String account) throws SQLException;

    /**
     * 关键字模糊查询
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<RP> queryLike(String keywords) throws SQLException;

    /**
     * JComBoBox条件查询
     * @param condition
     * @return
     * @throws SQLException
     */
    List<RP> queryBy(String condition) throws SQLException;
}
