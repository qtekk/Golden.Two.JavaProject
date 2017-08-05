package com.goldentwo.service.impl;

import com.goldentwo.dto.PlayerDto;
import com.goldentwo.exception.PlayerException;
import com.goldentwo.model.Player;
import com.goldentwo.repository.PlayerRepository;
import com.goldentwo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerDto findPlayerById(Long id) {
        return Optional.ofNullable(playerRepository.findOne(id))
                .orElseThrow(
                        () -> new PlayerException("Player doesn't exists!"))
                .asDto();
    }

    @Override
    public PlayerDto findPlayerByNickname(String nickname) {
        return playerRepository
                .findByNickname(nickname)
                .orElseThrow(
                        () -> new PlayerException("There is no player with given nickname")
                ).asDto();
    }

//    TODO: find usage for cacheable
//    @Cacheable(CacheConstants.PLAYERS_CACHE)
    @Override
    public List<PlayerDto> findAllPlayers() {
        return playerRepository.findAll().stream()
                .map(Player::asDto)
                .collect(Collectors.toList());
    }

    @Override
    public PlayerDto savePlayer(PlayerDto playerDto) {
        Player player = new Player(playerDto);

        return playerRepository.saveAndFlush(player).asDto();
    }

    @Override
    public ResponseEntity deletePlayer(Long id) {
        playerRepository.delete(id);

        return ResponseEntity.ok().build();
    }
}
