import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
    public String name;
    public String classes;
    public double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}
public class TestDemo3 {

    public static List<String> func(String str1,String str2) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char tmp = str1.charAt(i);
            if(!str2.contains(tmp+"")) {
                list.add(tmp+"");
            }
        }
        return list;
    }

    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) {
            return null;
        }
        List<List<Integer>> ret = new ArrayList<>();

        //第一行
        List<Integer> one = new ArrayList<>();
        one.add(1);
        ret.add(one);
        //从第2行开始放
        for (int i = 1; i < numRows ; i++) {
            //每一行进来 都要一个list  --》 curRow
            List<Integer> curRow = new ArrayList<>();
            //当前行的 第0列 放一个1
            curRow.add(1);
            //前一行
            List<Integer> preRow = ret.get(i-1);
            //从当前行的第1列开始
            for (int j = 1; j < i; j++) {
                int tmp = preRow.get(j)+preRow.get(j-1);
                curRow.add(tmp);
            }
            curRow.add(1);
            //当前行都添加完了
            ret.add(curRow);
        }
        return ret;
    }



    public static void main(String[] args) {
        List<String> ret = func("welcome to bit","come");
        //System.out.println(ret);
        for (String str :ret) {
            System.out.print(str);
        }
    }

    public static void main2(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(31);
        list.add(11);
        list.add(156);
        Collections.sort(list);
        System.out.println(list);
    }
    public static void main1(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student("ab","Java12",12.6));
        list.add(new Student("abc","111",111.6));
        list.add(new Student("abd","Java1",134));
        for (Student student  :list) {
            System.out.println(student);
        }

        //ArrayList<Student> arrayList = new ArrayList<>();
    }
}
