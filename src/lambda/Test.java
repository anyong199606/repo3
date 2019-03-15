package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class Test {

    private Integer count;
    public Test(){}

    public Test(Integer count){
        this.count = count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("a", "b", "A", "B");
//        stringList.sort((s1,s2)-> s1.compareToIgnoreCase(s2));
        System.out.println(stringList);
        stringList.sort(String :: compareToIgnoreCase);
        System.out.println(stringList);
//        Supplier<Test> supplier = Test :: new;
        Supplier<Test> supplier = ()-> new Test();

        Function<Integer,Test> supplier1 = Test::new;
        Test apply = supplier1.apply(100);
        System.out.println(apply.count);
        Test test = supplier.get();
        System.out.println(test);


        Function<Integer,Test> f = count-> new Test(count);
        Test apply1 = f.apply(200);
        System.out.println(apply1.count);

        List<Test> map = map(Arrays.asList(1, 2, 23, 45, 6), Test::new);
        map.sort(Comparator.comparing(Test::getCount));
    }

    public static List<Test> map(List<Integer> counts,Function<Integer,Test> f){

        ArrayList<Test> tests = new ArrayList<>();
        for (Integer count : counts){
            tests.add(f.apply(count));
        }
        return tests;
    }


}
