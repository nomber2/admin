package com.soft006.service;

import com.soft006.model.Attendance;
import com.soft006.model.RP;

import java.util.List;

/**
 * Created by Admin on 2017/12/20.
 */
public interface EmployeeService {
    List<RP> getRP(String account);

    List<RP> queryLike(String keywords);

    List<RP> queryBy(String condition);

    List<Attendance> get(String account);

    List<Attendance> queryLikeA(String keywords);

    List<Attendance> getALL();

    int update(Attendance attendance);

    Attendance getAttendance(String id);
}
