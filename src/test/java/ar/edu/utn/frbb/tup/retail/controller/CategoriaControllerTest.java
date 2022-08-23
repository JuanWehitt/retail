package ar.edu.utn.frbb.tup.retail.controller;

import ar.edu.utn.frbb.tup.retail.dto.AltaCategoriaDto;
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
public class CategoriaControllerTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc categoriaMvc;

    @Test
    public void crearCategoriaTest() throws Exception {
        AltaCategoriaDto categoriaDto = new AltaCategoriaDto("Electrodomesticos");
        categoriaMvc.perform(MockMvcRequestBuilders.post("/categoria")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(categoriaDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());

    }
}
