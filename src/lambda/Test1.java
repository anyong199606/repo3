package lambda;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author anyong
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: TODO
 * @date ${date} ${time}
 */
public class Test1 {
    private Integer count;
    public Test1(){}

    public Integer getCount(){
        return count;
    }

    @Override
    public String toString() {
        return "Test1{" +
                "count=" + count +
                '}';
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Test1(Integer count){
        this.count = count;
    }
    static Map<String,Function<Integer,Test1>> map = new HashMap<>(10);
    static {
        map.put("apple",count->new Test1(count));
        map.put("orange",Test1::new);
    }

    public static void main(String[] args) {
//        Test1 apple = getMeCount("apple", 10);
//        System.out.println(apple.count);
//        //        Function<Integer,Test1> function = count->new Test1(count);
//        List<Test1> list = Arrays.asList(new Test1(4), new Test1(4), new Test1(2), new Test1(3));
//        list.sort(Comparator.comparing(Test1::getCount)
//                .reversed()
//                .thenComparing(Test1::hashCode)
//        );
//        System.out.println(list);

//        Function<String, String> addHeader = Test1::addHeader;
//        Function<String, String> function = addHeader.andThen(Test1::replaceAll)
//                .andThen(Test1::addFooter);
//        String result = function.apply("yuanxin ");
//        System.out.println(result);

//        Function<String, String> addHeader = Test1::addHeader;
//        Function<String, String> function = addHeader
//                .andThen(Test1::addFooter);
//        String result = function.apply("yuanxin ");
//        System.out.println(result);
//        Function<Integer,Test1> f = Test1::new;
//         Function<Test1,Integer> f = Test1::getCount;
//        List<Integer> list = map(Arrays.asList("asdad", "dsfsdf", "f"), String::length);
//        System.out.println(list);

//        List<String> list = Arrays.asList("a", "b", "A", "B");
//        list.sort(String::compareToIgnoreCase);
//
//        Function<Double,Float> function = Double::floatValue;
//
//        Predicate<String> predicate = String::isEmpty;
//        Predicate<String> negate = predicate.negate();
////        boolean test = predicate.test("");
////        System.out.println(test);
//        System.out.println(negate.test(""));
//
//        Consumer<Integer> consumer = Test1::setCount;
//        Predicate<Integer> predicate = x-> x>0;
//        boolean test = predicate.negate().and(x -> x < 10).test(5);
//        System.out.println(test);
        Function<Integer,Integer> function1 = Test1::add;
        String s = function1.andThen(Test1::c)
                            .apply(5)+"";
        System.out.println(s);
    }

    public static Integer add(Integer i){
        return ++i;
    }

    public static Integer c(Integer i){
        return i*i;
    }


    public static Test1 getMeCount(String name,Integer count){
        return map.get(name).apply(count);
    }

    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor)
    {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
                (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }

    public static String addHeader(String text){
        return "hello:"+text;

    }

    public static String addFooter(String text){
        return text+"end!";

    }

    public static String replaceAll(String text){
        return text.replaceAll("a","A");

    }

    public static <T,R> List<R> map(List<T> list,Function<T,R> f){
        ArrayList<R> rs = new ArrayList<>();
        for (T t:list){
            rs.add(f.apply(t));
        }
        return rs;
    }
}
