package com.rest;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
//import javax.ws.rs.FormParam;//获取表单参数  
import javax.ws.rs.Produces;  
//import javax.ws.rs.core.Context;//请求上下文HttpServletRequest  
//import javax.ws.rs.QueryParam;//用于获取数据库查询参数  
@Path("userservice")  
public class UserService {  
    /** 
     * 初始化用户数据 
     */  
    static Map<Integer,Object> map=new HashMap<Integer, Object>();  
      
    static{  
        User user1=new User("linda","623423","163242@ms.com",23,"female");  
        map.put(1, user1);  
        User user2=new User("veppa","734423","7d3242@ms.com",21,"male");  
        map.put(2, user2);  
        User user3=new User("nokka","973423","1fddf2@ms.com",23,"female");  
        map.put(3, user3);  
    }  
      
    /** 
     * 获取指定Id的用户信息 
     * @param id 
     * @return 
     */  
    @GET  
    @Path("user/{id}")  
    @Produces("application/json")  
    public User getById(@PathParam("id") Integer id) {  
        return (User) map.get(id);  
    }  
      
    /** 
     * 获取所有用户列表的JSON数据 
     * @return 
     */  
    @GET  
    @Path("users")  
    @Produces("application/json")  
    public List<User> getUsers() {  
        List<User> users=new ArrayList<User>();  
        for(Integer index: map.keySet()){  
            User user=(User) map.get(index);  
            users.add(user);  
        }  
        return users;   
    }  
      
    /** 
     * 获取的用户传入的信息 
     * @param msg 
     * @return 
     */  
    @GET  
    @Path("user/trans/{msg}")  
    public String  getMessage(@PathParam("msg") String msg) {  
        return "[Hello dear! ]"+",MSG:{"+msg+"}";  
    }  
  
  
} 