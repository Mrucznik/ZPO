package gajda.szymon;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int tab[] = {4, 9, 3, 7, 4, 1, 5, 2};
        final MaxSearchAlgorithms mm
                = MaxSearchAlgorithms.class.getConstructor().newInstance();

        System.out.println("Z refleksji");
        //ArrayList<Method> methods = new ArrayList<>(3);
        Class c = mm.getClass();
        for (Method method : c.getDeclaredMethods()) {
            if(method.getName().contains("Scan"))
            {
                System.out.println(method.getName() + " " + method.invoke(mm, tab));
            }
        }
    }
}
