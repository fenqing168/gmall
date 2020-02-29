package cn.fenqing168.gmall.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author fenqing
 */
public class FenqingDataUtil {

    public static class PairingMapper<T> {
        private List<T> datas;
        private String extendLogo;
        private String dataLogo;
        private String formField;
        private String goToField;

        public static PairingMapper build(List datas, String extendLogo, String dataLogo, String formField, String goToField) {
            return new PairingMapper(datas, extendLogo, dataLogo, formField, goToField);
        }

        private PairingMapper(List<T> datas, String extendLogo, String dataLogo, String formField, String goToField) {
            this.datas = datas;
            this.extendLogo = extendLogo;
            this.dataLogo = dataLogo;
            this.formField = formField;
            this.goToField = goToField;
        }

        public List<T> getDatas() {
            return datas;
        }

        public String getExtendLogo() {
            return extendLogo;
        }

        public String getDataLogo() {
            return dataLogo;
        }

        public String getFormField() {
            return formField;
        }

        public String getGoToField() {
            return goToField;
        }
    }

    /**
     * 字段映射
     */
    public static class FieldMapper {
        private String dataField;

        private String mapperField;

        private FieldMapper(String dataField, String mapperField) {
            this.dataField = dataField;
            this.mapperField = mapperField;
        }

        public static FieldMapper build(String dataField, String mapperField) {
            return new FieldMapper(dataField, mapperField);
        }

        public String getDataField() {
            return dataField;
        }

        public String getMapperField() {
            return mapperField;
        }
    }

    /**
     * 集合类型默认实例子类
     */
    private static Map<Class, Class> COLLECTION_MAP = new HashMap<>();
    static{
        COLLECTION_MAP.put(List.class, ArrayList.class);
        COLLECTION_MAP.put(Set.class, HashSet.class);
    }

