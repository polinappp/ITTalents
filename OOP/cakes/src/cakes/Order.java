package cakes;

import cakes.cake.Cake;
import cakes.client.Client;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private Client client;
    private double price;
    private String address;
    private ArrayList<Cake> order;
    private LocalDateTime dateTimeOfDelivery;
}
