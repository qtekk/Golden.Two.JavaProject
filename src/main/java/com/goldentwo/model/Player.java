package com.goldentwo.model;

import com.goldentwo.dto.PlayerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player extends Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nickname;
    private String name;
    private String surname;

    public Player(PlayerDto playerDto) {
        this.nickname = playerDto.getNickname();
        this.name = playerDto.getName();
        this.surname = playerDto.getSurname();
    }

    public PlayerDto asDto() {
        return PlayerDto.builder()
                .nickname(nickname)
                .name(name)
                .surname(surname)
                .build();
    }

}
