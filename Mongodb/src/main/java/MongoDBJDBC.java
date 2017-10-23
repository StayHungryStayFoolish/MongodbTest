import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by bonismo@hotmail.com
 * 下午6:17 on 17/10/23.
 */
public class MongoDBJDBC {
    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient("10.211.55.7", 27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("成功连接数据库");

//            创建集合
//            mongoDatabase.createCollection("test");
//            System.out.println("集合创建成功");

            // 获取集合
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println(" test 集合选择成功");


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
    }
}
