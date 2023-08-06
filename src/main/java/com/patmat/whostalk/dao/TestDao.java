package com.patmat.whostalk.dao;

import com.patmat.whostalk.vo.TestVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDao {
    @Autowired
    SqlSession sqlSession;

    public List<TestVo> selectTestData(){
        return sqlSession.selectList("com.patmat.whostalk.dao.TestDao.selectTestData");
    }
}

