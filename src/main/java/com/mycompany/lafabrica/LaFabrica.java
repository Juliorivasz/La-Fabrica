package com.mycompany.lafabrica;

import java.util.ArrayList;
import java.util.Scanner;
public class LaFabrica {

    static Scanner sc;
    public static void main(String[] args) {
        sc =  new Scanner(System.in);
        System.out.println("Bienvenido a la fabrica de Papas");
        int cantALlevar = 0;
        int codigoAIngresar = 0;
        String nombreProducto = "";
        boolean salida = false;
        while(salida != true) {
            mostrarProductos();
            System.out.println("Ingrese el código del producto a llevar");
            codigoAIngresar = sc.nextInt();
            sc.nextLine();
            switch (codigoAIngresar) {
                case 100:
                    nombreProducto = "Papas fritas";
                    cantALlevar = validarCantidad();
                    salida = encargarOtraCosa(cantALlevar);
                    break;
                case 101:
                    nombreProducto = "Papas al horno";
                    cantALlevar = validarCantidad();
                    salida = encargarOtraCosa(cantALlevar);
                    break;
                case 102:
                    nombreProducto = "Papas en cubo";
                    cantALlevar = validarCantidad();
                    salida = encargarOtraCosa(cantALlevar);
                    break;
                case 103:
                    nombreProducto = "Papas lays";
                    cantALlevar = validarCantidad();
                    salida = encargarOtraCosa(cantALlevar);
                    break;
                case 104:
                    nombreProducto = "Sorrentinos";
                    cantALlevar = validarCantidad();
                    salida = encargarOtraCosa(cantALlevar);
                    break;
                case 105:
                    nombreProducto = "Capeletini";
                    cantALlevar = validarCantidad();
                    salida = encargarOtraCosa(cantALlevar);
                    break;
                default:
                    System.out.println("Ingrese un codigo valido");
                    break;
                    
            }
            System.out.println("Nombre " + nombreProducto + ", codigo " + codigoAIngresar + " y cantidad " + cantALlevar);
        }
    }
    //Validamos que se ingrese el minimo pedido de los gramos (1000)
    public static int validarCantidad(){
        int cantidadALlevar;
        System.out.println("Ingrese en gramos la cantidad a preparar");
        System.out.println("Se pide como minimo 1000 gramos");
        while(true){
            cantidadALlevar = sc.nextInt();
            if(cantidadALlevar < 1000){
                System.out.println("La cantidad ingresada no supera el minimo permitido, ingrese nuevamente");
            }else{
                break;
            }
        }
        return cantidadALlevar;
    }
    //Saber si el usuario quiere o no otra cosa
    public static boolean encargarOtraCosa(int cantALlevar){
        boolean quiereOno = false;
        sc.nextLine();
        if(cantALlevar>1000){
            System.out.println("Desea comprar algo mas? Si o No");
            String salidaONo = sc.nextLine();
            quiereOno = !salidaONo.toLowerCase().equalsIgnoreCase("si");
        }
        return quiereOno;
    }
        //mostrar menu switch
        //ingrese el codigo del poducto a producir
        // codigo = 100
        //coloco 100 case 100: nombreProducto = "gnoquis";
        // ingrese la cantidad del producto en gramos
        //  cantidad = 2000
        // minimo de cantidad permitido
        // orden = new ordenProduccion(codigo, nombreProducto, cantidad)

        //ordenVeficada = orden.verificarOrden();
        // if(ordenVerificada){
        //  sout("preparando orden")
        // }
        // else {
        //  sout("orden Pendiente por falta materia prima")
        //  orden.producto.procesar_ordenes_pendientes()
        // }
    public static void mostrarProductos(){

        ArrayList<OrdenProduccion> mostrar = new ArrayList<>();
        // validar cantidad minima en la orden de produccion
        mostrar.add(new OrdenProduccion(100, "Gnoquis", 20));
        mostrar.add(new OrdenProduccion(101, "Fideos Rellenos", 30));
        mostrar.add(new OrdenProduccion(102, "Spaghetti", 50));
        mostrar.add(new OrdenProduccion(103, "Ravioles", 15));
        mostrar.add(new OrdenProduccion(104, "Sorrentinos", 28));
        mostrar.add(new OrdenProduccion(105, "Capeletini", 28));
        
        System.out.println("Codigo    Producto   ");
        System.out.println("---------------------");
        for (OrdenProduccion ordenProduccion : mostrar) {
            String codigoSrt = String.valueOf(ordenProduccion.getCodigo());
            System.out.println(ordenProduccion.getCodigo() + completaEspaciosBlanco(codigoSrt, 10) 
            + ordenProduccion.getProducto_a_fabricar() +  completaEspaciosBlanco(ordenProduccion.getProducto_a_fabricar(), 10));
        }
    }
    private static String completaEspaciosBlanco(String palabra, int longitud) {
            int espacios = longitud - palabra.length();
            StringBuilder espacioBlanco = new StringBuilder();
            while (espacios > 0) {
                espacioBlanco.append(" ");
                --espacios;
            }
            return espacioBlanco.toString();
    }
}

