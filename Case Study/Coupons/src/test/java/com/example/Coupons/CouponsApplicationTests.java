package com.example.Coupons;

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

import com.example.Coupons.model.Coupons;
import com.example.Coupons.repository.CouponsRepository;
import com.example.Coupons.service.CouponsService;


//Test Cases
@SpringBootTest
@RunWith(SpringRunner.class)
class CouponsApplicationTests 
{
	@Autowired
	private CouponsService service;
	
	@MockBean
	private CouponsRepository repo;

	@Test
	public void findAllCouponsTest()
	{
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new Coupons("","","","","","","","","","","")).collect(Collectors.toList()));
		assertEquals(1,service.findAllCoupons().size());
	}
	
	@Test
	public void findCouponBySubcategoryTest()
	{
		String subcategory="clothing";
		Mockito.when(repo.findBySubcategory(subcategory)).thenReturn(Stream.of(new Coupons("","","","","","","","","","","")).collect(Collectors.toList()));
		assertEquals(1,service.findCouponBySubcategory(subcategory).size());
	}
	
	@Test
	public void saveCouponTest()
	{
		Coupons coupons=new Coupons("","","","","","","","","","","");
		Mockito.when(repo.save(coupons)).thenReturn(coupons);
		assertEquals(coupons,service.saveCoupon(coupons));
	}
}
