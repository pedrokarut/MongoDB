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


public class PontoColeta 
{
    private ObjectId codPonto;
    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private String dataRetirada;
    
    
    public PontoColeta()
    {
        
    }    
    
    public static void InsertPonto(String nome, String endereco, String cidade, String estado, String dataRetirada)
    {             
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("Coleta");
         System.out.print("Conexao ok");
            
            
            
         MongoCollection<Document> coll = db.getCollection("PontoColeta");            
         
         coll.insertOne(
                 
                 new Document()
                 .append("nome", nome)
                 .append("endereco", endereco)
                 .append("cidade", cidade)
                 .append("estado", estado)
                 .append("dataRetirada", dataRetirada)
         
         );
         
         //end of Insert method
   }
    
    
    
    public static void UpdatePonto(ObjectId id, String nome, String endereco, String cidade, String estado, String dataRetirada)
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
         NovoDocumento.put("endereco", endereco); 
         NovoDocumento.put("cidade", cidade);
         NovoDocumento.put("estado", estado);
         NovoDocumento.put("dataRetirada", dataRetirada);
         
         
         BasicDBObject updateDocumento = new BasicDBObject();
         updateDocumento.put("$set", NovoDocumento);       
         
         MongoCollection<Document> coll = db.getCollection("PontoColeta");   
         
         coll.updateOne(criterio, updateDocumento);            
         System.out.println("Update executado com sucesso!");   
            
    }
    
    
    public static void DeletePonto(ObjectId id)
    {
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );			
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("Coleta");
         System.out.println("Conexao ok");           
            
         MongoCollection<Document> coll = db.getCollection("PontoColeta");   
         coll.deleteOne(new Document("_id", id));
         System.out.println("Delete OK!");
         
    }

    public ObjectId getCodPonto() {
        return codPonto;
    }

    public void setCodPonto(ObjectId codPonto) {
        this.codPonto = codPonto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }
    
    
    
    
    
    
    
}


