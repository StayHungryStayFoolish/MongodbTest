import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Created by bonismo@hotmail.com
 * 下午6:17 on 17/10/23.
 */
public class MongoDBJDBC {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("10.211.557",27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
        System.out.println("成功连接数据库");
    }
}
