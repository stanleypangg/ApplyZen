package com.applyzen.applyzen.user;

import com.applyzen.applyzen.jobapplication.JobApplication;
import com.applyzen.applyzen.status.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_id_generator",
            sequenceName = "user_id_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_generator"
    )
    private Long id;
    // @Unique
    @NotBlank(message = "Cannot be blank")
    @Email(message = "Must be a valid email format")
    private String email;
    @NotBlank(message = "Cannot be blank")
    private String passwordHash;
    @FutureOrPresent(message = "Must be a future or present date and time")
    @NotNull(message = "Cannot be null")
    private LocalDateTime createdAt;
    @FutureOrPresent(message = "Must be a future or present date and time")
    @NotNull(message = "Cannot be null")
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobApplication> applications;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Status> statuses;
}
