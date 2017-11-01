import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 * Created by bonismo@hotmail.com
 * 下午8:18 on 17/10/23.
 */
public class DeleteCollection {

    public static void test() {
        try {
            MongoClient mongoClient = new MongoClient("101.201.117.5", 12128);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("ticket_zhibo");
            System.out.println("连接成功");
            MongoCollection<Document> collection = mongoDatabase.getCollection("t_activity_user");
            System.out.println("选择成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient("101.201.117.5", 12128);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("ticket_zhibo");
            System.out.println("连接成功");
            MongoCollection<Document> collection = mongoDatabase.getCollection("t_activity_user");
            System.out.println("选择成功");

            /**
             * 检索 test 集合所有文档
             * 1.获取文档的 迭代器 FindIterable<Document>
             * 2.获取文档指针 MongoCursor<Document>
             * 3.通过指针遍历文档集合
             */
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while (mongoCursor.hasNext()) {
                System.out.println(mongoCursor.next());
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
