package com.sm.demo.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sm.demo.dto.ext.UserExt;
import com.sm.demo.models.ERole;
import com.sm.demo.models.Role;
import com.sm.demo.models.User;
import com.sm.demo.payload.request.LoginRequest;
import com.sm.demo.payload.request.SignupRequest;
import com.sm.demo.payload.response.MessageResponse;
import com.sm.demo.payload.response.UserInfoResponse;
import com.sm.demo.repository.RoleRepository;
import com.sm.demo.repository.UserRepository;
import com.sm.demo.security.jwt.JwtUtils;
import com.sm.demo.security.services.UserDetailsImpl;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder encoder;

  @Autowired
  private JwtUtils jwtUtils;

//  @Autowired
//  private LoginService loginService;
  
  @PostMapping("/login")
  public String loginUser(@Valid @RequestBody LoginRequest loginRequest) {
	  Gson gson = new Gson();
	  Optional<User> t = userRepository.findByUsername(loginRequest.getUsername());
	  String user = "";
	  UserExt token = new  UserExt();
	  if(!ObjectUtils.isEmpty(t)) {
		  token.setUserName(t.get().getUsername());
		  token.setToken(jwtUtils.generateTokenFromUsername(loginRequest.getUsername()));
		  user = gson.toJson(token).toString();
	  } else {
		  user = gson.toJson("").toString();
	  }
      return user;
  }
  @GetMapping("/login")
  public String loginUser1(@Valid @RequestBody LoginRequest loginRequest) {
	  Gson gson = new Gson();
//      System.out.println(gson.toJson(userRepository.findByUsername(loginRequest.getUsername()).get()));
	  Optional<User> t = userRepository.findByUsername(loginRequest.getUsername());
	  String user = "";
	  if(!ObjectUtils.isEmpty(t)) {
		  user = gson.toJson(t.get()).toString();
	  } else {
		  user = gson.toJson("").toString();
	  }
      
      return user;
  }
//  @PostMapping("/signin")
//  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//    Authentication authentication = authenticationManager
//        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//    SecurityContextHolder.getContext().setAuthentication(authentication);
//
//    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//
//    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
//
//    List<String> roles = userDetails.getAuthorities().stream()
//        .map(item -> item.getAuthority())
//        .collect(Collectors.toList());
//
//    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
//        .body(new UserInfoResponse(userDetails.getId(),
//                                   userDetails.getUsername(),
//                                   userDetails.getEmail(),
//                                   roles));
//  }
//
//  @PostMapping("/signup")
//  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
//    }
//
//    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
//    }
//
//    // Create new user's account
//    User user = new User(signUpRequest.getUsername(),
//                         signUpRequest.getEmail(),
//                         encoder.encode(signUpRequest.getPassword()));
//
//    Set<String> strRoles = signUpRequest.getRole();
//    Set<Role> roles = new HashSet<>();
//
//    if (strRoles == null) {
//      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//      roles.add(userRole);
//    } else {
//      strRoles.forEach(role -> {
//        switch (role) {
//        case "admin":
//          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(adminRole);
//
//          break;
//        case "mod":
//          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(modRole);
//
//          break;
//        default:
//          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(userRole);
//        }
//      });
//    }
//
//    user.setRoles(roles);
//    userRepository.save(user);
//
//    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//  }
//
//  @PostMapping("/signout")
//  public ResponseEntity<?> logoutUser() {
//    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
//    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
//        .body(new MessageResponse("You've been signed out!"));
//  }
}
