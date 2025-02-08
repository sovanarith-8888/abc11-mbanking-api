package com.api.sbc11mbankingapi.feature.card;


import com.api.sbc11mbankingapi.domain.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardTypeRepository extends JpaRepository<CardType, Integer> {

}
