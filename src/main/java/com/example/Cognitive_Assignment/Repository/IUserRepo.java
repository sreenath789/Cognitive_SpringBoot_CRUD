package com.example.Cognitive_Assignment.Repository;

import com.example.Cognitive_Assignment.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<UserDetails,Integer> {
}
