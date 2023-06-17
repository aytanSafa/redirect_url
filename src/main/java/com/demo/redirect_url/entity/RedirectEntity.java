package com.demo.redirect_url.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "redirect")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RedirectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String shortCode;

    @Column
    private String redirectUrl;

}
