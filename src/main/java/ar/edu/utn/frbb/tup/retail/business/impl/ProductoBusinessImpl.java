package ar.edu.utn.frbb.tup.retail.business.impl;

import ar.edu.utn.frbb.tup.retail.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.retail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateEspecificacionesProductoDto;
import ar.edu.utn.frbb.tup.retail.dto.UpdateProductoDto;
import ar.edu.utn.frbb.tup.retail.model.Categoria;
import ar.edu.utn.frbb.tup.retail.model.Configuracion;
import ar.edu.utn.frbb.tup.retail.model.Producto;
import ar.edu.utn.frbb.tup.retail.persistence.dao.CategoriaDao;
import ar.edu.utn.frbb.tup.retail.persistence.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class ProductoBusinessImpl implements ProductoBusiness {

    @Autowired
    ProductoDao productoDao;

    @Autowired
    CategoriaDao categoriaDao;

    @Override
    public Producto altaProducto(AltaProductoDto dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setCodigo(dto.getCodigo());
        producto.setTipo(dto.getTipo());
        if (categoriaDao.findAll().size()==0){
            crearCategorias();
        }
        Categoria categoria = categoriaDao.findCategoriaPorTipo(dto.getTipo());
        producto.setCategoria(categoria.getNombre());
        categoria.agregarProducto(producto);
        categoriaDao.save(categoria);
        productoDao.save(producto);
        return producto;
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
        System.out.println(categoria_tv.getTipos());
        categoriaDao.save(categoria_tv);

        Categoria categoria_electrodomesticos = new Categoria();
        categoria_electrodomesticos.setNombre("Electrodomésticos y climatización");
        categoria_electrodomesticos.setDescripcion("Categoria que almacena productos electrodomesticos");
        cadena = "licuadoras,cafeteras,lavarropas,pavas" +
                "eléctricas,cocinas,termotanques,aires" +
                "acondicionados,ventiladores,calefactores";
        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
        categoria_electrodomesticos.setTipos(tipos);
        categoriaDao.save(categoria_electrodomesticos);
        //
        Categoria categoria_hogar = new Categoria();
        categoria_hogar.setNombre("Hogar y muebles");
        categoria_hogar.setDescripcion("Categoria que almacena productos electrodomesticos");
        cadena = "colchones,almohadas,sillas,mesas," +
                "máquinas de cortar césped";
        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
        categoria_hogar.setTipos(tipos);
        categoriaDao.save(categoria_hogar);
        //
        Categoria categoria_informatica = new Categoria();
        categoria_informatica.setNombre("Informática y electrónica");
        categoria_informatica.setDescripcion("Categoria que almacena productos de informatica y electroncia");
        cadena = "notebooks,PC’s,monitores,impresoras," +
                "accesorios pc’s y notebooks,celulares," +
                "tablets,consolas de juegos";
        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
        categoria_informatica.setTipos(tipos);
        categoriaDao.save(categoria_informatica);
        //
        Categoria categoria_salud = new Categoria();
        categoria_salud.setNombre("Salud y Aire libre ");
        categoria_salud.setDescripcion("Categoria que almacena productos de Salud y Aire libre ");
        cadena = "bicicletas,bicicletas fijas,caminadores," +
                "carpas,conservadoras,mochilas";
        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
        categoria_salud.setTipos(tipos);
        categoriaDao.save(categoria_salud);
        //
        Categoria categoria_otros = new Categoria();
        categoria_otros.setNombre("Otros");
        categoria_otros.setDescripcion("Categoria que almacena productos sin categoria");
        cadena = "";
        tipos =  new ArrayList<>(Arrays.asList(cadena.split(",")));
        categoria_otros.setTipos(tipos);
        categoriaDao.save(categoria_otros);

    }

    public Producto getProducto(String codigo) {
        Producto producto = null;
        producto = productoDao.findProducto(codigo);
        return producto;
    }

    @Override
    public Producto updateProducto(UpdateProductoDto dto, String codigo) {
        Producto producto = productoDao.findProducto(codigo);
        if (producto!=null) {
            producto.setNombre(dto.getNombre());
            producto.setDescripcion(dto.getDescripcion());
            producto.setMarca(dto.getMarca());
            producto.setModelo(dto.getModelo());
            producto.setPrecioDeLista(dto.getPrecioDeLista());
            if (!producto.getTipo().equals(dto.getTipo())){
                //asociar categoria
                Categoria categoriaNueva = categoriaDao.findCategoriaPorTipo(dto.getTipo());
                categoriaNueva.agregarProducto(producto);
                producto.setCategoria(categoriaNueva.getNombre());
            }


            producto.setEspecificaciones(dto.getEspecificaciones());
            producto.setOn_line(dto.isOn_line());
            producto.setPrecioOnLine(dto.getPrecioOnline());
            producto.setTipo(dto.getTipo());
            dto.getConfiguraciones().forEach(conf -> producto.agregarConfiguracion(new Configuracion(conf,dto.getTipo())));
            productoDao.updateProducto(producto);
        }
        return producto;
    }

    @Override
    public ArrayList<Producto> getProductos() {
        return productoDao.findAll();
    }

    @Override
    public boolean deleteProducto(Producto producto) {
        return productoDao.deleteProducto(producto);
    }

    @Override
    public void relacionarProductos(String cod_producto1, String cod_producto2) {
        productoDao.relationProduct(cod_producto1, cod_producto2);
    }

    @Override
    public Producto updateEspecificacionesProducto(UpdateEspecificacionesProductoDto dto, String codigo) {
        return null;
    }

}
