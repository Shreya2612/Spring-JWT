package com.example.springjwt.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Table(name="users")
public class Users implements Serializable { // why to implement Serializable?
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",insertable = false, nullable = false, unique = true)
    private Long id;

  //  @OneToOne(mappedBy = "users")
 //   private AuthUser authUser;

 //   @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
 //   private Set<Contact> contactTable;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact",nullable = false, unique = true)
    private Long contact;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "salt", nullable = false)
    private String salt;

    @Column(name = "hash", nullable = false)
    private String hash;


}
