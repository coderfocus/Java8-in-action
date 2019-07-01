
import transfercode.Apple;
import transfercode.FilterApples;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args){
//        File[] files = new File(".").listFiles(new FileFilter() {
//            public boolean accept(File file) {
//                return file.isHidden();
//            }
//        });

        File[] files = new File(".").listFiles(File::isHidden);


        List<Apple> apples = new ArrayList();
        apples.add(new Apple("red",120));
        apples.add(new Apple("red",200));
        apples.add(new Apple("green",120));
        apples.add(new Apple("green",200));

        //方法引用（相当于C#中将方法绑定到同类型委托）
        List<Apple> greenApples = FilterApples.filterApples(apples,Apple::isGreenApple);
        List<Apple> heavyApples = FilterApples.filterApples(apples,Apple::isHeavyApple);

        //lambda(匿名函数)
        List<Apple> greenApples1 = FilterApples.filterApples(apples,(Apple a) -> "green".equals(a.getColor()));
        List<Apple> heavyApples1 = FilterApples.filterApples(apples, a-> a.getWeight() >150);
        List<Apple> greenAndHeavyApples = FilterApples.filterApples(apples, a-> "green".equals(a.getColor()) && a.getWeight() >150);

    }
}
