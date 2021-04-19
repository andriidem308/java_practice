package classwork_6;

public class task_1 {
    static void test_1(String s) {
        String sn = s.replaceAll("\\d", "");
        sn = sn.replaceAll("\\+", "++");
        sn = sn.replaceAll("-", "--");
        System.out.println("1: \"" + sn + "\"");
    }

    static void test_2(String s) {
        String sn = s.replaceAll("(\\+)(\\d)", "$2");
        System.out.println("2: \"" + sn + "\"");
    }

    static void test_3(String s) {
        String sn = s.replaceAll("(b)(c)", "$2");
        System.out.println("3: \"" + sn + "\"");
    }

    static void test_4(String s) {
        String sn = s.replaceAll("ph", "f");
        System.out.println("4: \"" + sn + "\"");
    }

    static void test_5(String s) {
        String sn = s.replaceAll("\\s+", " ");
        System.out.println("5: \"" + sn + "\"");
    }

    public static void main(String[] args) {
        String s = "ab2c36d  a +1bph+55 -ph-c5  +91da6bc+dph   +5a+2phbcd";
        System.out.println("0: \"" + s + "\"\n");
        test_1(s);
        test_2(s);
        test_3(s);
        test_4(s);
        test_5(s);
    }
}
