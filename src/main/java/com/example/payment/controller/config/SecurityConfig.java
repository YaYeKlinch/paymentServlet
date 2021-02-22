package com.example.payment.controller.config;

import com.example.payment.entity.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecurityConfig {
    private static final Map<String, List<String>> accessPaths = new HashMap<String, List<String>>();
    static {
        init();
    }
    private static void init(){
        List<String> notSecuredPaths = new ArrayList<>();
        notSecuredPaths.add("/login");
        notSecuredPaths.add("/registration");
        accessPaths.put("ANYONE",notSecuredPaths);

        List<String> userPaths = new ArrayList<>(notSecuredPaths);
        userPaths.add("/");
        userPaths.add("/home.jsp");
        userPaths.add("/logout");
        accessPaths.put("USER",userPaths);

        List<String>  adminPaths =   new ArrayList<>(userPaths);
        accessPaths.put("ADMIN",adminPaths);
    }
    public static List<String> getPathsForRole(Role role){
        return accessPaths.get(role.toString());
    }

    public static List<String> getPublicPaths(){
        return accessPaths.get("ANYONE");
    }
}
