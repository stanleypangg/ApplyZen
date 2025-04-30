package com.applyzen.applyzen.jobapplication;

import com.applyzen.applyzen.status.Status;
import com.applyzen.applyzen.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Entity
public class JobApplication {
    @Id
    @SequenceGenerator(
            name = "job_application_id_generator",
            sequenceName = "job_application_id_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "job_application_id_generator"
    )
    private Long id;
    @NotBlank(message = "Cannot be blank")
    private String companyName;
    @NotBlank(message = "Cannot be blank")
    private String jobTitle;
    @NotNull(message = "Cannot be null")
    @FutureOrPresent(message = "Must be a future or present date and time")
    private LocalDateTime dateApplied;
    @URL(message = "Must be a valid URL")
    private String postingURL;
    @Length(min = 0, max = 255, message = "Must be between 0 and 255 characters long")
    private String notes;
    @FutureOrPresent(message = "Must be a future or present date and time")
    private LocalDateTime createdAt;
    @FutureOrPresent(message = "Must be a future or present date and time")
    private LocalDateTime updatedAt;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status status;
}
