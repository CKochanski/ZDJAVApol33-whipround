package pl.sda.service;

import org.junit.jupiter.api.Test;
import pl.sda.model.Donation;
import pl.sda.model.Whipround;
import pl.sda.model.dto.WhiproundDto;
import pl.sda.repository.DonationRepository;
import pl.sda.repository.WhiproundRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WhiproundServiceTest {

    private final WhiproundRepository whiproundRepository = mock(WhiproundRepository.class);
    private final DonationRepository donationRepository = mock(DonationRepository.class);
    private final WhiproundService subject = new WhiproundService(whiproundRepository,donationRepository);

    @Test
    public void shoudGetAllNotFinishedWhiprounds(){
        //given
        Whipround whiproundWithDonation = new Whipround(1L, LocalDate.parse("2019-06-01"), LocalDate.parse("2021-12-12"), BigDecimal.valueOf(30000), "some desc");
        List<Whipround> whiproundList = List.of(whiproundWithDonation,
        new Whipround(2L, LocalDate.parse("2018-01-01"), LocalDate.parse("2022-01-01"), BigDecimal.valueOf(100000), "another desc"));

        when(whiproundRepository.findAll()).thenReturn(whiproundList);
        when(donationRepository.findByWhiproundId(1L)).thenReturn(List.of(
           new Donation(1L,"Jan Kowalski", BigDecimal.valueOf(30000),whiproundWithDonation)
        ));
        when(donationRepository.findByWhiproundId(2L)).thenReturn(Collections.emptyList());

        //when
        List<WhiproundDto> actual = subject.getAllNotFinishedWhiprounds();

        //then
        assertThat(actual).hasSize(1);
        WhiproundDto notFinishedWhipround = actual.get(0);
        assertThat(notFinishedWhipround.getId()).isEqualTo(2L);

    }



}
