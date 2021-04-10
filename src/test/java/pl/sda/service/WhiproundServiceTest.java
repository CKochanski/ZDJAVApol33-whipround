package pl.sda.service;

import org.junit.jupiter.api.Test;
import pl.sda.repository.DonationRepository;
import pl.sda.repository.WhiproundRepository;

import static org.mockito.Mockito.mock;

public class WhiproundServiceTest {

    private final WhiproundRepository whiproundRepository = mock(WhiproundRepository.class);
    private final DonationRepository donationRepository = mock(DonationRepository.class);
    private final WhiproundService subject = new WhiproundService(whiproundRepository,donationRepository);

    @Test
    public void shoudGetAllNotFinishedWhiprounds(){


    }



}
