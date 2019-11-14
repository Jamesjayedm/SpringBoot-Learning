package com.james.springbootaop.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * junit单元测试
 *
 * @Author yujie.pan
 * @Date 2019/11/13 14:51
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BasicControllerTest {

    @Autowired
    protected WebApplicationContext context;

    MockMvc mockMvc;
    MockHttpSession session;

    @Before
    public void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(MyController.class).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//        getLoginSession();
    }

    @Test
    public void doNothing() {
    }

    /**
     * 模拟用户登录，保存session
     */
    private void getLoginSession() {
        String url = "/system/login";
        MvcResult result = null;
        try {
            result = mockMvc.perform(
                    MockMvcRequestBuilders.post(url)
                            .param("userName", "yujie.pan")
                            .param("password", "123456"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert result != null;

        session = (MockHttpSession) result.getRequest().getSession();
    }

}
