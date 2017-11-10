import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bonismo@hotmail.com
 * 上午10:31 on 17/11/10.
 */
public class TemplateReplace {

    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        String temp = "【$!{data.channelName}】您预订的直播：《$!{data.title}-$!{data.name}》，将于30分钟后开始。...";
        map = composeTemplate(temp, "data.channelName", "平安");
//        System.out.println(composeMessage(temp,map));

        List list = new ArrayList();
        list = getKey(temp);
        for (Object o : list) {
            System.out.println("==>"+o);
        }
    }

    /**
     * 获取模板中的占位符，即 Map 中的 Key
     * @param template
     * @return
     */
    public static List<String> getKey(String template) {
        List<String> list = new ArrayList<String>();
        String regex = "\\$!\\{(.+?)\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            String name = matcher.group(1);
            list.add(name);
        }
        return list;
    }

    /**
     * 根据 Key 更新 Map 值
     * 替换占位符内容
     * @param template
     * @param key
     * @param value
     * @return
     */
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

    /**
     * 将 Map 的值更新到模板中，替换到原来的占位符
     * @param template
     * @param data
     * @return
     * @throws Exception
     */
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
