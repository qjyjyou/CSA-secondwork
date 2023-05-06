import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("<-------第一题------->");
        //TODO:在此编写第一题测试代码
        Monkey m = new Monkey("AA");
        System.out.println(m.name);
        m.speak();
        People p = new People("PP");
        System.out.println(p.name);
        p.speak();
        p.think();

        System.out.println("<-------第二题------->");
        //TODO:在此编写第二题测试代码
        Car c = new Car(6, 4, 1150);
        System.out.println(c.print());
        Truck t = new Truck(1, 6, 15000, 7000);
        System.out.println(t.print());

        System.out.println("<-------第三题------->");
        //TODO:在此编写第三题测试代码
        System.out.println(getSum("88888888888888888", "25461213124533465"));

        System.out.println("<-------第四题------->");
        //TODO:在此编写第四题测试代码
        System.out.println(uniquePaths(7, 3));

        System.out.println("<-------第五题------->");
        //TODO:在此编写第五题测试代码
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
    //TODO:在此编写作业所需的方法
    //第三题格式要求,在TODO部分实现代码
    public static String getSum(String a, String b) {
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        String c = "";
        for (int i = a.length() - 1; i >= 0; --i) {
            la.add(a.charAt(i) - '0');
        }
        for (int i = b.length() - 1; i >= 0; --i) {
            lb.add(b.charAt(i) - '0');
        }
        //TODO:在此处编写符合要求的代码，并在主类中编写测试代码
        List<Integer> lc = new ArrayList<Integer>();
        int sum = 0;//表示进位
        int maxsize = Math.max(la.size(), lb.size());
        for (int i = 0; i < maxsize; i++) {
            if (i < la.size()) {
                //进位加本位
                sum += la.get(i);
            }
            if (i < lb.size()) {
                sum += lb.get(i);
            }
            //向lc集合中存入sum的个位即本位
            lc.add(sum % 10);
            //去掉本位，留下进位
            sum = sum / 10;
        }
        if (sum > 0) {
            lc.add(sum);
        }
        for (int i = lc.size() - 1; i >= 0; i--) {
            c += lc.get(i);
        }
        return c;
    }

    //第四题格式要求
    public static int uniquePaths(int m, int n) {
        //TODO:在此处编写符合要求的代码，并在主类中编写测试代码
        //从m+n-2次移动中中选择m-1次向下的移动或者n-1次向右的移动，C（m+n-2）（m-1）或者C（m+n-2）（n-1）
        double ans = 1;
        for (int x = n + m - 2, y = n - 1; y > 0; x--, y--) {
            ans = ans * x / y;
        }
        return (int) ans;
//方法二
//        int [][]p=new int[m][n];
//        for (int i = 0; i < m; i++) {
//            p[i][0]=1;
//        }
//        for (int j = 0; j < n; j++) {
//            p[0][j]=1;
//        }
//        for (int i = 1; i <m ; i++) {
//            for (int j = 1; j <n ; j++) {
//                p[i][j]=p[i-1][j]+p[i][j-1];
//            }
//        }
//        return p[m-1][n-1];
    }
    //第五题格式要求
    public static String longestCommonPrefix(String[] strs) {
        //TODO:在此处编写符合要求的代码，并在主类中编写测试代码
        if(strs.length==0||strs==null)
            return "";
        int length=strs.length;
        int width=strs[0].length();
        for (int i = 0; i < width; i++) {
            char c=strs[0].charAt(i);
            for (int j = 1; j < length; j++) {
                if(strs[j].charAt(i)!=c||i==strs[j].length()){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
    //TODO:在此处编写作业所需的类，并在主类中测试这些类
    //注意相互间的继承关系
class Monkey {
    String name;

    public Monkey() {
    }

    public Monkey(String s) {
        this.name = s;
    }

    public void speak() {
        System.out.println("咿咿呀呀......");
    }
}

class People extends Monkey {
    public People(String s) {
        this.name = s;
    }

    public void speak() {
        System.out.println("小样儿，不错嘛！会说话了！");
    }

    public void think() {
        System.out.println("别说话！认真思考！");
    }
}

class Vehicle {
    int wheels;
    double weight;

    public Vehicle() {
    }

    public Vehicle(int wheels, double weight) {
        this.wheels = wheels;
        this.weight = weight;
    }
}

class Car extends Vehicle {
    int loader;

    public Car() {
    }

    public Car(int loader, int wheels, double weight) {
        this.loader = loader;
        this.wheels = wheels;
        this.weight = weight;
    }

    public String print() {
        return "车轮的个数是：" + wheels + " 车重：" + weight +
                "\n这是一辆小车，" + "能载5人，" + "实载" + loader + "人" +
                (loader > 5 ? "，你超员了！！！" : "");
    }
}

class Truck extends Vehicle {
    int loader;
    double payload;

    public Truck() {
    }

    public Truck(int loader, int wheels, double weight, double payload) {
        this.loader = loader;
        this.wheels = wheels;
        this.weight = weight;
        this.payload = payload;
    }

    public String print() {
        return "车轮的个数是" + wheels + " 车重" + weight +
                "\n这是一辆卡车，" + "能载3人，" + "实载" + loader + "人\n" +
                (loader > 3 ? "你超员了！！！" : "") +
                "这是一辆卡车，" + "核载5000kg，" + "你已装载" + payload + "kg" +
                (payload > 5000 ? "，你超载了！！！" : "");
    }
}
