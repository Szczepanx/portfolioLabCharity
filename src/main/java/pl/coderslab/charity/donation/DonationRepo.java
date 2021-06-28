package pl.coderslab.charity.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.nio.file.attribute.UserPrincipalLookupService;

public interface DonationRepo extends JpaRepository<Donation,Long> {

//    @Query(value = "select max (id) from Donation")
//    Long findMax();
//    Long countDonationByQuantity();
    @Query("select SUM(d.quantity) from Donation d")
    String findSumOfQuantity();

    @Query("select max(e.id) from Donation e")
    String findMaxId();
}
