package co.edu.uptc.runner;

import co.edu.uptc.model.Customer;
import co.edu.uptc.model.Product;
import co.edu.uptc.model.Shipping;

import co.edu.uptc.persistence.CustomerSerializer;
import co.edu.uptc.persistence.CustomerDeserializer;
import co.edu.uptc.persistence.CustomerJsonWriter;

import co.edu.uptc.persistence.ProductSerializer;
import co.edu.uptc.persistence.ProductDeserializer;
import co.edu.uptc.persistence.ProductJsonWriter;
import co.edu.uptc.persistence.ProductJsonReader;

import co.edu.uptc.persistence.ShippingSerializer;
import co.edu.uptc.persistence.ShippingDeserializer;
import co.edu.uptc.persistence.ShippingJsonWriter;
import co.edu.uptc.persistence.ShippingJsonReader;
import co.edu.uptc.persistence.ShippingXmlToJsonConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("Seleccione la entidad:");
            System.out.println("1. Product");
            System.out.println("2. Customer");
            System.out.println("3. Shipping");
            System.out.println("4. Salir");

            int entityOption = scanner.nextInt();
            scanner.nextLine();  // Consumir salto de línea

            switch (entityOption) {
                case 1 -> handleProduct();
                case 2 -> handleCustomer();
                case 3 -> handleShipping();
                case 4 -> exit = true;
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        }

        System.out.println("Programa terminado.");
        scanner.close();
    }

    // Opciones para Product
    private static void handleProduct() {
        ProductSerializer serializer = new ProductSerializer();
        ProductDeserializer deserializer = new ProductDeserializer();
        ProductJsonWriter jsonWriter = new ProductJsonWriter();
        ProductJsonReader jsonReader = new ProductJsonReader();

        System.out.println("\n--- OPERACIONES PRODUCT ---");
        System.out.println("1. Serializar a .dat");
        System.out.println("2. Deserializar de .dat");
        System.out.println("3. Guardar en JSON");
        System.out.println("4. Leer desde JSON");
        System.out.println("5. (No aplica XML a JSON para producto)");
        System.out.print("Elija opción: ");

        int op = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (op) {
                case 1 -> {
                    List<Product> products = new ArrayList<>();
                    products.add(new Product("P001", "Producto 1", "10.5"));
                    products.add(new Product("P002", "Producto 2", "20.0"));
                
                    serializer.serializeProduct(products, "products.dat");
                }
                
                case 2 -> {
                    List<Product> products = deserializer.deserializeProduct("products.dat");
                    if (products != null) {
                        System.out.println("Productos deserializados:");
                        for (Product p : products) {
                            System.out.println(p);
                        }
                    }
                }
                case 3 -> {
                    List<Product> products = new ArrayList<>();
                    products.add(new Product("P001", "Producto 1", "10.5"));
                    products.add(new Product("P002", "Producto 2", "10.5"));
                    jsonWriter.writeProducts(products, "products.json");
                }
                case 4 -> {
                    List<Product> products = jsonReader.readProducts("products.json");
                    products.forEach(System.out::println);
                }
                default -> System.out.println("Opción no válida o no implementada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Opciones para Customer
    private static void handleCustomer() {
        CustomerSerializer serializer = new CustomerSerializer();
        CustomerDeserializer deserializer = new CustomerDeserializer();
        CustomerJsonWriter jsonWriter = new CustomerJsonWriter();
     

        System.out.println("\n--- OPERACIONES CUSTOMER ---");
        System.out.println("1. Serializar a .dat");
        System.out.println("2. Deserializar de .dat");
        System.out.println("3. Guardar en JSON");
        System.out.println("4. Leer desde JSON");
        System.out.println("5. (No aplica XML a JSON para customer)");
        System.out.print("Elija opción: ");

        int op = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (op) {
                case 1 -> {
                    Customer c = new Customer("123456", "Calle falsa 123", "5551234", "cliente@email.com");
                    serializer.serializeCustomer(c, "customer.dat");
                }
                case 2 -> {
                    Customer c = deserializer.deserializeCustomer("customer.dat");
                    if (c != null) System.out.println("Cliente deserializado: " + c);
                }
                case 3 -> {
                    List<Customer> customers = new ArrayList<>();
                    customers.add(new Customer("123456", "Calle falsa 123", "5551234", "cliente@email.com"));
                    customers.add(new Customer("789012", "Av. Siempre Viva", "5555678", "cliente2@email.com"));
                    jsonWriter.writeCustomers(customers, "customers.json");
                }
                default -> System.out.println("Opción no válida o no implementada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Opciones para Shipping
    private static void handleShipping() {
        ShippingSerializer serializer = new ShippingSerializer();
        ShippingDeserializer deserializer = new ShippingDeserializer();
        ShippingJsonWriter jsonWriter = new ShippingJsonWriter();
        ShippingJsonReader jsonReader = new ShippingJsonReader();
        ShippingXmlToJsonConverter xmlConverter = new ShippingXmlToJsonConverter();

        System.out.println("\n--- OPERACIONES SHIPPING ---");
        System.out.println("1. Serializar a .dat");
        System.out.println("2. Deserializar de .dat");
        System.out.println("3. Guardar en JSON");
        System.out.println("4. Leer desde JSON");
        System.out.println("5. Convertir XML a JSON");
        System.out.print("Elija opción: ");

        int op = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (op) {
                case 1 -> {
                    Shipping s = new Shipping("S001", "DHL", "2025-05-28", "En transporte", null);
                    serializer.serializeShipping(s, "shipping.dat");
                }
                case 2 -> {
                    Shipping s = deserializer.deserializeShipping("shipping.dat");
                    if (s != null) System.out.println("Shipping deserializado: " + s);
                }
                case 3 -> {
                    List<Shipping> shippings = new ArrayList<>();
                    shippings.add(new Shipping("S001", "DHL", "2025-05-28", "En transporte", null));
                    shippings.add(new Shipping("S002", "FedEx", "2025-05-20", "Entregado", "2025-05-25"));
                    jsonWriter.writeShippings(shippings, "shippings.json");
                }
                case 4 -> {
                    List<Shipping> shippings = jsonReader.readShippings("shippings.json");
                    shippings.forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("Ingrese ruta archivo XML (e.g. shipping.xml): ");
                    String xmlPath = scanner.nextLine();
                    System.out.print("Ingrese ruta archivo JSON destino: ");
                    String jsonPath = scanner.nextLine();
                    xmlConverter.convertXmlToJson(xmlPath, jsonPath);
                }
                default -> System.out.println("Opción no válida.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}