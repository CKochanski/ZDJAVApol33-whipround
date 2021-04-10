package pl.sda.controller;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.model.dto.DonationDto;
import pl.sda.service.DonationService;
import pl.sda.service.WhiproundService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class DonationController {

    private final DonationService donationService;

    @PostMapping("/donation")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createDonation(@Valid @RequestBody DonationDto donation) {
        return donationService.createDonation(donation);
    }

}
