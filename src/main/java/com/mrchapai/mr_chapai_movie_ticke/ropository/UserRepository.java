package com.mrchapai.mr_chapai_movie_ticke.ropository;


import com.mrchapai.mr_chapai_movie_ticke.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
