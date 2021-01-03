package com.selendemir.finalproject.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.selendemir.finalproject.model.author.AuthorListResponse;
import com.selendemir.finalproject.model.author.AuthorSaveRequestModel;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AuthorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(0)
    void testAuthorSavePostRequest() throws Exception {
        AuthorSaveRequestModel authorSaveRequestModel = new AuthorSaveRequestModel();
        authorSaveRequestModel.setName("test");
        MockHttpServletRequestBuilder content = post("/authors")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(authorSaveRequestModel));
        mockMvc.perform(content)
                .andExpect(status().isOk());

    }

    @Test
    void testGetAuthorByIdRequestWithExistUser() throws Exception {
        mockMvc.perform(get("/authors/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAuthorByIdRequestWithNoExistUser() throws Exception {
        mockMvc.perform(get("/authors/0"))
                .andExpect(status().isNotFound());
    }

    @Test
    void  testGetAllAuthors() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/authors"))
                .andExpect((status().isOk()))
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        AuthorListResponse authorListResponse = objectMapper.readValue(contentAsString, AuthorListResponse.class);
        Assert.assertTrue(authorListResponse.getAuthors().size() > 0);
    }
}
