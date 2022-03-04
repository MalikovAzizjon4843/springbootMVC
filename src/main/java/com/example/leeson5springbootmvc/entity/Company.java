package com.example.leeson5springbootmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;


//bu ikkalasi table boliwi kerakligini bildiradi

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {
    // pk boliwi kk
    @Id
    // auto increment va sequence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    // ustun unga bolgan xamma xususiyatlar
    @Column(nullable = false, unique = true)
    private String name;


    // bitta ortiqca malumot saqlash un  table yaratadi
//    @OneToMany
//    private List<Department> departmentList;

}
