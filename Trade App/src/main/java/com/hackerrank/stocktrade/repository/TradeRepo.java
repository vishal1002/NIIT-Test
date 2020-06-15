package com.hackerrank.stocktrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackerrank.stocktrade.model.Trade;

public interface TradeRepo extends JpaRepository<Trade, Long>{

}
