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



public class AgenteAmbiental 
{
    private ObjectId codAgente;
    private String nome;
    private long cpf;
    private String dataNascimento;
    private String endereco;

    
    public AgenteAmbiental()
    {
        
    }
    
      
    public static void InsertAgente( String nome, long cpf, String dataNascimento, String endereco)
    {             
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("Coleta");
         System.out.print("Conexao ok");
            
            
            
         MongoCollection<Document> coll = db.getCollection("AgenteAmbiental");            
         
         coll.insertOne(
                 
                 new Document()
                 .append("nome", nome)
                 .append("cpf", cpf)
                 .append("dataNascimento", dataNascimento)
                 .append("endereco", endereco)
         );
         
         //end of Insert method
   }

    
    public static void UpdateAgente(ObjectId id, String nome, long cpf, String dataNascimento, String endereco)
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
         NovoDocumento.put("cpf", cpf); 
         NovoDocumento.put("dataNascimento", dataNascimento);
         NovoDocumento.put("endereco", endereco);
         
         
         BasicDBObject updateDocumento = new BasicDBObject();
         updateDocumento.put("$set", NovoDocumento);       
         
         MongoCollection<Document> coll = db.getCollection("AgenteAmbiental");   
         
         coll.updateOne(criterio, updateDocumento);            
         System.out.println("Update executado com sucesso!");   
            
    }
    
    
    public static void DeleteAgente(ObjectId id)
    {
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );			
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("Coleta");
         System.out.println("Conexao ok");           
            
         MongoCollection<Document> coll = db.getCollection("AgenteAmbiental");   
         coll.deleteOne(new Document("_id", id));
         System.out.println("Delete OK!");
         
    }
    
    
 
    
    
    public ObjectId getCodAgente() {
        return codAgente;
    }

    public void setCodAgente(ObjectId codAgente) {
        this.codAgente = codAgente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}




