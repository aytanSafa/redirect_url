package com.demo.redirect_url.repository;

import com.demo.redirect_url.entity.RedirectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RedirectRepository extends JpaRepository<RedirectEntity,Long> {
    Optional<RedirectEntity> findByShortCode(String shortCode);

}
