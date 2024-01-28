package com.yagmur.repository;

import com.yagmur.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Repository'de email ve şifreye göre kullanıcı dönen bir metot yazılması gerekemektedir.

    Optional<User> findByEmailAndPassword(String email, String password);


    //Kullanıcıları ismine göre sıralayan bir metot yazınız.
    List<User> findAllByOrderByNameAsc();

    //Kullanıcının girdiği bir isimle veritabanındaki bir ismin var olup olmadığını karşılaştırınız.
    Boolean existsByName(String name);
    //Kullanıcının isim sorgulaması için girdiği harf veya kelimeye göre veritabanında sorgu yapan bir metot yazınız.
    List<User> findAllByNameContainingIgnoreCase(String value);

    //Kullanıcının girdiği email'e göre veritabanında sorgu yapan bir metot yazınız.
    List<User> findByEmailIgnoreCase(String email);

}
