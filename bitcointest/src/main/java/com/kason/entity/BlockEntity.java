package com.kason.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "block", uniqueConstraints = { @UniqueConstraint(name = "uni_prev_hash", columnNames = "prevHash"),
		@UniqueConstraint(name = "uni_height", columnNames = "height") })
public class BlockEntity {

	@JsonProperty("hash")
	@Id
	@Column(nullable = false, updatable = false, length = EntityConstants.HASH_LENGTH)
	public String blockHash;

	@Column(nullable = false, updatable = false, length = EntityConstants.HASH_LENGTH)
	public String prevHash;

	@Column(nullable = false, updatable = false, length = EntityConstants.HASH_LENGTH)
	public String merkleHash;

	/**
	 * Epoch time in seconds.
	 */
	@Column(nullable = false, updatable = false)
	public long timestamp;

	@JsonProperty("n_tx")
	@Column(nullable = false, updatable = false)
	public long txCount;

	@Column(nullable = false, updatable = false)
	public long bits;

	@Column(nullable = false, updatable = false)
	public long nonce;

	@JsonProperty("ver")
	@Column(nullable = false, updatable = false)
	public long version;

	@Column(nullable = false, updatable = false)
	public long height;

	@Column(nullable = false, updatable = false)
	public long size;

	@Transient
	public List<TxEntity> txs;
}
