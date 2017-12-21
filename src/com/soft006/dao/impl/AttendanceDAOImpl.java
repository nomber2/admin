package com.soft006.dao.impl;

import com.soft006.dao.AttendanceDAO;
import com.soft006.model.Attendance;
import com.soft006.utils.JDBCUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 2017/12/21.
 */
public class AttendanceDAOImpl implements AttendanceDAO{
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
    @Override
    public List<Attendance> getAll() throws SQLException {
        String sql = "SELECT * FROM t_attendance ";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getAttendance(list);
    }


    @Override
    public List<Attendance> get(String account) throws SQLException {
        String sql = "SELECT * FROM t_attendance WHERE account = ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql,new Object[]{account});
        return getAttendance(list);
    }

    @Override
    public List<Attendance> queryLike(String keywords) throws SQLException {
        String sql = "Select * FROM t_attendance WHERE CONCAT(mouth,day,attendance) LIKE ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql, new Object[]{"%" + keywords + "%"});
        return getAttendance(list);
    }

    @Override
    public int update(Attendance attendance) throws SQLException {
        int n;
        String sql = "UPDATE t_attendance SET attendance = ? WHERE id = ? ";
        Object[] params = {attendance.getAttendance(),attendance.getId()};
        n = jdbcUtil.executeUpdate(sql,params);
        return n;
    }

    @Override
    public Attendance getAttendance(String id) throws SQLException {
        String sql = "SELECT * FROM t_attendance WHERE id = ? ";
        Map<String, Object> map = jdbcUtil.executeQuerySingle(sql, new Object[]{id});
        Attendance attendance = new Attendance(map.get("id").toString(),map.get("account").toString(),(Integer) map.get("departmentID"),
                map.get("mouth").toString(),map.get("day").toString(),map.get("attendance").toString());
        return attendance;
    }


    private List<Attendance> getAttendance(List<Object> list) {
        List<Attendance> attList = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Attendance attendance = new Attendance(map.get("id").toString(),map.get("account").toString(), (Integer) map.get("departmentID"),
                    map.get("mouth").toString(),map.get("day").toString(), map.get("attendance").toString());
            attList.add(attendance);
        }
        return attList;
    }
}
