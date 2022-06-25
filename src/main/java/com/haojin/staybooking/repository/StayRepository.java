package com.haojin.staybooking.repository;

import com.haojin.staybooking.model.Stay;
import com.haojin.staybooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StayRepository extends JpaRepository<Stay, Long> {
    List<Stay> findByHost(User user);
    //id + user(double insurance)
    Stay findByIdAndHost(Long id, User user);

    List<Stay> findByIdInAndGuestNumberGreaterThanEqual(List<Long> ids, int guestNumber);


}
