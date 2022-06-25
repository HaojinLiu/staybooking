package com.haojin.staybooking.repository;

import com.haojin.staybooking.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
    Authority findAuthorityByUsername(String username);
    //authority去判断是否可以访问，后期用filter检测是否有token等合法性

}
