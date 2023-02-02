import org.json.JSONObject;

public class TestDataJsonPlaceHolder {

    public int basariliStatusCode = 200;
    public String contentType = "application/json; charset=utf-8";
    public String connectionHeaderDegeri = "keep-alive";

    public JSONObject expectedBodyOlusturJSON() {

        public JSONObject expectedBodyOlusturJSON () {
            return expBodyJson;
        }

        public JSONObject requestBodyOlusturJSON () {

            JSONObject reqBodyJson = new JSONObject();

            reqBodyJson.put("userId", 10);
            reqBodyJson.put("id", 70);
            reqBodyJson.put("title", "Ali");
            reqBodyJson.put("body", "Merhaba");

            return reqBodyJson;
        }
    }
}