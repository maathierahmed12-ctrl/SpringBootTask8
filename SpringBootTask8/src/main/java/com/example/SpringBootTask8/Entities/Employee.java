package com.example.SpringBootTask8.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Employee name is required")
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "role")
    private String role;



    public Employee(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;

    }
        @OneToMany(mappedBy = "employee", cascade= CascadeType.ALL, orphanRemoval = true)

        private List<Campaign> campaigns;
    }
