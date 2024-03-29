package com.example.Deals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Deals.model.Deals;
import com.example.Deals.model.repository.DealsRepository;
import com.example.Deals.service.DealsService;

@SpringBootTest
@RunWith(SpringRunner.class)
class DealsApplicationTests 
{
	@Autowired
	private DealsService service;
	
	@MockBean
	private DealsRepository repo;
	
	@Test
	public void findAllDealsTest()
	{
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new Deals("","","","","","","","","","","")).collect(Collectors.toList()));
		assertEquals(1,service.findAllDeals().size());
	}
	
	@Test
	public void findDealsByStoreTest()
	{
		String storeName="";
		Mockito.when(repo.findByStoreName(storeName)).thenReturn(Stream.of(new Deals("","","","","","","","","","","")).collect(Collectors.toList()));
		assertEquals(1,service.findDealsByStore(storeName).size());
	}
	
	@Test
	public void saveDeal()
	{
		Deals deals=new Deals("","","","","","","","","","","");
		Mockito.when(repo.save(deals)).thenReturn(deals);
		assertEquals(deals,service.saveDeal(deals));
	}
}
