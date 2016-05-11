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
