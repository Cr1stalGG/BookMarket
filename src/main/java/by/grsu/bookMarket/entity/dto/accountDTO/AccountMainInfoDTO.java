package by.grsu.bookMarket.entity.dto.accountDTO;

import by.grsu.bookMarket.entity.dto.bookDTO.BoughtBookMainInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountMainInfoDTO {
    private String mail;
    private List<BoughtBookMainInfoDTO> boughtBooks;
    private double amount;
}
