package pl.sda.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;


import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhiproundDto {

    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal goal;

    private String description;
}
