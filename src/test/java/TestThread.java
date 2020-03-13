import java.util.Arrays;
import java.util.HashMap;

public class TestThread {

    public static void main(String[] args) {

        System.out.println("sdlkfsfldk.sdfl".contains("\\."));
        System.out.println(Arrays.toString("sdlkfjsld.sdlkf".split("\\.")));
        HashMap hashMap = new HashMap();
        hashMap.put("zhao1","huan");
        hashMap.put("zhao2","huan");
        hashMap.put("zhao3","huan");
        hashMap.put("zhao4","huan");
        hashMap.put("zhao5","huan");
        hashMap.put("zhao6","huan");
        hashMap.put("zhao7","huan");
        hashMap.put("zhao8","huan");
        hashMap.put("zhao9","huan");
        hashMap.put("zhao10","huan");
        hashMap.put("zhao11","huan");
        hashMap.put("zhao12","huan");
        hashMap.put("zhao13","huan");
        hashMap.put("zhao14","huan");
        hashMap.put("zhao15","huan");
        hashMap.put("zhao16","huan");
        hashMap.put("zhao17","huan");
        hashMap.put("zhao18","huan");
        hashMap.put("zhao19","huan");
        hashMap.put("zhao20","huan");
        String key = "asdfawefdsdgasefaea";
        int h = 0;
        h = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(h);
    }

}
