package org.example.mongodb;

import org.example.mongodb.connection.MongoConect;

public class Main {
    public static void main(String[] args) {

        MongoConect conect = new MongoConect();
        System.out.println(conect.collectionElementsNumber( conect.getCollection("empleados","fakedatas")));
    }
}