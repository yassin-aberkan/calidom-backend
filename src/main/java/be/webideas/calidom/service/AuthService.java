package be.webideas.calidom.service;

import be.webideas.calidom.config.JwtService;
import be.webideas.calidom.model.Role;
import be.webideas.calidom.model.User;
import be.webideas.calidom.model.auth.AuthRequest;
import be.webideas.calidom.model.auth.AuthResponse;
import be.webideas.calidom.model.auth.RegisterRequest;

import be.webideas.calidom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .gender(request.getGender())
                .dateBirth(request.getDateBirth())
                .build();
        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return AuthResponse.builder()
                .accessToken(token)
                .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        String token = jwtService.generateToken(user);

        return AuthResponse.builder()
                .accessToken(token)
                .build();
    }

    }
