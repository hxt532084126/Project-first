package cn.itcast.jdbc1;

class Fields {

    public static final String CONSTANT = "Constant";
    public static final String NON_CONSTANT = new String("Non-constant");

    static {
        System.out.println("Initializing");
    }
}

public class Test03 {
    public static void main(String arg[]) {
        System.out.println(Fields.CONSTANT);
        System.out.println(Fields.NON_CONSTANT);
    }
}