package com.kglory.tms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Controller;

import com.kglory.tms.bean.realtime.StockBean;

//@Controller
public class RealtimeController {

	private static final Logger logger = LoggerFactory.getLogger(RealtimeController.class);
	
	@Autowired private SimpMessagingTemplate template;  
	private TaskScheduler scheduler = new ConcurrentTaskScheduler();
	private List<StockBean> stockPrices = new ArrayList<StockBean>();
	private Random rand = new Random(System.currentTimeMillis());
  
	/**
	 * Iterates stock list, update the price by randomly choosing a positive
	 * or negative percentage, then broadcast it to all subscribing clients
	 */
	private void updatePriceAndBroadcast() {
		logger.debug("RealtimeController > updatePriceAndBroadcast");
		for(StockBean stock : stockPrices) {
			double chgPct = rand.nextDouble() * 5.0;
			if(rand.nextInt(2) == 1) chgPct = -chgPct;
			stock.setPrice(stock.getPrice() + (chgPct / 100.0 * stock.getPrice()));
			stock.setTime(new Date());
		}
		template.convertAndSend("/topic/price", stockPrices);
	}
  
	/**
	 * Invoked after bean creation is complete, this method will schedule 
	 * updatePriceAndBroacast every 1 second
	 */
	@PostConstruct
	private void broadcastTimePeriodically() {
		logger.debug("RealtimeController > broadcastTimePeriodically");
		scheduler.scheduleAtFixedRate(new Runnable() {
			@Override public void run() {
				updatePriceAndBroadcast();
			}
		}, 1000);
	}
  
	/**
	 * Handler to add one stock
	 */
	@MessageMapping("/addStock")
	public void addStock(StockBean stock) throws Exception {
		logger.debug("RealtimeController > addStock");
		stockPrices.add(stock);
		updatePriceAndBroadcast();
	}
  
	/**
	 * Handler to remove all stocks
	 */
	@MessageMapping("/removeAllStocks")
	public void removeAllStocks() {
		logger.debug("RealtimeController > removeAllStocks");
		stockPrices.clear();
		updatePriceAndBroadcast();
	}
  
	/**
	 * Serve the main page
	 */
	/*
  	@RequestMapping(value = "/", method = RequestMethod.GET)
  	public String home() {
	  	logger.debug("HomeController > home");
    	return "home";
  	}
	 */

}
