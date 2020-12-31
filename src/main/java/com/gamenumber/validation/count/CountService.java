package com.gamenumber.validation.count;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CountService {
	

	@Autowired
	private CountRepository countRepo;
	
	
	public List<Count> getAllCount() {
		
		List<Count> totalCount = new ArrayList<>();
//		return topics;
		countRepo.findAll().forEach(totalCount::add);
		 return totalCount;
	
}
	
	public void deleteAllCount() {
		
		countRepo.deleteAll();
		
	}
	
	public void addCount() {
		long currentOne = 0;
		LocalDateTime myDateObj = LocalDateTime.now();
		List<Count> totalCount = new ArrayList<>();
		countRepo.findAll().forEach(totalCount::add);
		try {
			 currentOne = totalCount.get(0).getCount();
			
		} catch (Exception e) {
			 currentOne = 0;
		}
		Count count = new Count();
		count.setCount(currentOne+1);
		count.setTime(myDateObj.toString());
		countRepo.deleteAll();
		countRepo.save(count);
		
	}
	
	
}