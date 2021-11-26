package context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
    //this is a variable for preserve the context
    private final static Map<Class<?>, Object> CONTEXT = new ConcurrentHashMap<>();
    public static void addSingleton(Class<?> clazz, Object entity){
        ApplicationContext.CONTEXT.put(clazz,entity);
    }
    public static <T> T getSingleton(Class<T> tClass){
        return (T) ApplicationContext.CONTEXT.get(tClass);
    }


}
