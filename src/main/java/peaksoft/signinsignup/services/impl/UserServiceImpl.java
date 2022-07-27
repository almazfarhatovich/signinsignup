package peaksoft.signinsignup.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.signinsignup.dto.AuthRequest;
import peaksoft.signinsignup.dto.AuthResponse;
import peaksoft.signinsignup.dto.mapper.UserEditMapper;
import peaksoft.signinsignup.dto.mapper.UserViewMapper;
import peaksoft.signinsignup.dto.user.UserRequest;
import peaksoft.signinsignup.dto.user.UserResponse;
import peaksoft.signinsignup.exceptions.IsEmptyException;
import peaksoft.signinsignup.models.User;
import peaksoft.signinsignup.repositories.UserRepository;
import peaksoft.signinsignup.security.JwtUtils;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepo;
    private final JwtUtils jwtUtils;
    private final UserEditMapper editMapper;
    private final UserViewMapper viewMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponse create(UserRequest request) {
        if (userRepo.existsByEmail(request.getEmail())) {
            throw new IsEmptyException(
                    "this email is already have in!"
            );
        }
        User user = editMapper.create(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepo.save(user);
        return viewMapper.viewUser(user);
    }



    public AuthResponse authenticate(AuthRequest authRequest) {
        User user = userRepo.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException(
                        "user with email = " + authRequest.getEmail() + " not found!"
                ));

        if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialsException(
                    "invalid password"
            );
        }
        String jwt = jwtUtils.generateJwt(user);

        return new AuthResponse(user.getId(),
                user.getEmail(),
                jwt,
                user.getRole()
        );

    }
}

