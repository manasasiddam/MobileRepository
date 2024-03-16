package com.api.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.Mobiles;
import com.api.entity.simCards;
import com.api.service.MobileService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/mobile")
public class MobileController {

	//Logger logger = LoggerFactory.getLogger(MobileController.class);
@Autowired
	private MobileService mobileService;


	@PostMapping("/add")
	public ResponseEntity<String> savePlan(@RequestBody Mobiles mobiles) {
		String addMobile = mobileService.addMobile(mobiles);
		return new ResponseEntity<>(addMobile, HttpStatus.CREATED);

	}
//
//	public ResponseEntity<Mobiles> findMobileById(Integer mobileId, Exception ex) {
//		logger.info("Fallback method executing because service is down:" + ex.getMessage());
//
//		Mobiles mob1 = new Mobiles();
//		mob1.setMobileId(mobileId);
//		mob1.setMobileName("newVersion");
//		mob1.setMobilePrice(0.0);
//
//		simCards sim1 = new simCards();
//		sim1.setSimId(0);
//		sim1.setMobileId(mobileId);
//		sim1.setNetWorkName("5g");
//		sim1.setEmiNumber((0000000000000L);
//
//		simCards sim2 = new simCards();
//		sim2.setSimId(0);
//		sim2.setMobileId(mobileId);
//		sim2.setNetWorkName("5g");
//		sim2.setEmiNumber((0000000000000L);
//
//		mob1.setSims(Arrays.asList(sim1, sim2));
//
//		return new ResponseEntity<>(mob1, HttpStatus.OK);
//
//	}

	@GetMapping("/mobile/{mobileId}")
	//@CircuitBreaker(name = "simBraker", fallbackMethod = "findMobileById")
	public ResponseEntity<Mobiles> findMobileById(@PathVariable Integer mobileId) {
		Mobiles mobileById = mobileService.getMobileById(mobileId);

		
		return new ResponseEntity<>(mobileById, HttpStatus.OK);

	}

//get all mobiles of a specific empId
	@GetMapping("/Employee/{employeeId}")

	public ResponseEntity<List<Mobiles>> findMobileOfEmployee(@PathVariable Integer employeeId) {
		List<Mobiles> mobileById = mobileService.getMobileOfEmployee(employeeId);
		return new ResponseEntity<>(mobileById, HttpStatus.OK);

	}

	@PutMapping("/update/{mobileId}")
	public ResponseEntity<String> updateMobileById(@RequestBody Mobiles mobiles, @PathVariable Integer mobileId) {

		String msg = "";
		Mobiles updateMobile = mobileService.updateMobile(mobiles, mobileId);
		if (updateMobile != null) {
			msg = "mobile updated successfully";

		} else {
			msg = "mobile not updated";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

//	public ResponseEntity<List<Mobiles>> fallBackAllMobiles() {
//		Mobiles mob1 = new Mobiles();
//		mob1.setMobileId(0);
//		mob1.setMobileName("newVersion");
//		mob1.setMobilePrice(0.0);
//
//		simCards sim1 = new simCards();
//		sim1.setSimId(0);
//		sim1.setMobileId(0);
//		sim1.setNetWorkName("5g");
//		sim1.setEmiNumber((long) 00000000000000);
//
//		simCards sim2 = new simCards();
//		sim2.setSimId(0);
//		sim2.setMobileId(0);
//		sim2.setNetWorkName("5g");
//		sim2.setEmiNumber((long) 00000000000000);
//
//		mob1.setSims(Arrays.asList(sim1, sim2));
//
//		Mobiles mob2 = new Mobiles();
//		mob2.setMobileId(0);
//		mob2.setMobileName("newVersion");
//		mob2.setMobilePrice(0.0);
//
//		simCards sim3 = new simCards();
//		sim3.setSimId(0);
//		sim3.setMobileId(0);
//		sim3.setNetWorkName("5g");
//		sim3.setEmiNumber((long) 00000000000000);
//
//		mob2.setSims(Arrays.asList(sim3));
//		List<Mobiles> MobileList = Arrays.asList(mob1, mob2);
//
//		return new ResponseEntity<>(MobileList, HttpStatus.OK);
//	}

	@GetMapping("/all")
//	@CircuitBreaker(name = "simBraker", fallbackMethod = "fallBackAllMobiles")
	public ResponseEntity<List<Mobiles>> findAllMobiles() {

		List<Mobiles> allMobiles = mobileService.getAllMobiles();
		return new ResponseEntity<>(allMobiles, HttpStatus.OK);

	}

	@DeleteMapping("/mobile/{mobileId}")
	public ResponseEntity<String> deleteMobileById(@PathVariable Integer mobileId) {
		String msg = "";
		boolean deleteMobileId = mobileService.deleteMobile(mobileId);
		if (deleteMobileId) {
			msg = "mobile deleted successfully";

		} else {
			msg = "mobile not deleted";
		}

		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

}
