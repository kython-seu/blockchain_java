package com.kason.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tx", indexes = @Index(name = "idx_block_hash", columnList = "blockHash"))
public class TxEntity {

	@JsonProperty("hash")
	@Id
	@Column(nullable = false, updatable = false, length = EntityConstants.HASH_LENGTH)
	public String txHash;

	@Column(nullable = false, updatable = false, length = EntityConstants.HASH_LENGTH)
	public String blockHash;

	@JsonProperty("index")
	@Column(nullable = false, updatable = false)
	public long txIndex;

	@Column(nullable = false, updatable = false)
	public long inputCount;

	@Column(nullable = false, updatable = false)
	public long outputCount;

	@Column(nullable = false, updatable = false)
	public long totalInput;

	@Column(nullable = false, updatable = false)
	public long totalOutput;

	@Column(nullable = false, updatable = false)
	public long lockTime;

	@JsonProperty("ver")
	@Column(nullable = false, updatable = false)
	public long version;

	@JsonIgnore
	@Transient
	public boolean isCoinbase() {
		return this.inputCount == 0;
	}

	@Transient
	public long fees() {
		if (isCoinbase()) {
			return 0;
		}
		return totalOutput - totalInput;
	}

	@Transient
	public List<InputBean> inputs;

	@Transient
	public List<OutputBean> outputs;

}
