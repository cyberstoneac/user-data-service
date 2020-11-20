package com.webservice.userdataservice.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.webservice.userdataservice.model.UserData;

@Component
@FeignClient(name="zuul-api-gateway")
@RibbonClient(name="database-service")
public interface DatabaseServiceProxy {

	@PostMapping("/database-service/save")
	public UserData saveUserData(UserData userData);

	@GetMapping("/database-service/get/{userId}")
	public UserData getUserData(int userId);

	@GetMapping("/database-service/getAll")
	public List<UserData> getAllUser();
	
}
