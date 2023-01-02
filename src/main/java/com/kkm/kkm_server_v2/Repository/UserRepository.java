package com.kkm.kkm_server_v2.Repository;

import com.kkm.kkm_server_v2.Domain.Post;
import com.kkm.kkm_server_v2.Domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByKId(String kId);
    @Query("update Users set kImgUrl=:kImgUrl where IFNULL(kId, 0)=:kId")
    void updateKImg(String kImgUrl, String kId);

}
