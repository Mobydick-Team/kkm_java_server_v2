package com.kkm.kkm_server_v2.Repository;

import com.kkm.kkm_server_v2.Domain.Post;
import com.kkm.kkm_server_v2.Domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByK_id(long k_id);
    @Query("update Users set k_img_url=:k_img_url where IFNULL(k_id, 0)=:k_id")
    void updateKImg(String k_img_url, long k_id);

}
