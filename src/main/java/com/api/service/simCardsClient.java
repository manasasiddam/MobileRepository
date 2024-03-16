package com.api.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.entity.simCards;


@FeignClient(url = "http://localhost:9003" ,value="simCards-Client")
public interface simCardsClient {
	@GetMapping("/sim/mobile/{mobileId}")
	List<simCards> getSimCardsOfEmployee(@PathVariable Integer mobileId);

}