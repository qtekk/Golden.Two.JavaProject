package com.goldentwo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatisticsDto {

    private Long playerId;
    private Long kills;
    private Long deaths;
    private Long kd;

}
