import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class JavaDriver {

    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create(
                new ConnectionString("mongodb://localhost:27017")
        );

        MongoDatabase database = mongoClient.getDatabase("ngrinder");

        for(String name : database.listCollectionNames() ) {
            MongoCollection<?> collection = database.getCollection(name);
        }
    }
}
