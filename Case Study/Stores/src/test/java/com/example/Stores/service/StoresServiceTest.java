package com.example.Stores.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Stores.model.Stores;
import com.example.Stores.repository.StoersRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class StoresServiceTest 
{
	@Mock
	private StoersRepository repoTest;
	
	@InjectMocks
	private StoresService serviceTest;

	@Test
	void testSaveStore() 
	{
		Stores stores=new Stores("1","Myntra","10","url");
		
		Mockito.when(repoTest.save(stores)).thenReturn(stores);
		assertThat(serviceTest.saveStore(stores)).isEqualTo(stores);
		System.out.println(stores.toString());
	}

	@Test
	void testGetAllStores() 
	{
		Stores store1=new Stores("6","Myntra","10","url");
		Stores store2=new Stores("7","FlipKart","10","url");
		
		List<Stores> stores=new ArrayList<>();
		stores.add(store1);
		stores.add(store2);
		
		Mockito.when(repoTest.findAll()).thenReturn(stores);
		assertThat(serviceTest.getAllStores()).isEqualTo(stores);		
	}

	@Test
	void testDeleteStore() 
	{
		Stores stores=new Stores("6","Myntra","10","url");
		Mockito.when(repoTest.findById("6")).thenReturn(Optional.of(stores));
		Mockito.when(repoTest.existsById(stores.getId())).thenReturn(false);
		assertFalse(repoTest.existsById(stores.getId()));
	}

}