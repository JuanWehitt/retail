package ar.edu.utn.frbb.tup.retail.controller;

import ar.edu.utn.frbb.tup.retail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.retail.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.retail.business.impl.ProductoBusinessImpl;
import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateProductoDto;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductoRestControllerTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc productoMvc;

    @Test
    public void test_crearProducto() throws Exception {
        AltaProductoDto productoDto = new AltaProductoDto("plancha","Electrodomesticos");
        productoMvc.perform(MockMvcRequestBuilders.post("/producto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(productoDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());

    }
    @Test
    public void test_getProductos_NotFound() throws Exception {
        productoMvc.perform(MockMvcRequestBuilders.get("/productos")
                //.contentType(MediaType.APPLICATION_JSON)
                //.content(mapper.writeValueAsString(empleadoDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }
    @Test
    public void test_getProductoNotFound() throws Exception {
        productoMvc.perform(MockMvcRequestBuilders.get("/producto/{codigo}","AA232")
                .contentType(MediaType.APPLICATION_JSON)
                //.content(mapper.writeValueAsString(nombre))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }


}
