package com.goldentwo.model;

import com.goldentwo.dto.MemberDto;
import com.goldentwo.dto.TournamentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @NotEmpty
    @OneToMany
    private Set<Team> teams;

    public TournamentDto asDto() {
        Set<MemberDto> teamDtos = teams.stream()
                .map(Team::asDto)
                .collect(Collectors.toSet());

        return TournamentDto.builder()
                .id(id).name(name).members(teamDtos).build();
    }

}