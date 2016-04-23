package com.horaire.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.horaire.model.User;
import com.horaire.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);

}
