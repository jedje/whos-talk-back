package com.patmat.whostalk.controller;

import com.patmat.whostalk.service.TestService;
import com.patmat.whostalk.vo.TestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nonapi.io.github.classgraph.utils.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"Sample API List"})
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/test")
    @ApiOperation(value = "테스트 API", response = Join.class)
    public List<TestVo> getTestData() {
        return testService.getTestData();
    }


}
