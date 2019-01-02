package cn.okuribito.service.impl;

import cn.okuribito.aop.ParamHandler;
import cn.okuribito.model.model0;
import cn.okuribito.service.WebSocketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiuBuhe
 */
@Service
public class WebSocketServiceImpl implements WebSocketService {

    @ParamHandler("one")
    public List<Map<String, Object>> getResult(String pa1, Integer pa2, model0 model) {
        ArrayList<Map<String,Object>> arrayList = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put(pa1,model);
        arrayList.add(map);
        Map<String,Object> map1 = new HashMap<>();
        map1.put(pa1,model);
        arrayList.add(map1);
        return arrayList;
    }
}
