import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

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

            /**
             * 插入文档
             * 1.创建 org.bason.Document 参数 K-V
             * 2.创建插入的文档集合 List<Document>
             * 3.将文档集合插入数据库集合中
             *   mongoCollection.insertMany(List<Document>)
             *
             *   插入单个文档可以用
             *   mongoCollection.insertOne(Document)
             */
            Document document = new Document("title", "MongoDB")
                    .append("description", "database")
                    .append("likes", 100);
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
            System.out.println("文档插入成功");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
    }
}
