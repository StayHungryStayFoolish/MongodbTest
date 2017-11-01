import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by bonismo@hotmail.com
 * 下午1:55 on 17/11/1.
 */
//@RunWith()
public class MongodbTest {

    DeleteCollection collection = new DeleteCollection();

    @Test
    public void test() {
        DeleteCollection.test();
    }

    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient("101.201.117.5", 12128);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("ticket_zhibo");
            System.out.println("连接成功");
            MongoCollection<Document> collection = mongoDatabase.getCollection("t_activity_user");
            System.out.println("选择成功");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

}
