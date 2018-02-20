package com.kason.repository;


import com.kason.entity.TxEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TxRepository extends CrudRepository<TxEntity, String> {

	/**
	 * Find tx by block hash and order by tx index.
	 */
	List<TxEntity> findByBlockHashOrderByTxIndex(String blockHash);
}
