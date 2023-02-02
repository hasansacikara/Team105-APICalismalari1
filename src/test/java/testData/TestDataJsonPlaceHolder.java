package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataJsonPlaceHolder {

    public int basariliStatusCode = 200;
  public JSONObject requestBodyOlusturJSON (){

        return reqBodyJson;
    }


    public HashMap requestBodyOlusturMap (){

        HashMap<String,Object> requestBodyMap = new HashMap<>();

        requestBodyMap.put("title","Ahmet");
        requestBodyMap.put("body","Merhaba");
        requestBodyMap.put("userId",10.0);
        requestBodyMap.put("id",70.0);

        return requestBodyMap;
    }



}