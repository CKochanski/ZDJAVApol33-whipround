package pl.sda.service;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.sda.exception.WhiproundNotFoundException;
import pl.sda.model.Donation;
import pl.sda.model.Whipround;
import pl.sda.model.dto.NewWhiproundDto;
import pl.sda.model.dto.WhiproundDto;
import pl.sda.repository.DonationRepository;
import pl.sda.repository.WhiproundRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WhiproundService {

    private final WhiproundRepository whiproundRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final DonationRepository donationRepository;

    public List<WhiproundDto> getAllWhipround() {
        return whiproundRepository.findAll().stream()
                .map(whipround -> modelMapper.map(whipround, WhiproundDto.class))
                .collect(Collectors.toList());
    }

    public WhiproundDto createWhipround(NewWhiproundDto whipround) {
        final Whipround saveWhipround = whiproundRepository.save(modelMapper.map(whipround, Whipround.class));
        return modelMapper.map(saveWhipround, WhiproundDto.class);
    }

    public List<WhiproundDto> getAllNotFinishedWhiprounds() {
        return whiproundRepository.findAll().stream().filter(filterNotFinished())
                .map(whipround -> modelMapper.map(whipround, WhiproundDto.class))
                .collect(Collectors.toList());
    }

    private Predicate<Whipround> filterNotFinished() {
        return whipround -> {
            BigDecimal sum = donationRepository.findByWhiproundId(whipround.getId())
                    .stream()
                    .map(Donation::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            return sum.compareTo(whipround.getGoal()) < 0;
        };
    }

    public WhiproundDto getWhiproundById(Long id) {
        return whiproundRepository.findById(id).map(
                whipround -> modelMapper.map(whipround, WhiproundDto.class)).orElseThrow(() ->
                new WhiproundNotFoundException("Whipround with following id not found: " + id));
    }
}
