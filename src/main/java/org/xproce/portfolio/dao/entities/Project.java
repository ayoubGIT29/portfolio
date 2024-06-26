package org.xproce.portfolio.dao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "project")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Project{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(max = 100)
    private String title;
    @NotEmpty
    @Pattern(regexp = "[A-Za-z0-9 ]*")
    private String designation;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private Date modifiedAt;

}
