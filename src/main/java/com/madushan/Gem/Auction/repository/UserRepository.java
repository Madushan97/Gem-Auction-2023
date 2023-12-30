package com.madushan.Gem.Auction.repository;

import com.madushan.Gem.Auction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
