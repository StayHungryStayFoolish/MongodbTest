import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 * Created by bonismo@hotmail.com
 * 下午6:58 on 17/10/23.
 */
public class FindCollection {
    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient("10.211.55.7", 27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("连接成功");
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println(" test 选择成功");

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

            /**
             * 更新 test 文档
             * 1.获取的集合 collection , updateMany() 更新
             * 2.参数
             *   参数1：采用过滤器 的  eq(K,V) 匹配条件
             *   参数2：更新语法 new Document ("$set",V),new Document(k,v))
             * 3. FindIterable<> 遍历更新后的文档
             */
            collection.updateMany(
                    Filters.eq("likes", 100),
                    new Document("$set", new Document("likes", 200)));
            FindIterable<Document> iterable = collection.find();
            MongoCursor<Document> cursor = findIterable.iterator();
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
