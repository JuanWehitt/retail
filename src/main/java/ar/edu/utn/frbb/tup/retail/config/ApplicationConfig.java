package ar.edu.utn.frbb.tup.retail.config;

import ar.edu.utn.frbb.tup.retail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.retail.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.retail.business.impl.CategoriaBusinessImpl;
import ar.edu.utn.frbb.tup.retail.business.impl.ProductoBusinessImpl;
import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateProductoDto;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.ProductoDao;
import ar.edu.utn.frbb.tup.retail.persistence.dao.impl.InMemoryProductoDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
@ComponentScan({"ar.edu.utn.frbb.tup.retail.business"})
public class ApplicationConfig {

    @Bean
    public CategoriaBusiness categoriaBusiness(){
        return new CategoriaBusinessImpl();
    }

    @Bean
    public ProductoBusiness productoBusiness(){
        return new ProductoBusinessImpl();
    }

    @Bean
    public ProductoDao productoDao(){
        return new InMemoryProductoDao();
    }

}
