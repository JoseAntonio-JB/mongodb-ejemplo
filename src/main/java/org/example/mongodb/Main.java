package org.example.mongodb;

import org.example.mongodb.connection.MongoConect;

public class Main {
    public static void main(String[] args) {

        MongoConect conect = new MongoConect();
        conect.mostrarTitulos();
    }
}