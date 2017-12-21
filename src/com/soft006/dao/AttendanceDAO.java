package com.soft006.dao;

import com.soft006.model.Attendance;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 2017/12/21.
 */
public interface AttendanceDAO {
    /**
     * 得到考勤表所有数据
     * @return
     * @throws SQLException
     */
    List<Attendance> getAll() throws SQLException;

    /**
     * 根据账号得到某一个人的考勤数据
     * @param account
     * @return
     * @throws SQLException
     */
    List<Attendance> get(String account) throws SQLException;

    /**
     * 模糊查询
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<Attendance> queryLike(String keywords) throws SQLException;

    /**
     * 更新一条考勤记录
     * @param attendance
     * @return
     * @throws SQLException
     */
    int update(Attendance attendance) throws SQLException;

    /**
     * 根据主键查询某一条记录
     * @param id
     * @return
     * @throws SQLException
     */
    Attendance getAttendance(String id) throws SQLException;
}
