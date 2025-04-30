package com.applyzen.applyzen.jobapplication;

import com.applyzen.applyzen.status.Status;
import com.applyzen.applyzen.user.User;
import jakarta.persistence.*;

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
    private String companyName;
    private String jobTitle;
    private LocalDateTime dateApplied;
    private String postingURL;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status status;
}
