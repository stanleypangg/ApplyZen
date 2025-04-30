package com.applyzen.applyzen.status;

import com.applyzen.applyzen.jobapplication.JobApplication;
import com.applyzen.applyzen.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Status {
    @Id
    @SequenceGenerator(
            name = "status_id_generator",
            sequenceName = "status_id_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "status_id_generator"
    )
    private Long id;
    private String name;
    @FutureOrPresent(message = "Must be a future or present date and time")
    private LocalDateTime createdAt;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;
    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private List<JobApplication> jobApplications;
}
