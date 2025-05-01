package com.applyzen.applyzen.jobapplication;

import com.applyzen.applyzen.status.Status;
import com.applyzen.applyzen.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
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
    @PastOrPresent(message = "Must be a past or present date and time")
    private LocalDate dateApplied;
    private String location;
    @URL(message = "Must be a valid URL")
    private String postingUrl;

    public JobApplication(String companyName, String jobTitle, LocalDate dateApplied, User owner) {
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.dateApplied = dateApplied;
        this.owner = owner;
    }

    @Length(min = 0, max = 255, message = "Must be between 0 and 255 characters long")
    private String notes;
    @NotNull(message = "Cannot be null")
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @NotNull(message = "Cannot be null")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status status;

    protected JobApplication() {
    }



    @Override
    public String toString() {
        return "JobApplication{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", dateApplied=" + dateApplied +
                ", location='" + location + '\'' +
                ", postingUrl='" + postingUrl + '\'' +
                ", notes='" + notes + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", owner=" + owner +
                ", status=" + status +
                '}';
    }
}
