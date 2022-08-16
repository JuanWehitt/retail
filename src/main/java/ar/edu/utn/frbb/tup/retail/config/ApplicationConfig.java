package ar.edu.utn.frbb.tup.retail.config;

import ar.edu.utn.frbb.tup.retail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.retail.business.impl.CategoriaBusinessImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ar.edu.utn.frbb.tup.retail.business"})
public class ApplicationConfig {

    @Bean
    public CategoriaBusiness categoriaBusiness(){
        return new CategoriaBusinessImpl();
    }

}
