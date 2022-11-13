package ar.edu.utn.frbb.tup.retail.controller;

import ar.edu.utn.frbb.tup.retail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateCategoriaDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CategoriaRestControllerTest {

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

    @Test
    public void test_getCategorias() throws Exception {
        categoriaMvc.perform(MockMvcRequestBuilders.get("/categorias")
                .contentType(MediaType.APPLICATION_JSON)
                //.content(mapper.writeValueAsString(empleadoDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void test_getCategoria() throws Exception {
        categoriaMvc.perform(MockMvcRequestBuilders.get("/categoria/{nombre}","otros")
                .contentType(MediaType.APPLICATION_JSON)
                //.content(mapper.writeValueAsString(nombre))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
    }

    @Test
    public  void test_updateCategoria() throws Exception {
        UpdateCategoriaDto categoriaDto = new UpdateCategoriaDto();
        categoriaDto.setNombre("otros");
        categoriaDto.setDescripcion("Categoria de otros");
        categoriaDto.setTipos(new ArrayList<>());
        categoriaMvc.perform(MockMvcRequestBuilders.put("/categoria/{nombre}","otros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(categoriaDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());

    }

    @Test
    public void test_deleteCategoria() throws Exception {
        categoriaMvc.perform(MockMvcRequestBuilders.delete("/categoria/{nombre}","otros")
                .contentType(MediaType.APPLICATION_JSON)
                //.content(mapper.writeValueAsString(categoriaDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
    }

    @Test public void test_getProductosOrder_price() throws Exception {
        categoriaMvc.perform(MockMvcRequestBuilders.get("/categoria")
                .contentType(MediaType.APPLICATION_JSON)
                                .param("categoria","otros")
                                .param("order_price","asc")
                //.content(mapper.writeValueAsString(empleadoDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
    }

    @Test public void test_getProductos_orderPrice() throws Exception {
        categoriaMvc.perform(MockMvcRequestBuilders.get("/categoria")
                .contentType(MediaType.APPLICATION_JSON)
                .param("categoria","otros")
                .param("order_price","asc")
                //.content(mapper.writeValueAsString(empleadoDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
    }
    @Test public void test_getProductos_marca() throws Exception {
        categoriaMvc.perform(MockMvcRequestBuilders.get("/categoria")
                .contentType(MediaType.APPLICATION_JSON)
                .param("categoria","otros")
                .param("marca","Samsung")
                //.content(mapper.writeValueAsString(empleadoDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
    }
    @Test public void test_getProductos_PrecioMax_min() throws Exception {
        categoriaMvc.perform(MockMvcRequestBuilders.get("/categoria")
                .contentType(MediaType.APPLICATION_JSON)
                .param("categoria","otros")
                .param("precio_min","10.0")
                .param("precio_max","19.0")
                //.content(mapper.writeValueAsString(empleadoDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
    }

}
