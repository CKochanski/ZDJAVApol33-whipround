package pl.sda.model.dto;

import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;


@Value
public class NewWhiproundDto {

    @NotNull
    LocalDate startDate;

    @NotNull
    LocalDate endDate;

    @NotNull
    BigDecimal goal;

    @NotNull
    String description;

}
