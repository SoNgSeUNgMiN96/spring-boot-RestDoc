package pickMovie.pickMovieback.repository;

import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runner.RunWith;


import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import com.google.gson.GsonBuilder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


import static org.junit.Assert.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class ItrmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Description("RestDoc Test")
    public void saveTodoMngAct() throws Exception {

        MultiValueMap<String, String> info = new LinkedMultiValueMap<>();

        info.add("name", "칩");
        info.add("id", "chip");



        //TodoMngAct todoMngAct = new TodoMngAct(param);
        //todoMngAct.setUPDATE_DT(LocalDateTime.now());

        mockMvc.perform(
                        get("/blog")
                                .params(info))
                                .andExpect(status().isOk())
                                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("itrm/{method-name}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())
                        /*requestFields(
                                fieldWithPath("TODO_ID").description("TODO ID"),
                                fieldWithPath("TODO_DT").description("ITRM수행 일자"),
                                fieldWithPath("DESCRIPTION").description("점검 결과 기록"),
                                fieldWithPath("PROGRESS").description("성공이면 S, 실패면 NULL")
                        )*/)

                );
    }

}
