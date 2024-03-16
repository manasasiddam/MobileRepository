package com.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.Mobiles;
import com.api.repository.MobileRepository;

@Service
public class MobileServiceImpl implements MobileService {

    private MobileRepository mobileRepository;
    private simCardsClient simClient;

   
  
    public MobileServiceImpl(MobileRepository mobileRepository, simCardsClient simClient) {
		super();
		this.mobileRepository = mobileRepository;
		this.simClient = simClient;
	}

	@Override
    public String addMobile(Mobiles mobiles) {
        String msg = "";
        Mobiles saveMobile = mobileRepository.save(mobiles);
        if (saveMobile != null) {
            msg = "Mobile saved successfully";
        } else {
            msg = "Mobile not saved";
        }
        return msg;
    }

    @Override
    public Mobiles getMobileById(Integer mobileId) {
        Optional<Mobiles> findById = mobileRepository.findById(mobileId);
        return findById.orElse(null);
    }

    @Override
    public List<Mobiles> getAllMobiles() {
    	List<Mobiles> listMobiles = mobileRepository.findAll();
    	List<Mobiles> collect = listMobiles.stream().map(sim->{sim.setSims(simClient.getSimCardsOfEmployee(sim.getMobileId()));
    		return sim;
    		
    	}).collect(Collectors.toList());
    	
    	return collect;
    }

    @Override
    public Mobiles updateMobile(Mobiles mobiles, Integer mobileId) {
        Optional<Mobiles> updateById = mobileRepository.findById(mobileId);
        if (updateById.isPresent()) {
            Mobiles updateMobile = updateById.get();
            updateMobile.setMobileName(mobiles.getMobileName());
            updateMobile.setMobilePrice(mobiles.getMobilePrice());
            return mobileRepository.save(updateMobile);
        }
        return null;
    }

    @Override
    public boolean deleteMobile(Integer mobileId) {
        if (mobileRepository.existsById(mobileId)) {
            mobileRepository.deleteById(mobileId);
            return true;
        }
        return false;
    }

	@Override
	public List<Mobiles> getMobileOfEmployee(Integer employeeId) {
		
		List<Mobiles> MobileOfEmployee = mobileRepository.findByEmployeeId(employeeId);
		List<Mobiles> mobileList = MobileOfEmployee.stream().map(sim->{sim.setSims(simClient.getSimCardsOfEmployee(sim.getMobileId()));
		return sim;}).collect(Collectors.toList());
		
		return mobileList;
	}


	
	
	
}