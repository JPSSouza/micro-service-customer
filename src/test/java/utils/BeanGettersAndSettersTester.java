package utils;

import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class BeanGettersAndSettersTester {
    public static <T> void test(final Class<T> clazz, final String... skipThese) throws IntrospectionException {
        final PropertyDescriptor[] props = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
        nextProp: for (PropertyDescriptor prop : props) {
            // Check the list of properties that we don't want to test
            for (String skipThis : skipThese) {
                if (skipThis.equals(prop.getName())) {
                    continue nextProp;
                }
            }
            final Method getter = prop.getReadMethod();
            final Method setter = prop.getWriteMethod();

            if (getter != null && setter != null){
                // We have both a get and set method for this property
                final Class<?> returnType = getter.getReturnType();
                final Class<?>[] params = setter.getParameterTypes();

                if (params.length == 1 && params[0] == returnType){
                    // The set method has 1 argument, which is of the same type as the return type of the get method, so we can test this property
                    try{
                        // Build a value of the correct type to be passed to the set method
                        Object value = buildValue(returnType);

                        // Build an instance of the bean that we are testing (each property test gets a new instance)
                        T bean = clazz.getDeclaredConstructor().newInstance();

                        // Call the set method, then check the same value comes back out of the get method
                        setter.invoke(bean, value);

                        final Object expectedValue = value;
                        final Object actualValue = getter.invoke(bean);

                        assertEquals(String.format("Failed while testing property %s", prop.getName()), expectedValue, actualValue );

                    } catch (Exception ex){
                        fail(String.format("An exception was thrown while testing the property %s: %s", prop.getName(), ex.toString()));
                    }
                }
            }
        }
    }

    private static Object buildMockValue(Class<?> clazz){
        if (!Modifier.isFinal(clazz.getModifiers())){
            // Insert a call to your favourite mocking framework here
            return null;
        } else {
            return null;
        }
    }

    private static Object buildValue(Class<?> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, SecurityException, InvocationTargetException {
        // If we are using a Mocking framework try that first...
        final Object mockedObject = buildMockValue(clazz);
        if (mockedObject != null){
            return mockedObject;
        }

        // Next check for a no-arg constructor
        final Constructor<?>[] ctrs = clazz.getConstructors();
        for (Constructor<?> ctr : ctrs) {
            if (ctr.getParameterTypes().length == 0) {
                // The class has a no-arg constructor, so just call it
                return ctr.newInstance();
            }
        }
        return null;
    }
}
