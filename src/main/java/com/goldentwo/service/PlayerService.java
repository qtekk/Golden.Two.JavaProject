package com.goldentwo.service;

import com.goldentwo.dto.PlayerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlayerService {
    PlayerDto findPlayerById(Long id);

    PlayerDto findPlayerByNickname(String nickname);

    List<PlayerDto> findAllPlayers();

    PlayerDto savePlayer(PlayerDto match);

    ResponseEntity deletePlayer(Long id);
}
