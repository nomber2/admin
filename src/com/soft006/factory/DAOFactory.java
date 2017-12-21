package com.soft006.factory;

import com.soft006.dao.AttendanceDAO;
import com.soft006.dao.RPDAO;
import com.soft006.dao.impl.AttendanceDAOImpl;
import com.soft006.dao.impl.RPDAOImpl;

/**
 * Created by Admin on 2017/12/20.
 */
public class DAOFactory {
    public static RPDAO getRPDAOInstance() {
        return new RPDAOImpl();
    }

    public static AttendanceDAO getAttendanceDAOInstance() {
        return new AttendanceDAOImpl();
    }
}
