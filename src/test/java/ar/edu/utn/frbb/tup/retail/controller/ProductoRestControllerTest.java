package ar.edu.utn.frbb.tup.retail.controller;

import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductoRestControllerTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc productoMvc;

    @Test
    public void crearProductoTest() throws Exception {
        AltaProductoDto productoDto = new AltaProductoDto("plancha","123","Electrodomesticos");
        productoMvc.perform(MockMvcRequestBuilders.post("/producto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(productoDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());

    }
}
