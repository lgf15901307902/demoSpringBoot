package net.xdclass.demo.seach.utils;

import java.io.IOException;
 
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.xdclass.demo.task.domain.User;

public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();
    
    public static void main(String[] args) {
		User user = new User();
		user.setAge(1);
		user.setPhone("110");
		String obj2String = JsonUtils.obj2String(user.getClass());
		System.out.println(obj2String);
		User string2Obj = JsonUtils.string2Obj(obj2String, User.class);
		System.out.println(string2Obj);
	}
    //对象转字符串
    public static <T> String obj2String(T obj){
        if (obj == null){
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //字符串转对象
    public static <T> T string2Obj(String str,Class<T> clazz){
        if (StringUtils.isEmpty(str) || clazz == null){
            return null;
        }
        try {
            return clazz.equals(String.class)? (T) str :objectMapper.readValue(str,clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
