package com.example.SpringBackend.database.repos;

import java.util.List;

import com.example.SpringBackend.database.entities.Residents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResidentRepo extends JpaRepository<Residents, Long> {

    @Query(value = "select t.* from residences r,residents t where t.residence_ref = r.residence_id and flat_no = ?1",
        nativeQuery = true)
    List<Residents> findByFlatNo(String flatNo);

    @Query(value = "select t.* from residences r,residents t where t.residence_ref = r.residence_id and r.tower_ref = ?1",
        nativeQuery = true)
    List<Residents> findByTowerId(int towerId);
    
}
