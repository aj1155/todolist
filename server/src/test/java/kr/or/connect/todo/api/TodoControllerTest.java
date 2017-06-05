package kr.or.connect.todo.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


/**
 * Created by Manki Kim on 2017-06-03.
 * email : aj1155@naver.com
 * @프로그램 설명 : TodoController Test 코드
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class TodoControllerTest {

    @Autowired
    WebApplicationContext wac;
    MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = webAppContextSetup(this.wac)
                .alwaysDo(print(System.out))
                .build();
    }

    @Test
    public void shouldCreate() throws Exception {
        String requestBody = "{\"todo\":\"과제테스트\",\"completed\":\"0\"}";

        mvc.perform(
                post("/api/todos/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.todo").value("과제테스트"));
    }

    @Test
    public void shouldfindAll() throws Exception {
        MvcResult result = mvc.perform(get("/api/todos")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        log.debug("{}", result.getResponse().getContentAsString());
    }

    @Test
    public void shouldfindOne() throws Exception {
        MvcResult result = mvc.perform(get("/api/todos/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andReturn();
        log.debug("{}", result.getResponse().getContentAsString());
    }


    @Test
    public void shouldUpdate() throws Exception {
        String requestBody = "{\"todo\":\"기말고사\", \"completed\":\"1\"}";

        mvc.perform(
                put("/api/todos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        )
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldComplete() throws Exception {

        mvc.perform(
                put("/api/todos/complete/1")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDelete() throws Exception {
        mvc.perform(
                delete("/api/todos/1")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isNoContent());
    }
}
