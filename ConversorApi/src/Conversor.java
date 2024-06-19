import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    // creacion de metodo  conversor con mis tres varibles
    public void conversor( String monedaOrigen,  String monedaDestino, Double cantidad) throws IOException, InterruptedException {

        String direccion = "https://v6.exchangerate-api.com/v6/f6c65008bc8b4becb368daa9/latest/"+ monedaOrigen;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String jsonResponse = response.body();


       // System.out.println("Respuesta de la API en JSON" + jsonResponse);
        // Gson gson = new Gson();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();// Linea de GSON de la documentacion de  gibhub "JSON Field Naming Support" para que entienda mis variables a pesar de que vienen en el gson com Tittle lo convierta a tiitle , reconozca y traiga el valor; esto es buena practica (Es decir aunque venga en mi JSON las variables con Mayusculas al principio; por buena practica las convierta a minuscula ejemplo: Tittle a titlle )

        JsonObject json = gson.fromJson(jsonResponse, JsonObject.class);// convierte de json a class
        JsonObject rates = json.getAsJsonObject("conversion_rates");//solo trae el rate


        //Conversion de tasa (trae el rates  de gson de la moneda que queremos obtener)
        double tasaMonedaDestino = rates.get(monedaDestino).getAsDouble();
        double resultado = cantidad * tasaMonedaDestino;

        System.out.println(" Tu tipo de cambio  de moneda Origen " + monedaOrigen + " a Moneda de cambio  equivale a " + resultado +  " "+ monedaDestino );

    }
}




