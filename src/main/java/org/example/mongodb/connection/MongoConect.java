package org.example.mongodb.connection;

import com.mongodb.client.*;
import org.bson.Document;


public class MongoConect {
    //instanciamos un objeto MongoClient
    MongoClient client = MongoClients.create("mongodb://localhost:27017");

    //con el objeto client instanciamos un objeto MongoDataBase
    //asumiendo nombre de base de datos -librosdb-

    MongoDatabase mgdatabase = client.getDatabase("librosdb");
    //asumiendo nombre de la coleccion -librosColeccion-
    MongoCollection<Document> collection = mgdatabase.getCollection("librosColeccion");
    public void mostrarTitulos(){
        FindIterable<Document> listaLibros = collection.find();
        for (Document doc : listaLibros) {
            System.out.println(doc.getString("titulo")+" de "+doc.getString("autor"));
            client.close();
        }
    }
}
