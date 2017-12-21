package com.soft006.service.impl;

import com.soft006.dao.AttendanceDAO;
import com.soft006.dao.RPDAO;
import com.soft006.factory.DAOFactory;
import com.soft006.model.Attendance;
import com.soft006.model.RP;
import com.soft006.service.EmployeeService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 2017/12/20.
 */
public class EmployeeServiceImpl implements EmployeeService{
    private RPDAO rpdao = DAOFactory.getRPDAOInstance();
    private AttendanceDAO attendanceDAO = DAOFactory.getAttendanceDAOInstance();

    @Override
    public List<RP> getRP(String account) {
        List<RP> list = null;
        try {
            list = rpdao.get(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<RP> queryLike(String keywords) {
        List<RP> list = null;
        try {
            list = rpdao.queryLike(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<RP> queryBy(String condition) {
       List<RP> list = null;
        try {
            list = rpdao.queryBy(condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Attendance> get(String account) {
        List<Attendance> list = null;
        try {
            list = attendanceDAO.get(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Attendance> queryLikeA(String keywords) {
        List<Attendance> list = null;
        try {
            list = attendanceDAO.queryLike(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Attendance> getALL() {
        List<Attendance> list = null;
        try {
            list = attendanceDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int update(Attendance attendance) {
        int n = 0;
        try {
            n = attendanceDAO.update(attendance);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public Attendance getAttendance(String id) {
        Attendance attendance = null;
        try {
            attendance = attendanceDAO.getAttendance(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendance;
    }


}
