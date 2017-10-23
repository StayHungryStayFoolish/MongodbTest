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
    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient("10.211.55.7", 27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("连接成功");
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println(" test 选择成功");

            /**
             * 删除 test 文档
             * 1.获取的集合 collection ,  deleteOne() 删除符合条件的第一个
             * 2.获取的集合 collection ,  deleteMany() 删除符合条件的所有
             */
            collection.deleteOne(Filters.eq("likes", 200));

//            collection.deleteMany(Filters.eq("likes", 200));

            FindIterable<Document> iterable = collection.find();
            MongoCursor<Document> cursor = iterable.iterator();
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
