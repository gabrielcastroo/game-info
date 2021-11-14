package com.trabalhopoo.gameinfo.repository;

import com.trabalhopoo.gameinfo.entity.GameInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameInfoRepository extends JpaRepository<GameInfo, Long> {

    Optional<GameInfo> findByName(String name);
}
