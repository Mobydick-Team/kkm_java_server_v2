package com.kkm.kkm_server_v2.domian.auth.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kkm.kkm_server_v2.domian.auth.presentation.dto.response.KakaoUserInfoResponse;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class KakaoAuthService {
    private static final String reqURL = "https://kauth.kakao.com/oauth/token";

    public String getAccessToken(String auth_code) {
        String accessToken = "";

        try {
            URL url = new URL(reqURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();

            sb.append("grant_type=authorization_code");
            sb.append("&client_id=9240bec26b639066d5ac5afdbaeb6bb0"); // 본인이 발급받은 key
            sb.append("&redirect_uri=http://localhost:3000/auth/kakao/callback"); // 본인이 설정해 놓은 경로
            sb.append("&code=").append(auth_code);
            bw.write(sb.toString());
            bw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder result = new StringBuilder();

            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result.toString());

            accessToken = element.getAsJsonObject().get("access_token").getAsString();
            br.close();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return accessToken;
    }


    public KakaoUserInfoResponse getUserInfo(String access_token) throws IOException {
        String host = "https://kapi.kakao.com/v2/user/me";
        KakaoUserInfoResponse response = null;
        try {
            URL url = new URL(host);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Bearer " + access_token);
            urlConnection.setRequestMethod("GET");
            int responseCode = urlConnection.getResponseCode();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            StringBuilder res = new StringBuilder();
            while ((line = br.readLine()) != null) {
                res.append(line);
            }


            JsonParser parser = new JsonParser();
            JsonObject obj = (JsonObject) parser.parse(res.toString());

            Long userId = Long.valueOf(obj.get("id").toString());
            response = KakaoUserInfoResponse.builder()
                    .userId(userId)
                    .build();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }


    public Map<String, Object> getUserInfoById(String userId) throws IOException {
        String host = "https://kapi.kakao.com/v2/user/me";
        Map<String, Object> result = new HashMap<>();
        try {
            URL url = new URL(host + "?secure_resource=false&property_keys=%5B%22properties.profile_image%22%5D&target_id_type=user_id&target_id=" + userId);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Authorization", "KakaoAK " + "58c4971e0d44ebafc559b0388b33dbdf");
            urlConnection.setRequestMethod("GET");

            int responseCode = urlConnection.getResponseCode();
            System.out.println("responseCode = " + responseCode);


            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            StringBuilder res = new StringBuilder();
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
            JsonParser parser = new JsonParser();
            JsonObject obj = (JsonObject) parser.parse(res.toString());
            JsonObject properties = (JsonObject) obj.get("properties");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
