package com.mindhaq.spring_gateway_mvc_formfilter_bugreport

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(SimpleFormController::class)
class SimpleFormControllerTest{
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should return greeting`() {
        mockMvc.perform(post("/form")
            .param("name", "Alice"))
            .andExpect(status().isOk)
            .andExpect(content().string("Hello, Alice!"))
    }

    @Test
    fun `should return 400 when POSTing no data`() {
        mockMvc.perform(post("/form"))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `should return 400 when POSTing data without name`() {
        mockMvc.perform(post("/form")
            .param("foo", "bar"))
            .andExpect(status().isBadRequest)
    }
}
