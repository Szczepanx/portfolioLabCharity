package pl.coderslab.charity.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category ,Long> {


//    Category findById(String s);

//    Category findAllByName(String s);

//    Category findAllById(String s);
@Query("select s.name from Category s")
List<String> getAllNames();
//    Category findByName(String s);
}
