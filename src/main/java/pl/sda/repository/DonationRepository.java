package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}
