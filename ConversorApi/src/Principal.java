import java.io.IOException;
import java.util.Scanner;

public class Principal {


    public static void main(String[] args) throws IOException, InterruptedException {

        boolean condicion = true;
        Conversor consulta = new Conversor();
        Scanner entrada = new Scanner(System.in);
        while (condicion) {

            System.out.println("****Bienvenid@s al Conversor de Monedas****");
            String menu = """      
                          
                    ** Escriba el número de la opción deseada **
                           "ARS - Peso argentino"
                           "BOB - Peso boliviano"
                           "BRL - Real brasileño"
                           "CLP - Peso chileno")
                           "COP - Peso colombiano")
                           "Salir - Finalizar programa"
                            
                    """;
            System.out.println(menu);



            // Se crea busqueda dinamica
            System.out.print("Ingrese la moneda de origen: ");
            String monedaOrigen = entrada.nextLine().toUpperCase();
            if (monedaOrigen.equals("SALIR")) {
                condicion = false;
                break;
            }

            System.out.print("Ingrese la moneda de cambio: ");
            String monedaDestino = entrada.nextLine().toUpperCase();


            System.out.print("Ingrese la cantidad a cambiar : ");
            Double cantidad = entrada.nextDouble();
            entrada.nextLine();

            consulta.conversor(monedaOrigen, monedaDestino, cantidad);

            System.out.println("Quieres hacer otra conversion");
            String respuestaUsuario = entrada.nextLine().toUpperCase();
            if (respuestaUsuario.equals("NO")) {
                condicion = false;
                System.out.println("Gracias por usar el conversor de monedas.");
                break;

            }
        }
    }
}

