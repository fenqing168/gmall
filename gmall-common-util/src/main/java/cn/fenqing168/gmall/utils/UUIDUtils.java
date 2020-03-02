package cn.fenqing168.gmall.utils;

import java.util.UUID;

/**
 * @author fenqing
 */
public class UUIDUtils {


    /**
     * 获得一个去掉"-"符号的UUID
     * @return
     */
    public static String uuid(){
        String s= UUID.randomUUID().toString();
        return s.replace("-", "");
    }

}
