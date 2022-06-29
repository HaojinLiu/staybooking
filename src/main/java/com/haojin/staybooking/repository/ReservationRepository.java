package com.haojin.staybooking.repository;

import com.haojin.staybooking.model.Reservation;
import com.haojin.staybooking.model.Stay;
import com.haojin.staybooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByGuest(User user);

    List<Reservation> findByStay(Stay stay);

    Reservation findByIdAndGuest(Long id, User user);

    //check whether the host could delete his stay
    List<Reservation> findByStayAndCheckoutDateAfter(Stay stay, LocalDate date);


}
