package com.patmat.whostalk.service;

import com.patmat.whostalk.dao.TestDao;
import com.patmat.whostalk.vo.TestVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestDao testDao;

    public TestService(TestDao testDao) {
        this.testDao = testDao;
    }

    public List<TestVo> getTestData(){
        return testDao.selectTestData();
    }

}
