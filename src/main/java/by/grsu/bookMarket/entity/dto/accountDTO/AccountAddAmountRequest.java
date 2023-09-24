package by.grsu.bookMarket.entity.dto.accountDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountAddAmountRequest {
    private String mail;
    private double amount;
}
