package com.soft006.service;

import com.soft006.factory.ServiceFactory;
import com.soft006.model.RP;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Admin on 2017/12/20.
 */
public class EmployeeServiceTest {
    private EmployeeService employeeService;

    @Before
    public void setUp() throws Exception {
        employeeService = ServiceFactory.EmployeeServiceInstance();
    }

    @Test
    public void getRP() throws Exception {
        List<RP> list = employeeService.getRP("1602753135");
        list.forEach(rp -> System.out.println(rp));
    }

}