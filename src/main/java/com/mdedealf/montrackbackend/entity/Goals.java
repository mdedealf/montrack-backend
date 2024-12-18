package com.mdedealf.montrackbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "goals", schema = "montrack")
public class Goals {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goal_id_gen")
    @SequenceGenerator(name = "goal_id_gen", sequenceName = "goals_goal_id_seq", allocationSize = 1)
    @Column(name = "goal_id", nullable = false)
    private Long goalId;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallets wallet;

    @NotNull
    @Size(max = 100)
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotNull
    @Column(name = "target_amount", nullable = false)
    private BigDecimal targetAmount;

    @NotNull
    @Column(name = "current_amount", nullable = false)
    private BigDecimal currentAmount;

    @Size(max = 150)
    @Column(name = "description", length = 150)
    private String description;

    @Size(max = 255)
    @Column(name = "file_attachment", length = 255)
    private String fileAttachment;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", nullable = false)
    private ZonedDateTime updatedAt;

    @Column(name = "deleted_at")
    private ZonedDateTime deletedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = ZonedDateTime.now();
        this.updatedAt = ZonedDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = ZonedDateTime.now();
    }

}
