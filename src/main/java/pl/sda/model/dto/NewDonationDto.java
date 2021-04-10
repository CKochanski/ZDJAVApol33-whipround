package pl.sda.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class NewDonationDto {

    private Long id;

    private String userName;

    private BigDecimal amount;

}
