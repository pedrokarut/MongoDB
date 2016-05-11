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
    private ObjectId codMateial;
    private ObjectId codColeta;
    private int quantidade;
    
    
    
    
    
  
    
    public ItensColeta()
    {
        
    }
    
    public ObjectId getCodItem() {
        return codItem;
    }

    public void setCodItem(ObjectId codItem) {
        this.codItem = codItem;
    }

    public ObjectId getCodMateial() {
        return codMateial;
    }

    public void setCodMateial(ObjectId codMateial) {
        this.codMateial = codMateial;
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
