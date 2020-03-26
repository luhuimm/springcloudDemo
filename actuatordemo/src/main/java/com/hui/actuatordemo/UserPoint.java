package com.hui.actuatordemo;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Endpoint(id="user")
public class UserPoint {
    public List<Map<String,Object>> health() {
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("userId","001");
        map.put("userName","huimiao");
        list.add(map);
        return list;
    }
}
