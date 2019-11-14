package com.james.springbootaop.controller;


import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Author yujie.pan
 * @Date 2019/11/13 14:49
 **/
public class MyControllerTest extends BasicControllerTest {

    @Test
    public void MyTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                // form表单格式传参
                .param("id", "1")
                .param("name", "yujie.pan")
                .param("age", "22")
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON_VALUE)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("code").value("200"))
                .andDo(MockMvcResultHandlers.print());
    }
}
