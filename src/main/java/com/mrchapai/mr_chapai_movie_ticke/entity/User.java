package com.mrchapai.mr_chapai_movie_ticke.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "user_table")
public class User {

    @Id
    int id;
    String name;
    String userName;
    String password;

}
