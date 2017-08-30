package com.goldentwo.model;

import com.goldentwo.dto.PlayerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nickname;
    private String name;
    private String surname;

    @Column(unique = true)
    @ColumnDefault(value = "0")
    private int rank;

    public Player(PlayerDto playerDto) {
        this.nickname = playerDto.getNickname();
        this.name = playerDto.getName();
        this.surname = playerDto.getSurname();
    }

    public PlayerDto asDto() {
        return PlayerDto.builder()
                .id(id)
                .nickname(nickname)
                .name(name)
                .surname(surname)
                .rank(rank)
                .build();
    }

}
