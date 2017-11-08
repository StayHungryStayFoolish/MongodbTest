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
        String regex = "\\$!\\{[^}]*\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

        if (template.indexOf("\n") != -1) {
            String[] tempArray = template.split("\n");
            int kwCount = 1;
            if (tempArray.length > 2) {
                kwCount = tempArray.length - 2;
            }
            List<Map<String, String>> contentList = new LinkedList<Map<String, String>>();
            for (String s : tempArray) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("value", s);
                if (s.indexOf("：") != -1) {
                    String[] temp = s.split("：");
                    String tempStr = temp[1];
                    tempStr = tempStr.replace("}", "");
                    tempStr = tempStr.replace("\\{", "");
                    tempStr = tempStr.replace(".", "");
                    map.put("key", tempStr);
                }
                contentList.add(map);
            }
            System.out.println("ContentList"+contentList.toArray());

        }
    }
}

/**
 $!{data.channelName}
 class java.lang.String
 $!{data.title}
 class java.lang.String
 $!{data.name}
 class java.lang.String
 */