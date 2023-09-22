package by.grsu.bookMarket.security.authDTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountAuthResponse {
    private String token;
}
