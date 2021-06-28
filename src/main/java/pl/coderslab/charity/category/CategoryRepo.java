package pl.coderslab.charity.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepo extends JpaRepository<Category ,Long> {

    @Query("select s.name from Category s")
    String [] findAllByName();
}
