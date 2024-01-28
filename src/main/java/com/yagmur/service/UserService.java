package com.yagmur.service;

import com.yagmur.dto.request.LoginRequestDto;
import com.yagmur.dto.request.RegisterRequestDto;
import com.yagmur.dto.response.LoginResponseDto;
import com.yagmur.dto.response.RegisterResponseDto;
import com.yagmur.entity.User;
import com.yagmur.mapper.UserMapper;
import com.yagmur.repository.UserRepository;
import com.yagmur.utility.EStatus;
import com.yagmur.utility.EUserType;
import com.yagmur.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements ICrudService<User,Long> {

    private final UserRepository userRepository;


    @Override

    public User save(User user) {
        User registeredUser = User.builder()
                        .name(user.getName())
                        .surname(user.getSurname())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .repassword(user.getRepassword())
                        .phone(user.getPhone())
                .build();
        if (user.getPassword().equals(user.getRepassword())) {
            return userRepository.save(registeredUser);
        }else {
        throw new IllegalArgumentException("Password does not match!");
        }

        //isBlank -> true is empty false, boşlul da bir karaktker.
        //isBlank ile de kontrol etmen gerekir.
    }

    /**
     * #veri tabanında bu kullanıcı var ise sisteme giriş yapabiliyor olmalıyım.
     * #password eşleşiyor mu diye de kontrol edilmesi gerekiyor.
     */

    public Optional<User> login(String email, String password) {
        Optional<User> loggedInUser = userRepository.findByEmailAndPassword(email, password);
        if (loggedInUser.isEmpty()){
            throw new NullPointerException("User not found! Password or email does not match!");
        }
        return loggedInUser;
    }


    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> entities) {
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            throw new NullPointerException("User list is empty!");
        }
        return userList;
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return user;
        }else {
            throw new NullPointerException("User not found!");
        }
    }

    @Override
    public User deleteById(Long id) {
        //soft-delete // inaktif duruma getir.
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get(); // get -> Optional<User> converts to User
            user.setStatus(EStatus.INACTIVE); // Set the user to inactive
            userRepository.save(user);
            return user;
        } else {
            throw new NullPointerException("User not found!");
        }
    }

    public RegisterResponseDto registerDto(RegisterRequestDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .repassword(dto.getRepassword())
        .build();

        if (!user.getPassword().equalsIgnoreCase(user.getRepassword()) || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password does not match!");
        }
        userRepository.save(user);
        return RegisterResponseDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();
    }

    public LoginResponseDto loginDto(LoginRequestDto dto){
        Optional<User> optionalUser = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (optionalUser.isEmpty()){
            throw new NullPointerException("User not found! Password or email does not match!");
        }
        return LoginResponseDto.builder()
                .email(optionalUser.get().getEmail())
                .build();

    }

    public LoginResponseDto loginMapper(LoginRequestDto dto) {
        Optional<User> optionalUser = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (optionalUser.isEmpty()){
            throw new NullPointerException("User not found! Password or email does not match!");
        }
        return UserMapper.INSTANCE.fromUserToLoginResponseDto(optionalUser.get());
    }

//Commit 2-{
//registerMapper() metodu için;
//Aynı email ile ikinci kez kayıt işlemi yapılmamalıdır. Bu durumu service katmanında yönetiniz.
//ba.admin@email.com şeklinde kayıt işlemi gerçekleştiren kullanıcının status'u Active, type'ı ise Admin olmalıdır. Bu işlevselliği kazandırınız.
//}

    //commit-2
    public RegisterResponseDto registerMapper(RegisterRequestDto dto) {
        User isExistUser = (User) userRepository.findByEmailIgnoreCase(dto.getEmail());
        if (isExistUser != null) {
            throw new IllegalArgumentException("Email is already registered!");
        }
        User user=UserMapper.INSTANCE.fromRegisterRequestDtoToUser(dto);

        if (!user.getPassword().equalsIgnoreCase(user.getRepassword()) || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password does not match!");
        }else if ("ba.admin@email.com".equals(dto.getEmail())) {
            user.setStatus(EStatus.ACTIVE);
            user.setUserType(EUserType.ADMIN);
        }
        userRepository.save(user);
        return UserMapper.INSTANCE.fromUserToRegisterResponseDto(user);
    }

    public List<User> findAllByOrderByNameAsc() {
        return userRepository.findAllByOrderByNameAsc();
    }

    public Boolean existsByName(String name) {
        return userRepository.existsByName(name);
    }

    public List<User> findAllByNameContainingIgnoreCase(String value) {
        return userRepository.findAllByNameContainingIgnoreCase(value);
    }

    public List<User> findByEmailIgnoreCase(String email) {
        return userRepository.findByEmailIgnoreCase(email);
    }





}
