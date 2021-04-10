package pl.sda.service;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.sda.model.dto.WhiproundDto;
import pl.sda.repository.WhiproundRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WhiproundService {

    private final WhiproundRepository whiproundRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<WhiproundDto> getAllWhipround (){
        return whiproundRepository.findAll().stream()
                .map(whipround -> modelMapper.map(whipround, WhiproundDto.class))
                .collect(Collectors.toList());
    }
}
