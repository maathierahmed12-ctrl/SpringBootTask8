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
@Table(name = "campaigns")
public class Campaign {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank(message = "Campaign title is required")
        @Column(name = "title", nullable = false)
        private String title;
        @Column(name = "platform")
        private String platform;
        @Column(name = "budget")
        private Double budget;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "employee_id", nullable = false)
        private Employee employee;

        public Campaign(String title, String platform, Double budget) {
            this.title = title;
            this.platform = platform;
            this.budget = budget;
        }

    }

