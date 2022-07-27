package peaksoft.signinsignup.dto.mapper;

import org.springframework.stereotype.Component;
import peaksoft.signinsignup.dto.user.UserResponse;
import peaksoft.signinsignup.models.User;
import peaksoft.signinsignup.security.JwtUtils;


@Component
public class UserViewMapper {

    private final JwtUtils utils;

    public UserViewMapper(JwtUtils utils) {
        this.utils = utils;
    }

    public UserResponse viewUser(User user) {
        if (user == null) {
            return null;
        }
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        String jwt = utils.generateJwt(user);
        response.setJwt(jwt);
        response.setRole(user.getRole());

        return response;
    }
}