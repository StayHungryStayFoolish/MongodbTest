import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bonismo@hotmail.com
 * 下午5:16 on 17/11/8.
 */
public class RegexTest {

    public static void main(String[] args) {
        String template = "【$!{data.channelName}】您预订的直播：《$!{data.title}-$!{data.name}》，将于30分钟后开始。如有疑问，请添加客服微信：jiaoyinkefu 进行反馈。";
        String line = "$!{data.channelName}】您预订的直播： $!{data.cha}";
        String regex = "\\$!\\{[^}]*\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(0).getClass());
        }
    }
}
