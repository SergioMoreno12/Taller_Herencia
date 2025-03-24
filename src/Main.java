import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op;
        int estado = 1;

        List<Vehiculo> listVehiculos = new ArrayList<>();
        List<Cliente> listClientes = new ArrayList<>();

        do{
            System.out.println("""
                    |==========================================|
                    |                  Menú                    |
                    |==========================================|
                    | 1 | Registrar auto                       |
                    | 2 | Registrar camioneta                  |
                    | 3 | Registrar cliente                    |
                    | 4 | Realizar alquiler                    |
                    | 5 | Mostrar vehículos disponibles        |
                    | 6 | Devolver vehículo                    |
                    | 7 | Salir                                |
                    |==========================================|
                    Seleccione una opción:
                    """);
            op= teclado.nextInt();
            teclado.nextLine();
            switch (op){
                case 1 -> {

                    System.out.println("----------Registrar auto----------");
                    System.out.println("Ingrese la marca: ");
                    String marca = teclado.nextLine();
                    System.out.println("Ingrese el modelo: ");
                    String modelo = teclado.nextLine();
                    System.out.println("Ingrese el año: ");
                    int ano = teclado.nextInt();
                    System.out.println("Ingrese el precio por dia: ");
                    double precioPorDia = teclado.nextDouble();
                    teclado.nextLine();
                    System.out.println("Ingrese el numero de puertas: ");
                    int numeroPuertas = teclado.nextInt();
                    listVehiculos.add(new Auto(marca, modelo, ano, precioPorDia, numeroPuertas));
                    System.out.println("¡Vehículo registrado exitosamente!");
                    System.out.println("----------------------------------");

                    do{
                        System.out.println("Presione 1 para continuar");
                        estado = teclado.nextInt();
                        if (estado != 1) {
                            System.out.println("Opción incorrecta");
                        }
                    }while (estado!= 1);

                }
                case 2 -> {

                    System.out.println("----------Registrar camioneta----------");
                    System.out.println("Ingrese la marca: ");
                    String marca = teclado.nextLine();
                    System.out.println("Ingrese el modelo: ");
                    String modelo = teclado.nextLine();
                    System.out.println("Ingrese el año: ");
                    int ano = teclado.nextInt();
                    System.out.println("Ingrese el precio por dia: ");
                    double precioPorDia = teclado.nextDouble();
                    teclado.nextLine();
                    System.out.println("Ingrese la capacidad de carga: ");
                    double capacidadCarga = teclado.nextDouble();
                    teclado.nextLine();
                    listVehiculos.add(new Camioneta(marca, modelo, ano, precioPorDia, capacidadCarga));
                    System.out.println("¡Vehículo registrado exitosamente!");
                    System.out.println("----------------------------------");

                    do{
                        System.out.println("Presione 1 para continuar");
                        estado = teclado.nextInt();
                        if (estado != 1) {
                            System.out.println("Opción incorrecta");
                        }
                    }while (estado!= 1);

                }
                case 3 -> {

                    System.out.println("----------Registrar cliente----------");
                    System.out.println("Ingrese nombre: ");
                    String nombre = teclado.nextLine();
                    System.out.println("Ingrese cédula: ");
                    String cedula = teclado.nextLine();
                    System.out.println("Ingrese numero de licencia: ");
                    String numeroLicencia = teclado.nextLine();
                    listClientes.add(new Cliente(nombre, cedula, numeroLicencia));
                    System.out.println("¡Cliente registrado exitosamente!");
                    System.out.println("----------------------------------");

                    do{
                        System.out.println("Presione 1 para continuar");
                        estado = teclado.nextInt();
                        if (estado != 1) {
                            System.out.println("Opción incorrecta");
                        }
                    }while (estado!= 1);

                }
                case 4 -> {

                    System.out.println("----------Realizar alquiler----------");
                    System.out.println("Ingrese nombre de quien va a realizar el alquiler: ");
                    String nombreCliente = teclado.nextLine();
                    int encontradoCliente = 0;
                    Cliente clienteAlquiler = null;

                    for (Cliente cliente : listClientes) {
                        if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                            encontradoCliente = 1;
                            clienteAlquiler = cliente;
                        }
                    }

                    switch (encontradoCliente){
                        case 0 -> {

                            System.out.println("No esta registrado, regístrese primero");

                            do{
                                System.out.println("Presione 1 para continuar");
                                estado = teclado.nextInt();
                                if (estado != 1) {
                                    System.out.println("Opción incorrecta");
                                }
                            }while (estado!= 1);

                        }
                        case 1 -> {

                            System.out.println("Vehículos disponibles para alquilar: ");
                            System.out.println("------------------------------------");
                            int contador = 1;
                            for (Vehiculo vehiculo : listVehiculos) {
                                if (vehiculo.isEstado()) {
                                    System.out.println("Vehiculo " + contador);
                                    vehiculo.mostrarInfo();
                                    System.out.println("------------------------------------");
                                }
                                contador++;
                            }

                            System.out.println("Ingrese el modelo del vehículo a alquilar: ");
                            String modeloVehiculo = teclado.nextLine();
                            int encontradoVehiculo = 0;
                            Vehiculo vehiculoAlquiler = null;

                            for (Vehiculo vehiculo : listVehiculos) {
                                if (vehiculo.getModelo().equalsIgnoreCase(modeloVehiculo) && vehiculo.isEstado()) {
                                    encontradoVehiculo = 1;
                                    vehiculoAlquiler = vehiculo;
                                }
                            }

                            switch (encontradoVehiculo){
                                case 0 -> {

                                    System.out.println("Vehículo no disponible o no encontrado");

                                    do{
                                        System.out.println("Presione 1 para continuar");
                                        estado = teclado.nextInt();
                                        if (estado != 1) {
                                            System.out.println("Opción incorrecta");
                                        }
                                    }while (estado!= 1);

                                }
                                case 1 ->{

                                    System.out.println("Ingrese la cantidad de días de alquiler: ");
                                    int dias = teclado.nextInt();
                                    teclado.nextLine();
                                    double costo = vehiculoAlquiler.calcularCosto(dias);
                                    vehiculoAlquiler.alquilar();
                                    vehiculoAlquiler.setCliente(clienteAlquiler);
                                    System.out.println("¡Alquiler realizado con éxito!");
                                    System.out.println("Costo total del alquiler: " + costo);
                                    System.out.println("Vehículo alquilado a: " + clienteAlquiler.getNombre());

                                    do{
                                        System.out.println("Presione 1 para continuar");
                                        estado = teclado.nextInt();
                                        if (estado != 1) {
                                            System.out.println("Opción incorrecta");
                                        }
                                    }while (estado!= 1);

                                }
                            }

                        }
                    }

                }
                case 5 -> {

                    System.out.println("----------Vehículos disponibles----------");
                    int contador = 1;
                    System.out.println("------------------------------------");
                    for (Vehiculo vehiculo : listVehiculos) {
                        if (vehiculo.isEstado()) {
                            System.out.println("Vehiculo " + contador);
                            vehiculo.mostrarInfo();
                            System.out.println("------------------------------------");
                        }
                        contador++;
                    }

                    do{
                        System.out.println("Presione 1 para continuar");
                        estado = teclado.nextInt();
                        if (estado != 1) {
                            System.out.println("Opción incorrecta");
                        }
                    }while (estado!= 1);

                }
                case 6 -> {

                    System.out.println("----------Devolver vehículo----------");
                    System.out.println("Ingrese el modelo del vehículo a devolver: ");
                    String modeloVehiculo = teclado.nextLine();
                    for (Vehiculo vehiculo : listVehiculos) {
                        if (vehiculo.getModelo().equalsIgnoreCase(modeloVehiculo) && !vehiculo.isEstado()) {
                            vehiculo.devolver();
                            vehiculo.setCliente(null);
                            System.out.println("Vehículo devuelto exitosamente");
                        }
                    }

                    do{
                        System.out.println("Presione 1 para continuar");
                        estado = teclado.nextInt();
                        if (estado != 1) {
                            System.out.println("Opción incorrecta");
                        }
                    }while (estado!= 1);

                }
                case 7 -> {

                    System.out.println("Saliendo...");
                    estado = 2;

                }
                default -> System.out.println("Opción no válida");
            }
        }while(estado == 1);
    }
}