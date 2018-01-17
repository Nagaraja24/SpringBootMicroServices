package com.siemens.eurekaclient.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.siemens.eurekaclient.model.ClientInformation;

@Repository
public interface EurekaClientRepository extends CrudRepository<ClientInformation, Long> {

}
