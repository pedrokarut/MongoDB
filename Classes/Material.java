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

public class Material 
{
    
    private ObjectId codMaterial;
    private String nome;
    private String tipo;
    private int tempoDecomposicao;
    private String descricao;

    public Material()
    {
        
    }
    
    
    public static void InsertMaterial( String nome, String tipo, int tempoDecomposicao, String descricao)
    {             
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("Coleta");
         System.out.print("Conexao ok");
            
            
            
         MongoCollection<Document> coll = db.getCollection("Material");            
         
         coll.insertOne(
                 
                 new Document()
                 .append("nome", nome)
                 .append("tipo", tipo)
                 .append("tempoDecomposicao", tempoDecomposicao)
                 .append("descricao", descricao)
         
         );
         
         //end of Insert method
   }
    
    
    public static void UpdateMaterial(ObjectId id, String nome, String tipo, int tempoDecomposicao, String descricao)
    {          
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );			
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("Coleta");
         System.out.println("Conexao ok");           
            
         BasicDBObject criterio = new BasicDBObject();
         criterio.put("_id", id);
         
         BasicDBObject NovoDocumento = new BasicDBObject();
         NovoDocumento.put("nome", nome);
         NovoDocumento.put("nome", nome); 
         NovoDocumento.put("tipo", tipo);
         NovoDocumento.put("tempoDecomposicao", tempoDecomposicao);
         NovoDocumento.put("descricao", descricao);
         
         
         BasicDBObject updateDocumento = new BasicDBObject();
         updateDocumento.put("$set", NovoDocumento);       
         
         MongoCollection<Document> coll = db.getCollection("Material");   
         
         coll.updateOne(criterio, updateDocumento);            
         System.out.println("Update executado com sucesso!");   
            
    } 
      
    
    public static void DeleteMaterial(ObjectId id)
    {
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );			
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("Coleta");
         System.out.println("Conexao ok");           
            
         MongoCollection<Document> coll = db.getCollection("Material");   
         coll.deleteOne(new Document("_id", id));
         System.out.println("Delete OK!");
         
    }
         
      
      
     
    public ObjectId getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(ObjectId codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTempoDecomposicao() {
        return tempoDecomposicao;
    }

    public void setTempoDecomposicao(int tempoDecomposicao) {
        this.tempoDecomposicao = tempoDecomposicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
    
    
    
    
}
