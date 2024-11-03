package com.mdedealf.montrackbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pocket {
    private Long pocketId;
    private Long walletId;
    private String name;
    private String description;
    private String emojiCode;
    private Double totalAmount;
    private Double currentAmount;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime deletedAt;
}
