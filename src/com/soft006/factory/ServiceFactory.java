package com.soft006.factory;

import com.soft006.service.EmployeeService;
import com.soft006.service.impl.EmployeeServiceImpl;

/**
 * Created by Admin on 2017/12/20.
 */
public class ServiceFactory {
    public static EmployeeService EmployeeServiceInstance() {
        return new EmployeeServiceImpl();
    }

}
