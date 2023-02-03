package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataDummy {

    public int basariliStatusCode = 200;
    public String contentType = "application/json";

    }

    /*
    {
    "status":"success",
@@ -40,5 +45,27 @@ public JSONObject expectedBodyOlusturJson (){

        return expBody;
    }
    public HashMap innerBodyOlusturMap (){

        HashMap<String ,Object> innerBodyMap = new HashMap<>();

        innerBodyMap.put("id",3.0);
        innerBodyMap.put("employee_name","Ashton Cox");
        innerBodyMap.put("employee_salary",86000.0);
        innerBodyMap.put("employee_age",66.0);
        innerBodyMap.put("profile_image","");

        return innerBodyMap;
    }

    public HashMap expectedBodyOlusturMap(){

        HashMap<String ,Object> expBody = new HashMap<>();

        expBody.put("status","success");
        expBody.put("message","Successfully! Record has been fetched.");
        expBody.put("data",innerBodyOlusturMap());

        return expBody;
    }
}