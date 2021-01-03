package com.selendemir.finalproject.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.selendemir.finalproject.model.book.BookListResponse;
import com.selendemir.finalproject.model.book.BookSaveRequestModel;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Arrays;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest()
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    void testBookSavePostRequest() throws Exception {
        BookSaveRequestModel bookSaveRequestModel = new BookSaveRequestModel();
        bookSaveRequestModel.setName("ateş");
        bookSaveRequestModel.setAuthorIds(Arrays.asList(1,2,3));
        bookSaveRequestModel.setDescription("daha");
        bookSaveRequestModel.setPublicationDate(new Date());
        MockHttpServletRequestBuilder content = post("/books")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(bookSaveRequestModel));
        mockMvc.perform(content)
                .andExpect(status().isOk());
    }

    @Order(5)
    @Test
    void testGetBookDetailByIdWithExistBook() throws Exception {
        mockMvc.perform(get("/books/1"))
        .andExpect(status().isOk());
    }
    @Order(4)
    @Test
    void testGetBookDetailByIdWithoutExistingId() throws Exception {
        mockMvc.perform(get("/books/0"))
                .andExpect(status().isNotFound());
    }

    @Order(3)
    @Test
    void testGetAllBooks() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/books"))
                .andExpect((status().isOk()))
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        BookListResponse bookListResponse = objectMapper.readValue(contentAsString, BookListResponse.class);
        Assert.assertTrue(bookListResponse.getBooks().size() > 0);
    }

    @Order(10)
    @Test
    void testSearchBook() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/books/search?name=ateş"))
                .andExpect((status().isOk()))
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        BookListResponse bookListResponse = objectMapper.readValue(contentAsString, BookListResponse.class);
        Assert.assertTrue(bookListResponse.getBooks().size() > 0);
    }


}
