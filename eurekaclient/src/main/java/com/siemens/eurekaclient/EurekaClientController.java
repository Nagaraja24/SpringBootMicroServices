package com.siemens.eurekaclient;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siemens.eurekaclient.model.ClientInformation;
import com.siemens.eurekaclient.repository.EurekaClientRepository;

@RestController
@PropertySource("classpath:microservice.properties")
public class EurekaClientController {

	private static final Logger LOG = LoggerFactory.getLogger(EurekaClientController.class);

	@Autowired
	private EurekaClientRepository eurekaClientRepo;
	
	@Value("${test.value}")
	private String configValue;

	@PostMapping("/saveClient")
	public ClientInformation saveClient(@RequestBody ClientInformation client, @RequestParam("sample") String queryParam) {
		LOG.info("Inside saveClient");
		LOG.info("Config value is : {}", configValue);
		LOG.info("Query Param is : {}", queryParam);
		ClientInformation response = eurekaClientRepo.save(client);
		LOG.info("Saved client is : {}", response);
		LOG.info("Exit from saveClient");
		return response;

	}

	@GetMapping("/getClients")
	public List<ClientInformation> getClients() {
		
		LOG.info("Inside getClients");
		List<ClientInformation> result = (List<ClientInformation>) eurekaClientRepo.findAll();
		LOG.info("Exit from getClients");
		
		return result;
	}

}
