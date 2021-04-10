package pl.sda.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.model.Whipround;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationDto {

    @NotNull
    private String userName;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private Long whiproundId;

}
