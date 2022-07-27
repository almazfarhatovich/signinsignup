package peaksoft.signinsignup.dto.user;

import lombok.Getter;
import lombok.Setter;
import peaksoft.signinsignup.enums.Role;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String jwt;
    private Role role;

}
