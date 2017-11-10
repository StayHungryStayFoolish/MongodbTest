import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bonismo@hotmail.com
 * 上午10:31 on 17/11/10.
 */
public class TemplateReplace {




    public static HashMap<String,String> composeTemplate(String template, String key, String value) {
        HashMap<String,String> map = new HashMap();
        String regex = "\\$!\\{(.+?)\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            String name = matcher.group(1);
            if (name.equals(key)) {
                map.put(key, value);
            }
        }
        return map;
    }

    public static String composeMessage(String template, Map data)
            throws Exception {
        String regex = "\\$!\\{(.+?)\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(template);
        /*
         * sb用来存储替换过的内容，它会把多次处理过的字符串按源字符串序
         * 存储起来。
         */
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String key = matcher.group(1);//键
            String value = (String) data.get(key);//值
            if (value == null) {
                value = "";
            } else {
                value = value.replaceAll("\\$", "\\\\\\$");
                System.out.println("value=" + value);
            }
            matcher.appendReplacement(sb, value);
            System.out.println("sb = " + sb.toString());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
