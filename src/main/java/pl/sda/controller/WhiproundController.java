package pl.sda.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.model.dto.NewWhiproundDto;
import pl.sda.model.dto.WhiproundDto;
import pl.sda.service.WhiproundService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WhiproundController {

    private final WhiproundService whiproundService;

    @GetMapping("/whiprounds")
    public List<WhiproundDto> getAllWhiprounds (){
        return whiproundService.getAllWhipround();
    }

    @PostMapping("/whipround")
    @ResponseStatus(HttpStatus.CREATED)
    public WhiproundDto saveWhipround(@Valid @RequestBody NewWhiproundDto whipround) {
        return whiproundService.createWhipround(whipround);
    }

}
