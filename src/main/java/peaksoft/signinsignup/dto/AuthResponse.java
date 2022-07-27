package peaksoft.signinsignup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import peaksoft.signinsignup.enums.Role;

@Getter
@Setter
@AllArgsConstructor
public class AuthResponse {
    private Long id;
    private String email;
    private String jwt;
    private Role role;

}