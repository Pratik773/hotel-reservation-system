package com.hotel.repository;

import java.util.List;
import com.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface HotelRepository extends JpaRepository<Hotel, Long> { //no class because Spring Data JPA generates the implementation at runtime.
    List<Hotel> findByCity(String city);
}
