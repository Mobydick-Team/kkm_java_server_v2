package com.kkm.kkm_server_v2.Controller;

import com.kkm.kkm_server_v2.Domain.Users;
import com.kkm.kkm_server_v2.Repository.UserRepository;
import com.kkm.kkm_server_v2.Service.JwtService;
import com.kkm.kkm_server_v2.Service.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
public class OAuthController {
    @Autowired
    private KakaoService kakaoService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
@RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
public Users Users(Users users)throws Exception{
    Users newUser = userRepository.save(users);
    return newUser;

}
    // kakao user info 받기
    @RequestMapping(value = "/user/getKakaoUserInfo", method = RequestMethod.GET)
    public Map<String, Object> GetKakaoUserInfo(@RequestParam(value = "code", required = true) String code) throws Exception {
        Map<String, Object> userInfo = kakaoService.getUserInfo(kakaoService.getAccessToken(code)); // 액세스 토큰으로 카카오 사용자 정보 얻기
        return userInfo;
    }
//
//    // user가 회원가입 되어 있는지 체크 후 true라면 로그인 처리 + JWT token 발급 false라면 회원가입 절차
    @RequestMapping(value = "/user/kakaoLogin", method = RequestMethod.POST)
    public String KakaoLogin(@RequestParam(value = "k_id", required = true) String kId) throws Exception {
        Users exist = userRepository.findByKId(kId); // user table에 존재하면 존재하는 정보, 존재하지 않으면
        Map<String, Object> userInfo = kakaoService.getUserInfoById(kId);
        String current_profile_img = userInfo.get("k_img_url").toString().replace("\"", "");
        if (exist == null) { // 회원 가입이 안 되어 있다면
            return "guest";
        } else { // 회원 가입이 되어있다면 JWT token 보내줘야 함
            if (!current_profile_img.equals(exist.getKImgUrl().toString())) {
                userRepository.updateKImg(userInfo.get("k_img_url").toString().replace("\"", ""), kId);
            }

            Users user = new Users(exist.getUserId(),
                    exist.getNickname(),
                    exist.getKId(),
                    current_profile_img,
                    exist.getLat(),
                    exist.getLon(),
                    exist.getAddress(),
                    exist.getKkm());

            String token = jwtService.createJWT(user);
            return token;
        }
    }
//
//    // user 정보를 받아 회원가입
//    @ResponseBody
//    @RequestMapping(value = "/user/join", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
//    public String Join(@ModelAttribute Users user) throws Exception {
//        userRepository.save(user);
//        String token = jwtService.createJWT(user);
//        return token;
//    }
//
//    //token 확인
//    @ResponseBody
//    @RequestMapping(value = "/checkJWT", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
//    public Map<String, Object> CheckJWT(@RequestParam String token) throws Exception {
//        Map<String, Object> check = jwtService.checkJWT(token);
//        if (check == null) {
//            return check;
//        } else {
//            return check;
//        }
//    }
//
//    @RequestMapping(value = "/getUserId", method = RequestMethod.GET)
//    public long GetUserId(@RequestParam long k_id) throws Exception {
//        Map<String, Object> user = userRepository.findByK_id(String.valueOf(k_id));
//        return (long) user.get("user_id");
//    }

//    @RequestMapping(value = "/getUserProfile/{post_id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
//    public List<Map<String, Object>> GetUserProFile(@PathVariable("post_id") long post_id) throws Exception {
//        return userRepository.getUserProfile(post_id);
//
//    }


//    @ResponseBody
//    @RequestMapping(value = "/user/update", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
//    public String userUpdate(@RequestParam("user_id") long user_id, @RequestParam("nickname") String nickname, @RequestParam("lat") double lat, @RequestParam("lon") double lon, @RequestParam("address") String address) throws Exception {
//        userRepository.updateUser(user_id, nickname, lat, lon, address);
//        return "success";
//    }

//    @RequestMapping(value = "/getUserInfo/{user_id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
//    public List<Map<String, Object>> GetUserInfo(@PathVariable("user_id") long user_id) throws Exception {
//        return userRepository.getUserInfo(user_id);
//    }

//    @RequestMapping(value = "/getKKM/{user_id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
//    public String GetKKM(@PathVariable("user_id") long user_id, @Param("value") int value) throws Exception {
//        userRepository.getKKM(user_id, value);
//        return "success";
//    }
}