    /**
     * 获取对象属性
     *
     * @param t     对象
     * @param field 属性名称
     * @param <T>   对象类型
     * @return 属性值
     * @author fenqing
     */
    public static <T> Object getValue(final T t, final String field) {
        try {
            Class c = t.getClass();
            Method get = c.getMethod(MethodPrefix.GET.getValue() + initialToUpper(field));
            return get.invoke(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取对象属性
     *
     * @param t          对象
     * @param field      属性名称
     * @param returnType 返回值类型
     * @param <T>        对象类型
     * @param <Y>        返回值类型
     * @return 属性值
     * @author fenqing
     */
    public static <T, Y> Y getValue(final T t, String field, final Class<Y> returnType) {
        try {
            Class c = t.getClass();
            Method get = c.getMethod(MethodPrefix.GET.getValue() + initialToUpper(field));
            return (Y) get.invoke(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置属性
     *
     * @param o     被设置的对象
     * @param field 设置的字段
     * @param data  设置的值
     */
    public static void setValue(final Object o, final String field, final Object data) {
        try {
            Class<?> aClass = o.getClass();
            Class<?> dataClass = getFieldType(o, field);
            Method set = aClass.getMethod(MethodPrefix.SET.getValue() + initialToUpper(field), dataClass);
            set.invoke(o, data);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Class getFieldType(final Object o, String field) {
        try {
            Class<?> c = o.getClass();
            try {
                Field declaredField = c.getField(field);
                return Class.forName(declaredField.getGenericType().getTypeName());
            } catch (Exception e) {
                Method declaredMethod = c.getMethod(MethodPrefix.GET.getValue() + initialToUpper(field));
                return declaredMethod.getReturnType();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取一个数据集合中的对象中的某一个属性，（可获取多组）
     *
     * @param collection 数据集合
     * @param fields     属性名称
     * @return
     */
    public static Map<String, Set> getListValues(final Collection<?> collection, final List<String> fields) {
        Map<String, Set> result = new HashMap<String, Set>(8) {{
            fields.forEach(item -> {
                put(item, new HashSet<>());
            });
        }};
        collection.forEach(item -> {
            fields.forEach(field -> {
                result.get(field).add(getValue(item, field));
            });
        });
        return result;
    }

    /**
     * 首字母大写
     *
     * @param str 源字符串
     * @return 首字母大写后的字符串
     */
    public static String initialToUpper(final String str) {
        char c = str.charAt(0);
        String s = ("" + c).toUpperCase();
        return s + str.substring(1);
    }

    /**
     * 匹配数据
     *
     * @param extend   扩展的集合
     * @param source   数据集合
     * @param setFidel 扩展集合中数据的字段
     * @param fidels   匹配规则，长度2,0为扩展集合内字段，1为数据中字段
     * @param <T>      扩展集合的类型
     * @param <Y>      数据集合的类型
     */
    public static <T, Y> List<T> pairing(List<T> extend, List<Y> source, String setFidel, String[] fidels) {
        if (extend.isEmpty() || source.isEmpty()) {
            return extend;
        }
        Map<Object, Y> yMap = new HashMap<>(8);
        source.forEach(sou -> {
            Object o = getValue(sou, fidels[1]);
            if (o instanceof Number) {
                o = ((Number) o).longValue();
            }
            yMap.put(o, sou);
        });
        extend.forEach(ext -> {
            try {
                Object o = getValue(ext, fidels[0]);
                if (o instanceof Number) {
                    o = ((Number) o).longValue();
                }
                setValue(ext, setFidel, yMap.get(o));
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        return extend;
    }

    public static <T, Y> List<T> pairing(List<T> extend, List<Y> source, Setter<T> sourceSet, Getter<T> extendGet, Getter<Y> sourceGet) {
        if (extend.isEmpty() || source.isEmpty()) {
            return extend;
        }
        Map<Object, Y> yMap = new HashMap<>(8);
        source.forEach(sou -> {
            Object o = sourceGet.get(sou);
            if (o instanceof Number) {
                o = ((Number) o).longValue();
            }
            yMap.put(o, sou);
        });
        extend.forEach(ext -> {
            try {
                Object o = extendGet.get(ext);
                if (o instanceof Number) {
                    o = ((Number) o).longValue();
                }
                sourceSet.set(ext, yMap.get(o));
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        return extend;
    }

    /**
     * 匹配数据
     *
     * @param extend 扩展的集合
     * @param source 数据集合
     * @param from   数据对象中映射关系
     * @param goTo   扩展对象中映射关系
     * @param <T>    扩展的集合
     * @param <Y>    数据集合
     * @return
     */
    public static <T, Y> List<T> pairing(List<T> extend, List<Y> source, FieldMapper from, FieldMapper goTo) {
        if (extend.isEmpty() || source.isEmpty()) {
            return extend;
        }
        Map<Object, Object> yMap = new HashMap<>(8);
        source.forEach(item -> yMap.put(getValue(item, from.getMapperField()), getValue(item, from.getDataField())));
        extend.forEach(item -> setValue(item, goTo.getDataField(), yMap.get(getValue(item, goTo.getMapperField()))));
        return extend;
    }

    /**
     * 匹配数据
     *
     * @param extend   扩展的集合
     * @param source   数据集合
     * @param setFidel 扩展集合中数据的字段
     * @param fidels   匹配规则，长度2,0为扩展集合内字段，1为数据中字段
     * @param <T>      扩展集合的类型
     * @param <Y>      数据集合的类型
     */
    public static <T, Y> List<T> pairingO2m(List<T> extend, List<Y> source, String setFidel, String[] fidels) {
        if(extend.isEmpty()){
            return extend;
        }
        Class setFidelClass = getFieldType(extend.get(0), setFidel);
        boolean assignableFrom = Collection.class.isAssignableFrom(setFidelClass);
        if(!assignableFrom){
            throw new RuntimeException("目标属性不是集合");
        }
        Map<Object, Object> dataMap = new HashMap<>(16);
        source.forEach(item -> {
            try {
                Object o = getValue(item, fidels[1]);
                if(o instanceof Number){
                    o = ((Number) o).longValue();
                }
                Collection collection = (Collection) dataMap.get(o);
                if(collection == null){
                    Class c = COLLECTION_MAP.get(setFidelClass);
                    Constructor constructor = c.getConstructor(int.class);
                    collection = (Collection) constructor.newInstance(8);
                    dataMap.put(o, collection);
                }
                collection.add(item);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        extend.forEach(item -> {
            Object o = getValue(item, fidels[0]);
            if(o instanceof Number){
                o = ((Number) o).longValue();
            }
            setValue(item, setFidel, dataMap.get(o));
        });
        return extend;
    }

    public static <T, Y> List<T> pairingO2m(List<T> extend, List<Y> source, Setter<T> sourceSet, Getter<T> extendGet, Getter<Y> sourceGet, Class extendClass) {
        if(extend.isEmpty()){
            return extend;
        }
        Map<Object, Object> dataMap = new HashMap<>(16);
        source.forEach(item -> {
            try {
                Object o = sourceGet.get(item);
                if(o instanceof Number){
                    o = ((Number) o).longValue();
                }
                Collection collection = (Collection) dataMap.get(o);
                if(collection == null){
                    Class c = COLLECTION_MAP.get(extendClass);
                    Constructor constructor = c.getConstructor(int.class);
                    collection = (Collection) constructor.newInstance(8);
                    dataMap.put(o, collection);
                }
                collection.add(item);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        extend.forEach(item -> {
            Object o = extendGet.get(item);
            if(o instanceof Number){
                o = ((Number) o).longValue();
            }
            sourceSet.set(item, dataMap.get(o));
        });
        return extend;
    }

    /**
     * 查询
     * @param collection
     * @param getter
     * @param os
     * @param <T>
     * @return
     */
    public static <E, T> List<E> select(Collection<E> collection, Getter getter, Collection<T> os){
        List<E> ts = new ArrayList<>();
        Set<Object> oSet = os.stream().collect(Collectors.toSet());
        collection.forEach(item -> {
            T t = (T) getter.get(item);
            if(oSet.contains(item)){
                ts.add(item);
            }
        });
        return ts;
    }

    /**
     * 一堆多匹配数据
     * @param <T>
     * @param <Y>
     * @param extend
     * @param pairingMappers
     * @return
     */
    public static <T, Y> List<T> pairing(List<T> extend, List<PairingMapper> pairingMappers) {
        List<Map<Object, Object>> maps = new ArrayList<>();
        int length = pairingMappers.size();
        for (int i = 0; i < length; i++) {
            PairingMapper pairingMapper = pairingMappers.get(i);
            Map<Object, Object> map = new HashMap<>(8);
            maps.add(map);

        }
        for (int i = 0; i < length; i++) {
            PairingMapper pairingMapper = pairingMappers.get(i);
            int j = i;
            pairingMapper.getDatas().forEach(item -> {
                maps.get(j).put(getValue(item, pairingMapper.getDataLogo()), getValue(item, pairingMapper.getFormField()));
            });

        }

        extend.forEach(item -> {
            for (int i = 0; i < length; i++) {
                PairingMapper pairingMapper = pairingMappers.get(i);
                setValue(item, pairingMapper.getGoToField(), maps.get(i).get(getValue(item, pairingMapper.getExtendLogo())));
            }

        });
        return extend;
    }

    /**
     * 用来测试方法计时
     *
     * @param function
     */
    public static void test(Function function, boolean b) {
        long start = System.currentTimeMillis();
        Object o = function.apply(null);
        if (b) {
            System.out.println(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    /**
     * 父类转子类
     *
     * @param parent    基类对象
     * @param childType 派生类类型
     * @param <T>       基类对象类型
     * @param <Y>       派生类类型
     * @return 派生类实例
     */
    public static <T, Y extends T> Y parentToChild(T parent, Class<Y> childType) {
        try {
            Y y = childType.newInstance();
            Class tc = parent.getClass();
            Field[] parentFields = tc.getDeclaredFields();
            for (Field field : parentFields) {
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                setValue(y, field.getName(), getValue(parent, field.getName()));
            }
            return y;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 父类转子类
     *
     * @param parents   基类对象集合
     * @param childType 派生类类型
     * @param <T>       基类对象类型
     * @param <Y>       派生类类型
     * @return 派生类实例
     */
    public static <T, Y extends T> List<Y> parentsToChilds(List<T> parents, Class<Y> childType) {
        List<Y> ys = new ArrayList<>();
        if (parents.isEmpty()) {
            return new ArrayList<>();
        }
        Class<?> parentClass = parents.get(0).getClass();
        Field[] parentFields = parentClass.getDeclaredFields();
        try {
            parents.forEach(item -> {
                Y y = null;
                try {
                    y = childType.newInstance();
                    for (Field field : parentFields) {
                        if (Modifier.isStatic(field.getModifiers())) {
                            continue;
                        }
                        setValue(y, field.getName(), getValue(item, field.getName()));
                    }
                    ys.add(y);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            return ys;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T, Y> List<Y> copyProperty(List<T> parents, Class<Y> childType) {
        List<Y> ys = new ArrayList<>();
        if (parents.isEmpty()) {
            return new ArrayList<>();
        }
        Class<?> parentClass = parents.get(0).getClass();
        Field[] parentFields = getAllFields(parentClass);
        try {
            parents.forEach(item -> {
                Y y = null;
                try {
                    y = childType.newInstance();
                    for (Field field : parentFields) {
                        if (Modifier.isStatic(field.getModifiers())) {
                            continue;
                        }
                        setValue(y, field.getName(), getValue(item, field.getName()));
                    }
                    ys.add(y);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            return ys;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 自动判断ids是否为空，为null则返回空对象或者空集合
     * @param ids
     * @param function
     * @param <T>
     * @param <Y>
     * @return
     */
    public static <T, Y> T executeQueryByIds(Collection<Y> ids, Class<T> returnClass, Function<Collection<Y>, ? extends T> function){

        if(ids.isEmpty()){

            try {
                Class collection = COLLECTION_MAP.get(returnClass);
                if(collection != null){
                    returnClass = collection;
                }
                return (T) returnClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return function.apply(ids);
    }

    /**
     * 没有注释，自己阅读
     * @param t       t
     * @param fields  fields
     * @return        Object
     */
    public static <T> Object getNoErrorValue(T t, String fields) {

        if(t == null){
            return t;
        }
        int index = fields.indexOf(".");
        boolean isLast = index < 0;
        String field;
        if(isLast){
           field = fields;
        }else{
            field = fields.substring(0, index);
        }
        Class<?> clazz = t.getClass();
        Object o;
        try {
            Field fieldObject = clazz.getDeclaredField(field);
            fieldObject.setAccessible(true);
            o = fieldObject.get(t);
        } catch (Exception e) {
            o = getValue(t, field);
        }
        if(isLast){
            return o;
        }else{
            return getNoErrorValue(o, fields.substring(index + 1));
        }
    }

    public static <T, Y> Y getNoErrorValue(T t, String fields, Class<Y> y) {
        Object result = getNoErrorValue(t, fields);
        return y.cast(result);
    }


    public static Field[] getAllFields(Class clazz){
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null){
            fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        return fieldList.toArray(fields);
    }

    /**
     * 匹配规则
     */
    @FunctionalInterface
    public interface Getter<T>{
        /**
         * 获取数据
         * @param t
         * @return
         */
        Object get(T t);
    }

    @FunctionalInterface
    public interface Setter<T>{
        /**
         * 得到数据
         * @param t
         * @param o
         * @return
         */
        void set(T t, Object o);
    }

}

enum MethodPrefix {
    GET("get"), SET("set");

    private String value;

    private MethodPrefix(String prefix) {
        this.value = prefix;
    }

    public String getValue() {
        return value;
    }

}

