package com.uma.example.springuma.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uma.example.springuma.integration.base.AbstractIntegration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
public class HelloControllerIT extends AbstractIntegration{
    
    
	@Autowired
	private MockMvc mockMvc;

    @Test
    @DisplayName("Get correct hello string from Hello controller")
	void hello_ReturnHelloString() throws Exception {
		this.mockMvc.perform(get("/hello"))
        .andDo(print())
        .andExpect(status().isOk())
		.andExpect(content()
            .string(containsString("Infraestructuras y Procesos de Soporte")));
	}

    @Test
    void testHelloWithParam() throws Exception {
        mockMvc.perform(get("/nombre")
                .param("name", "Cristian"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hola alumno Cristian!"));
    }

    @Test
    void testGetWithPathVariable() throws Exception {
        mockMvc.perform(get("/nombre/Cristian"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hola alumno has pasado el path Cristian!"));
    }
}
