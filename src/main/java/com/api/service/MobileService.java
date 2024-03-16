package com.api.service;

import java.util.List;

import com.api.entity.Mobiles;

public interface MobileService {

	public String addMobile(Mobiles mobiles);
	
	public Mobiles getMobileById(Integer mobileId);
	
	public List<Mobiles> getAllMobiles();
	
	public Mobiles updateMobile(Mobiles Mobiles, Integer mobileId);
	
	public boolean deleteMobile(Integer mobileId) ;

	 List<Mobiles> getMobileOfEmployee(Integer empId);
	
}
