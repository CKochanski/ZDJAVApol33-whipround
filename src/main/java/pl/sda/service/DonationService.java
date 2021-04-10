package pl.sda.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.sda.exception.WhiproundNotFoundException;
import pl.sda.model.Donation;
import pl.sda.model.Whipround;
import pl.sda.model.dto.DonationDto;
import pl.sda.model.dto.WhiproundDto;
import pl.sda.repository.DonationRepository;
import pl.sda.repository.WhiproundRepository;

@Service
@RequiredArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;
    private final WhiproundRepository whiproundRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public Long createDonation(DonationDto donation) {
        Donation savedDonation = modelMapper.map(donation, Donation.class);
        savedDonation.setWhipround(getWhiproundFromDBById(donation.getWhiproundId()));
        return donationRepository.save(savedDonation).getId();
    }

    private Whipround getWhiproundFromDBById(Long id) {
        return whiproundRepository.findById(id).orElseThrow(()
                -> new WhiproundNotFoundException("Whipround with following id not found: " + id));
    }

}
