package ar.edu.utn.frbb.tup.retail.persistence.dao.impl;

import ar.edu.utn.frbb.tup.retail.exception.ExceptionCategoriaRelacionada;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.CategoriaDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

@Component
public class InMemoryCategoriaDao implements CategoriaDao {
    private List<Categoria> categoriasList = new ArrayList<>();

    public InMemoryCategoriaDao() {
        //System.out.println("creo un InMemoryCategoriaDao()");
        if (this.findAll().size()==0){
            crearCategorias();
        }
    }

    private void crearCategorias(){
        Categoria categoria_tv = new Categoria();

        //AltaCategoriaDto dto = new AltaCategoriaDto();
        ArrayList<String> tipos;
        categoria_tv.setNombre("TV,Audio y Video");
        categoria_tv.setDescripcion("Categoria que almacena productos multimedia");
        String cadena = "televisores,cámaras de video,cámaras fotográficas,home theaters,minicomponentes,parlantes";
        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
        categoria_tv.setTipos(tipos);
        //System.out.println(categoria_tv.getTipos());
        this.save(categoria_tv);

        Categoria categoria_electrodomesticos = new Categoria();
        categoria_electrodomesticos.setNombre("Electrodomésticos y climatización");
        categoria_electrodomesticos.setDescripcion("Categoria que almacena productos electrodomesticos");
        cadena = "licuadoras,cafeteras,lavarropas,pavas " +
                "eléctricas,cocinas,termotanques,aires " +
                "acondicionados,ventiladores,calefactores";
        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
        categoria_electrodomesticos.setTipos(tipos);
        this.save(categoria_electrodomesticos);
        //
        Categoria categoria_hogar = new Categoria();
        categoria_hogar.setNombre("Hogar y muebles");
        categoria_hogar.setDescripcion("Categoria que almacena productos electrodomesticos");
        cadena = "colchones,almohadas,sillas,mesas," +
                "máquinas de cortar césped";
        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
        categoria_hogar.setTipos(tipos);
        this.save(categoria_hogar);
        //
        Categoria categoria_informatica = new Categoria();
        categoria_informatica.setNombre("Informática y electrónica");
        categoria_informatica.setDescripcion("Categoria que almacena productos de informatica y electroncia");
        cadena = "notebooks,PC’s,monitores,impresoras," +
                "accesorios pc’s y notebooks,celulares," +
                "tablets,consolas de juegos";
        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
        categoria_informatica.setTipos(tipos);
        this.save(categoria_informatica);
        //
        Categoria categoria_salud = new Categoria();
        categoria_salud.setNombre("Salud y Aire libre");
        categoria_salud.setDescripcion("Categoria que almacena productos de Salud y Aire libre ");
        cadena = "bicicletas,bicicletas fijas,caminadores," +
                "carpas,conservadoras,mochilas";
        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
        categoria_salud.setTipos(tipos);
        this.save(categoria_salud);
        //
        Categoria categoria_otros = new Categoria();
        categoria_otros.setNombre("Otros");
        categoria_otros.setDescripcion("Categoria que almacena productos sin categoria");
        cadena = "";
        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
        categoria_otros.setTipos(tipos);
        this.save(categoria_otros);

    }

    @Override
    public Categoria save(Categoria categoria) {
        categoriasList.add(categoria);
        return categoria;
    }

    @Override
    public Categoria updateCategoria(Categoria categoria) {
        return categoria;
    }

    @Override
    public boolean deleteCategoria(Categoria categoria) throws ExceptionCategoriaRelacionada{
        if (categoriasList.get(categoriasList.indexOf(categoria)).getProductos().size()!=0){
            throw new ExceptionCategoriaRelacionada("La categoria contiene productos asociados");
        }else {
            return categoriasList.remove(categoria);
        }
    }

    @Override
    public Categoria findCategoria(String nombre) {
        Categoria encontrada = null;
        for (Categoria c: categoriasList){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                encontrada = c;
                System.out.println("Encontro categoria "+nombre);
            }
        }
        return encontrada;
    }

    @Override
    public List<Categoria> findAll() {
        return categoriasList;
    }

    @Override
    public Categoria findCategoriaPorTipo(String tipo) {
        for( Categoria cat : categoriasList){
            if (cat.getTipos().contains(tipo.toLowerCase())){
                return cat;
            }
        }
        return findCategoria("otros");
    }
}
