package com.example.ex0419;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonActivity extends AppCompatActivity {

    TextView tvJSON;

    RequestQueue queue;
    StringRequest request;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        tvJSON = findViewById(R.id.tvJSON);

        queue = Volley.newRequestQueue(JsonActivity.this);

        int method = Request.Method.GET;
        String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220418";

        request = new StringRequest(
                method,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //1.문자열 데이터 - >JSON 객체로 변환
                            JSONObject obj = new JSONObject(response);
                            //2.JSON 객체에서 "boxOfficeResult"로 데이터 접근
                            JSONObject result = obj.getJSONObject("boxOfficeResult");
                            //3.접근한 데이터("JSONObject")에서 "dailyBoxOfficeList"로 JSONArray 데이터 접급
                            JSONArray jsonArr = result.getJSONArray("dailyBoxOfficeList");
//                          String data = "";

                            //대량의 텍스트를 다룰 때 사용하는 객체
                            StringBuffer sb = new StringBuffer();

                            for(i = 0; i < jsonArr.length(); i++) {
                                JSONObject movie = jsonArr.optJSONObject(i);

                                String rank = movie.getString("rank");
                                String movieNm = movie.getString("movieNm");

//                              data += rank + "." + movieNm + "\n";
                                sb.append(rank);
                                sb.append(".");
                                sb.append(movieNm);
                                sb.append("\n");
                            }
                            //4.영화순위(rank), 영화명(movieNm)를 텍스트뷰에 출력
                            tvJSON.setText(sb.toString());
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(JsonActivity.this,
                                error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );


        queue.add(request);
    }
}