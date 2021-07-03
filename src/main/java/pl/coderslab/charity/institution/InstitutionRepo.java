package pl.coderslab.charity.institution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstitutionRepo extends JpaRepository<Institution,Long> {

//    String[] findAllById(String id);

@Query("select i.name from Institution i")
    List<String> getAllNames();


}
