package com.kason.controller;


import com.kason.entity.BlockEntity;
import com.kason.entity.TxEntity;
import com.kason.service.BitcoinService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	BitcoinService bitcoinService;

	@GetMapping("/api/block/{hash}")
	public BlockEntity getBlock(@PathVariable("hash") String input) {
		return bitcoinService.getBlock(input);
	}

	@GetMapping("/api/tx/{hash}")
	public TxEntity getTx(@PathVariable("hash") String input) {
		return bitcoinService.getTx(input);
	}

	/**
	 * API sample:
	 * 
	 * https://blockchain.info/address/1EzwoHtiXB4iFwedPr49iywjZn2nnekhoj?format=json
	 */
	@GetMapping("/api/address/{address}")
	public Object address(@PathVariable("address") String address) {
		return null;
	}
}
