package pl.sda.model.dto;

import lombok.Value;


import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class WhiproundDto {

    Long id;

    LocalDate startDate;

    LocalDate endDate;

    BigDecimal goal;

    String description;
}
