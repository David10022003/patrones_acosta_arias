/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patrones_arias_acosta;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class Compañia {
    
    private CatalogoProductos productos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Proveedor> proveedores;
    private String nombre;
    private String nit;
    private String direccion;
    
    

    public Compañia(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        productos = CatalogoProductos.instance();
        clientes = new ArrayList();
        proveedores = new ArrayList();
    }

    public CatalogoProductos getProductos() {
        return productos;
    }

    public void setProductos(CatalogoProductos productos) {
        this.productos = productos;
    }

    

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        
        
        System.out.println("Cómo desea operar?"
                + "\n1. Cliente"
                + "\n2. Proveedor");
        
        int opcion = in.nextInt();
        
        in.nextLine();
        
        switch (opcion){
            case 1:
                String[] datosCl = new String[5];
                System.out.println("Ingrese su nombre, id, direccion, telefono y saldo separados por un espacio");
                datosCl = in.nextLine().split(" ");
                Cliente cliente = new Cliente(datosCl[0], datosCl[1], datosCl[2], Integer.parseInt(datosCl[3]), Double.parseDouble(datosCl[4]));
                System.out.println("Qué desea hacer?"
                        + "\n1. Buscar producto por palabra clave (categoría)"
                        + "\n2. Pagar"
                        + "\n3. Gestionar carrito de compras"
                        + "\n4. Consultar listado de productos");
                switch (in.nextInt()){
                    case 1:
                        System.out.println("Ingrese la categoría a buscar");
                        String categoria = in.nextLine();
                        System.out.println("Los productos encontrados son: " + cliente.buscarProductosCategoria(categoria) 
                                + "\nDesea mostrar los detalles de los productos?"
                                        + "\n1. Si"
                                        + "\n2. No");
                        switch(in.nextInt()){
                            case 1:
                                for(Producto p : cliente.buscarProductosCategoria(categoria))
                                    System.out.println(p.toString());
                            break;
                            default:
                                System.out.println("opción inválida");
                        }
                    break;
                    case 2:
                        if(cliente.pagar(cliente.getSaldo(), cliente.getCarrito().getValorTotal()) == true){
                            System.out.println("Su compra ha sido exitosa");
                        }
                        else
                            System.out.println("Su compra fue rechazada");
                    break;
                    case 3:
                        System.out.println("Qué desea hacer?"
                                + "\n1. Agregar producto al carrito"
                                + "\n2. Retirar producto del carrito"
                                + "\n3. Cambiar cantidad de productos agreados"
                                + "\n4. Consultar el valor total del carrito");
                        switch(in.nextInt()){
                            case 1:
                                System.out.println("Ingrese el nombre del producto que desea agregar");
                                cliente.agregarProductos(cliente.buscarProductoNombre(in.nextLine()).get(0));
                            break;
                            case 2:
                                System.out.println("Ingrese el nombre del producto que desea retirar");
                                cliente.retirarProductos(cliente.buscarProductoNombre(in.nextLine()).get(0));
                            break;
                            case 3:
                                System.out.println("Ingrese el nombre del producto del cual desde cambiar su cantidad");
                                String nombre = in.nextLine();
                                System.out.println("Ingrese la nueva cantidad");
                                cliente.cambiarCantidad(cliente.buscarProductoNombre(nombre).get(0), in.nextInt());
                            break;
                            case 4:
                                System.out.println("El valor total del carrito es: " + cliente.getCarrito().getValorTotal());
                            break;
                            default:
                                System.out.println("opción inválida");
                            break;
                        }
                    break;
                    case 4:
                        System.out.println("El listado de productos es: " + cliente.getProductos().getProductos());
                    break;
                }
            break;
            case 2:
                String[] datosPv = new String[5];
                System.out.println("Ingrese su nombre, id, direccion, telefono y saldo separados por un espacio");
                datosPv = in.nextLine().split(" ");
                Proveedor proveedor = new Proveedor(datosPv[0], datosPv[1], datosPv[2], Integer.parseInt(datosPv[3]));
                System.out.println("Qué desea hacer?"
                        + "\n1. Buscar producto por palabra categoría"
                        + "\n1. Buscar producto por nombre"
                        + "\n2. Gestionar productos"
                        + "\n4. Consultar estadisticas");
                switch (in.nextInt()){
                    case 1:
                        System.out.println("Ingrese la categoría a buscar");
                        String categoria = in.nextLine();
                        System.out.println("Los productos encontrados son: " + proveedor.buscarProductosCategoria(categoria) 
                                + "\nDesea mostrar los detalles de los productos?"
                                        + "\n1. Si"
                                        + "\n2. No");
                        switch(in.nextInt()){
                            case 1:
                                for(Producto p : proveedor.buscarProductosCategoria(categoria))
                                    System.out.println(p.toString());
                            break;
                            default:
                                System.out.println("opción inválida");
                        }
                    break;
                    case 2:
                        System.out.println("Ingrese el nombre del producto: ");
                        System.out.println(proveedor.buscarProductosNombre(in.nextLine()));
                    break;
                    case 3:
                        System.out.println("Qué desea hacer?"
                                + "\n1. Agregar producto"
                                + "\n2. Retirar producto" 
                                + "\n3. Cambiar cantidad de productos agreados");
                        switch(in.nextInt()){
                            case 1:
                                System.out.println("Ingrese los datos del producto(nombre, precio, cantidad, Proveedor vendedor))");
                                String []salida = in.nextLine().split(" ");
                                proveedor.adicionarProducto(new Producto(salida[0], Double.parseDouble(salida[1]), Integer.parseInt(salida[2]), proveedor));
                            break;
                            case 2:
                                System.out.println("Ingrese el nombre del producto que desea retirar");
                                proveedor.retirarProducto(proveedor.buscarProductosNombre(in.nextLine()).get(0));
                            break;
                            case 3:
                                System.out.println("Ingrese el nombre del producto del cual desde cambiar su cantidad");
                                String nombre = in.nextLine();
                                System.out.println("Ingrese la nueva cantidad");
                                proveedor.actualizarProducto(proveedor.buscarProductosNombre(nombre).get(0), proveedor.buscarProductosNombre(nombre).get(0));
                            break;
                            default:
                                System.out.println("opción inválida");
                            break;
                        }
                    break;
                    case 4:
                        System.out.println("Ingrese el nombre del producto para consultar sus estadisticas");
                        System.out.println(proveedor.consultarEstadiscticas(proveedor.buscarProductosNombre(in.nextLine()).get(0)));
                    break;
                } 
            break;
                
                       

        }
        
    }
    
}
