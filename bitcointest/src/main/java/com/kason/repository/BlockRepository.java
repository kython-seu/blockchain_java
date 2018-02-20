package com.kason.repository;


import com.kason.entity.BlockEntity;
import org.springframework.data.repository.CrudRepository;

public interface BlockRepository extends CrudRepository<BlockEntity, String> {

	/**
	 * Find last block.
	 * 
	 * @return Last block.
	 */
	BlockEntity findFirstByOrderByHeightDesc();

	/**
	 * Find block by height.
	 * 
	 * @param height
	 *            Block height.
	 * @return The block.
	 */
	BlockEntity findOneByHeight(long height);

}
