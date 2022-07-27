package peaksoft.signinsignup.apis;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.signinsignup.dto.AuthRequest;
import peaksoft.signinsignup.dto.AuthResponse;
import peaksoft.signinsignup.dto.user.UserRequest;
import peaksoft.signinsignup.dto.user.UserResponse;
import peaksoft.signinsignup.services.impl.UserServiceImpl;

@RestController
@RequestMapping("domain/api/public")
@RequiredArgsConstructor
public class AuthApi {
    private final UserServiceImpl service;

    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public UserResponse register(@RequestBody UserRequest request) {
        return service.create(request);
    }

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) {
        return service.authenticate(authRequest);
    }
}