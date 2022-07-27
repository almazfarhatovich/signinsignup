package peaksoft.signinsignup.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import peaksoft.signinsignup.dto.user.UserRequest;
import peaksoft.signinsignup.enums.Role;
import peaksoft.signinsignup.models.User;

@Component
@RequiredArgsConstructor
public class UserEditMapper {
    private final PasswordEncoder encoder;

    public User create(UserRequest request) {
        if (request == null) {
            return null;
        }
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.USER);
        return user;
    }
}
