import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bonismo@hotmail.com
 * 下午5:16 on 17/11/8.
 */
public class RegexTest {

    public static void main(String[] args) {
        String template = "【$!{data.channelName}】您预订的直播：《$!{data.title}-$!{data.name}》，将于30分钟后开始。如有疑问，请添加客服微信：jiaoyinkefu 进行反馈。";
        String[] after = {"直播课堂", "课堂名字", "平安保险"};
        String regex = "\\$!\\{[^}]*\\}";
        for (int i = 0; i < after.length; i++) {
            if (template.contains("$!{data.channelName}")) {
                String demo = template.replaceAll("\\$!\\{data.channelName}", after[i]);
//                System.out.println(demo);
            }
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            String before = matcher.group(0);
            for (int i = 0; i < after.length; i++) {
                if (template.contains(before)) {
                    String demo = template.replaceAll("\\$!\\{data.channelName}", after[i]);
                    System.out.println("==>"+demo);
                }
            }
        }
    }
}

/**
 * $!{data.channelName}
 * class java.lang.String
 * $!{data.title}
 * class java.lang.String
 * $!{data.name}
 * class java.lang.String
 */