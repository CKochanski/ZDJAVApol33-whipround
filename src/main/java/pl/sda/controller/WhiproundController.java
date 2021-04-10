package pl.sda.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.model.dto.WhiproundDto;
import pl.sda.service.WhiproundService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WhiproundController {

    private final WhiproundService whiproundService;

    @GetMapping("/whiprounds")
    public List<WhiproundDto> getAllWhiprounds (){
        return whiproundService.getAllWhipround();
    }

}
