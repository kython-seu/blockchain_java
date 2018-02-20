package com.kason.repository;


import com.kason.entity.OutputEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OutputRepository extends CrudRepository<OutputEntity, String> {

	/**
	 * Find by txout hash and order by txout index.
	 */
	List<OutputEntity> findByTxoutHashOrderByTxoutIndex(String txHash);

	/**
	 * Find by txin hash and order by txin index.
	 */
	List<OutputEntity> findByTxinHashOrderByTxinIndex(String txHash);
}
