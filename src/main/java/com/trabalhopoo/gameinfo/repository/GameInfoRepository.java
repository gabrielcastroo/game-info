package com.trabalhopoo.gameinfo.repository;

import com.trabalhopoo.gameinfo.entity.GameInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameInfoRepository extends JpaRepository<GameInfo, Long> {

}
