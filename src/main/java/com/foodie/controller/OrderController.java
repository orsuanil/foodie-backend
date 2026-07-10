
package com.foodie.controller;

import com.foodie.entity.Order;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    @PostMapping("/order")
    public String placeOrder(@RequestBody Order order) {

        try {

            String message =
                    "🍔 New Food Order\n\n" +
                            "Items: " + order.getItems() + "\n" +
                            "Total: ₹" + order.getTotal();

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://ntfy.sh/foodie-anil-2026"))
                    .header("Content-Type", "text/plain")
                    .POST(HttpRequest.BodyPublishers.ofString(message))
                    .build();

            client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Notification sent!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Order Received";
    }
}