package com.yagmur.controller;

import com.yagmur.dto.request.LoginRequestDto;
import com.yagmur.dto.request.RegisterRequestDto;
import com.yagmur.dto.response.LoginResponseDto;
import com.yagmur.dto.response.RegisterResponseDto;
import com.yagmur.entity.User;
import com.yagmur.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @PostMapping("/save")
    public User save(User user) {
        return userService.save(user);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.ok("Account created successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> doLogin(String email, String password){
        Optional<User> loggedInUser = userService.login(email, password);
        if (loggedInUser.isPresent()){
            return ResponseEntity.ok(true);
        }else {
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<Optional<User>> findById(@RequestParam Long id){
        return ResponseEntity.ok(userService.findById(id));
    }
    @GetMapping("/find-all")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<User> delete(@RequestParam Long id){
        return ResponseEntity.ok(userService.deleteById(id));
    }

    @PostMapping("/register-dto")
    public ResponseEntity<RegisterResponseDto> registerDto(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(userService.registerDto(dto));
    }
    //#Login metodunu Dto ile tekrar yazalım -> loginDto()
    @PostMapping("/login-dto")
    public ResponseEntity<LoginResponseDto> loginDto(@RequestBody LoginRequestDto dto){
      return ResponseEntity.ok(userService.loginDto(dto));
    }
    @PostMapping("/login-mapper")
    public ResponseEntity<LoginResponseDto> loginMapper(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(userService.loginMapper(dto));
    }

    @PostMapping("/register-mapper")
    public ResponseEntity<RegisterResponseDto> registerMapper(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(userService.registerMapper(dto));
    }

    @GetMapping("/find-all-by-order-by-name")
    public ResponseEntity<List<User>> findAllByOrderByNameAsc() {
        return ResponseEntity.ok(userService.findAllByOrderByNameAsc());
    }

    @GetMapping("/exists-by-name")
    public ResponseEntity<Boolean> existsByName(String name) {
        return ResponseEntity.ok(userService.existsByName(name));
    }

    @GetMapping("/find-all-by-name-containing-ignore-case")
    public ResponseEntity<List<User>> findAllByNameContainingIgnoreCase(String value) {
        return ResponseEntity.ok(userService.findAllByNameContainingIgnoreCase(value));
    }

    @GetMapping("/find-by-email-ignore-case")
    public ResponseEntity<List<User>> findByEmailIgnoreCase(String email) {
        return ResponseEntity.ok(userService.findByEmailIgnoreCase(email));
    }

    @GetMapping("/find-all-by-email-ending-with")
    public ResponseEntity<List<User>> findAllByEmailEndingWith(String value){
        return ResponseEntity.ok(userService.findAllByEmailEndingWith(value));
    }

    @GetMapping("/find-users-by-password-length-greater-than")
    public ResponseEntity<List<User>> findUsersByPasswordLengthGreaterThan(int minPasswordLength) {
        return ResponseEntity.ok(userService.findUsersByPasswordLengthGreaterThan(minPasswordLength));
    }






}
