package org.example.mongodb.connection;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MongoConect {
    //instanciamos un objeto MongoClient
    MongoClient client = MongoClients.create("mongodb://localhost:27017");


    MongoDatabase mgdatabase = client.getDatabase("fakedatas");
    //asumiendo nombre de la coleccion -librosColeccion-
    MongoCollection<Document> collection = mgdatabase.getCollection("conductores");
    public void mostrarTitulos(){
        FindIterable<Document> listaLibros = collection.find();
        for (Document doc : listaLibros) {
            System.out.println(doc.getString("first_name")+",  "+doc.getString("last_name"));
            client.close();
        }
    }

    public List<String> getDataBaseName(){
        List<String> names = new ArrayList<>();
        for(String iter : client.listDatabaseNames()){
            if(!(iter.equals("admin") || iter.equals("config") || iter.equals("local"))) {
                names.add(iter);
            }
        }
        return names;
    }
    public List<String> getCollectionsName(int databaseListIndex){
        List<String> names = new ArrayList<>();
        for(String iter : client.getDatabase(getDataBaseName().get(databaseListIndex)).listCollectionNames()){
            names.add(iter);
        }
        return names;
    }

    public MongoCollection<Document> getCollection(String collectionName, String dataBaseName){
        MongoDatabase mgdb = client.getDatabase(dataBaseName);
        MongoCollection<Document> mgcdoc = mgdb.getCollection(collectionName);
        return mgcdoc;
    }
    public long collectionElementsNumber(MongoCollection<Document> collection){
        return collection.countDocuments();

    }
}
