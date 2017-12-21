package com.soft006.dao;

import com.soft006.factory.DAOFactory;
import com.soft006.model.RP;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Admin on 2017/12/20.
 */
public class RPDAOTest {
    private RPDAO rpdao;

    @Before
    public void setUp() throws Exception {
        rpdao = DAOFactory.getRPDAOInstance();
    }

    @Test
    public void getALL() throws Exception {
        List<RP> rpList = rpdao.getALL();
       rpList.forEach(rp -> System.out.println(rp));
    }

}