package com.soft006.dao;

import com.soft006.factory.DAOFactory;
import com.soft006.model.Attendance;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 2017/12/21.
 */
public class AttendanceDAOTest {
    private AttendanceDAO attendanceDAO;

    @Before
    public void setUp() throws Exception {
        attendanceDAO = DAOFactory.getAttendanceDAOInstance();
    }

    @Test
    public void update() throws Exception {
        Attendance attendance = attendanceDAO.getAttendance("1");
        attendance.setAttendance("是");
        int n = attendanceDAO.update(attendance);
        assertEquals(1,n);
        System.out.println(attendance);
    }

}