package com.practice.task_management_api_service.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min= 3, max= 100)
    private String title;
    @Size(max = 500)
    private String description;
    @NotNull
    @Pattern(regexp = "pending|in-progress|completed")
    private String status;
    @NotNull
    @Pattern(regexp = "low|high|medium")
    private String priority;
    @FutureOrPresent
    private LocalDate dueDate;
    private LocalDate createdAt;

    @PrePersist
    public void prePersist()
    {
        createdAt = LocalDate.now();
    }
}
