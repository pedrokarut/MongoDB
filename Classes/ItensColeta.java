package ClassesJava;
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
import org.bson.types.ObjectId;


public class ItensColeta 
{
    private ObjectId codItem;
    private ObjectId codMaterial;
    private ObjectId codColeta;
    private int quantidade;
    
    
    
 public static void InsertItem( ObjectId codMaterial, ObjectId codColeta, int quantidade)
    {             
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("Coleta");
         System.out.print("Conexao ok");
            
            
            
         MongoCollection<Document> coll = db.getCollection("ItensColeta");            
         
         coll.insertOne(
                 
                 new Document()
                 .append("codMaterial", codMaterial)
                 .append("codColeta", codColeta)
                 .append("quantidade", quantidade)
         
         );
         
         //end of Insert method
   }
    
    
    public static void UpdateItem(ObjectId id, ObjectId codMaterial, ObjectId codColeta, int quantidade)
    {          
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );			
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("Coleta");
         System.out.println("Conexao ok");           
            
         BasicDBObject criterio = new BasicDBObject();
         criterio.put("_id", id);
         
         BasicDBObject NovoDocumento = new BasicDBObject();
         NovoDocumento.put("codMaterial", codMaterial);
         NovoDocumento.put("codColeta", codColeta); 
         NovoDocumento.put("quantidade", quantidade);
         
         
         BasicDBObject updateDocumento = new BasicDBObject();
         updateDocumento.put("$set", NovoDocumento);       
         
         MongoCollection<Document> coll = db.getCollection("ItensColeta");   
         
         coll.updateOne(criterio, updateDocumento);            
         System.out.println("Update executado com sucesso!");   
            
    } 
      
    
    public static void DeleteItem(ObjectId id)
    {
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );			
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("Coleta");
         System.out.println("Conexao ok");           
            
         MongoCollection<Document> coll = db.getCollection("ItensColeta");   
         coll.deleteOne(new Document("_id", id));
         System.out.println("Delete OK!");
         
    }
   
    public ItensColeta()
    {
        
    }
    
    public ObjectId getCodItem() {
        return codItem;
    }

    public void setCodItem(ObjectId codItem) {
        this.codItem = codItem;
    }

    public ObjectId getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(ObjectId codMateial) {
        this.codMaterial = codMateial;
    }

    public ObjectId getCodColeta() {
        return codColeta;
    }

    public void setCodColeta(ObjectId codColeta) {
        this.codColeta = codColeta;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
}
