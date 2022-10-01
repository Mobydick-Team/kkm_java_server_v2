//package com.kkm.kkm_server_v2.Repository;
//
//import com.kkm.kkm_server_v2.Domain.Users;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Map;
//
//@Repository
//public interface UserRepository extends JpaRepository<Users,Long> {
//
//    Map<String,Object> findByK_id(String k_id);
//
//    @Query("update Users u set u.k_img_url =:k_img_url where coalesce(u.k_id,0)=:k_id")
//    void updateKImg(String k_img_url, long k_id);
//    @Query("select u.nickname,u.k_img_url,u.address,u.kkm from Users u where u.user_id=:user_id")
//    Map<String,Object> getUserInfo(long user_id);
////    @Query("select u.nickname,u.k_img_url from Users u\n" +
////            "inner join Post on Post.post_owner_id=Users.user_id\n" +
////            "where Post.post_id =#{post_id}")
//}
