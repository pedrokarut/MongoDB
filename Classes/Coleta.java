package ClassesJava;
import org.bson.types.ObjectId;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.Block;
import com.mongodb.CursorType;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;


public class Coleta 
{
    private ObjectId codColeta;
    private ObjectId codAgente;
    private ObjectId codPonto;
    private String dataColeta;
    
    
    
    public Coleta()
    {
        
    }
    
    
    public static void InsertColeta( ObjectId codAgente, ObjectId codPonto, String data)
    {             
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("Coleta");
         System.out.print("Conexao ok");
            
            
            
         MongoCollection<Document> coll = db.getCollection("Coleta");            
         
         coll.insertOne(
                 
                 new Document()
                 .append("codAgente", codAgente)
                 .append("codPonto", codPonto)
                 .append("dataColeta", data)
         
         );
         
         //end of Insert method
   }
    
    
    public static void UpdateColeta(ObjectId id, ObjectId codAgente, ObjectId codPonto, String data)
    {          
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );			
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("Coleta");
         System.out.println("Conexao ok");           
            
         BasicDBObject criterio = new BasicDBObject();
         criterio.put("_id", id);
         
         BasicDBObject NovoDocumento = new BasicDBObject();
         NovoDocumento.put("codAgente", codAgente);
         NovoDocumento.put("codPonto", codPonto); 
         NovoDocumento.put("dataColeta", data);
         
         
         BasicDBObject updateDocumento = new BasicDBObject();
         updateDocumento.put("$set", NovoDocumento);       
         
         MongoCollection<Document> coll = db.getCollection("Coleta");   
         
         coll.updateOne(criterio, updateDocumento);            
         System.out.println("Update executado com sucesso!");   
            
    } 
      
    
    public static void DeleteColeta(ObjectId id)
    {
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );			
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("Coleta");
         System.out.println("Conexao ok");           
            
         MongoCollection<Document> coll = db.getCollection("Coleta");   
         coll.deleteOne(new Document("_id", id));
         System.out.println("Delete OK!");
         
    }

    public ObjectId getCodColeta() {
        return codColeta;
    }

    public void setCodColeta(ObjectId codColeta) {
        this.codColeta = codColeta;
    }

    public ObjectId getCodAgente() {
        return codAgente;
    }

    public void setCodAgente(ObjectId codAgente) {
        this.codAgente = codAgente;
    }

    public ObjectId getCodPonto() {
        return codPonto;
    }

    public void setCodPonto(ObjectId codPonto) {
        this.codPonto = codPonto;
    }

    public String getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(String dataColeta) {
        this.dataColeta = dataColeta;
    }
    
    
    
    
}
