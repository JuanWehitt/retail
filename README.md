# Ejercicio retail

Sistema de ventas tanto (online cómo presencial) para una casa de
artículos para el hogar y electrónica (cómo puede ser Frávega, Garbarino). A este tipo de
comercios o a este rubro se lo conoce cómo retail.

Este vende productos de Hogar y Electrónica, aunque también
incorpora productos de otras categorías. En la actualidad las categorías de productos que
maneja son las siguientes (aunque a futuro, podría agrandarse esta lista)

* Categorías:
    * TV Audio Video:
      * Televisores, cámaras de video, cámaras fotográficas, home theaters, minicomponentes, parlantes.
    * Electrodomésticos y climatización:
      *  licuadoras, cafeteras, lavarropas, pavas
         eléctricas, cocinas , termotanques, aires
         acondicionados, ventiladores, calefactores
    * Hogar y muebles:
      * colchones, almohadas, sillas, mesas,
        máquinas de cortar césped.
    * Informatica y electronica:
      * Notebooks, PC’s, monitores, impresoras,
        accesorios pc’s y notebooks, celulares,
        tablets, consolas de juegos
    * Salud y Aire Libre:
      * Bicicletas, bicicletas fijas, caminadores,
        carpas, conservadoras, mochilas.

Todos los productos que se comercializan caen en una de estas categorías, y en caso que
no se pueda categorizar (ej, neumáticos), deberán caer en una categoría ‘Otros’.
Al momento de que se carga un producto, se le asigna una categoría y el mismo es
agregado en la lista de productos de la categoría. Ej: si se crea un nuevo producto TV 24’’
Phillips el mismo se le asigna la categoría TV, audio y video, y en la lista de productos de
la misma debería figurar el TV 24’’ Phillips.

Las categorías, deberán proveer los siguientes métodos:

    ● Obtener todos los productos ordenados por precio (ascendente o descendente)

    ● Obtener los productos filtrando por marca

    ● Obtener productos filtrando por precio

Por supuesto, todos los productos comercializados tienen un código (alfanumérico), una
marca y un modelo. En esta fase del proyecto, el retail quiere contar también con una
descripción y una lista de especificaciones básicas para cada tipo de producto, por ejemplo
para Televisores indicará: tipo de pantalla, pulgadas, alto, ancho, peso, tipos y cantidad de
entradas (HDMI, USB, VGA),si es Smart TV, etc. Para una Bicicleta, indicará Rodado,
cantidad de cambios, tamaño del cuadro, color del cuadro, etc.

Se desea también contar información acerca de precios, en particular nuestro retail trabaja
con un Precio de Lista y Precio Contado (es el precio de lista con un descuento del 15%).
Algunos productos de nuestro retail estarán disponibles para venta online y otros no. Los
productos que sean vendibles online, tendrán un descuento especial que se aplicará al
momento de la compra. Este descuento es por cada producto, no como el precio contado
que se aplica a todos los productos. Por defecto, se considera que los productos no serán
comercializables en forma online.

Nuestro retail, quiere también ofrecer en los productos online, una lista de productos
relacionados, de esta manera, si consultamos una consola de video juegos, los productos
relacionados a la misma podrían ser auriculares gamers.
Existen algunos productos que son personalizables, por ejemplo compramos una notebook
y podríamos agregarle más memoria RAM o el SSD/HDD. Se deberá proveer la opción de
que al momento de dar de alta el producto, se indique que puede ser personalizable y
agregar una lista de características que puedan configurarse. Por ejemplo:

* Producto Notebook Lenovo ThinkPad T14
  * Posible configurar
    * “RAM”: [8GB, 16GB, 32GB]
    * “SSD”: [512B, 1TB, 2TB]
* Bicicleta Venzo R29
  * Posible de configurar
    * “Color del Cuadro” : [“Verde”, “Rojo”, “Amarilo”]

   
Tener en cuenta que la característica configurable de nuestro producto, debe ser una de las
    características de especificaciones del mismo.

Los productos deben proveer operaciones para:

    ● Obtener los precios de Lista y Precio de contado

    ● En el caso en que un producto sea comercializable en forma online, se deberá poder
    indicar qué descuento por compra online se le realiza y poder obtener ese precio

    ● Si el producto es configurable, se debe poder agregar la lista de Opciones de
    configuración

    ● Consultar la lista de opciones de configuración de un producto

    ● Consultar las especificaciones de un producto.
