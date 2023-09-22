package by.grsu.bookMarket.security.authDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountAuthRequest {
    private String mail;
    private String password;
}
