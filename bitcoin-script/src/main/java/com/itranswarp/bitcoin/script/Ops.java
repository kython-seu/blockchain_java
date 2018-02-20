package com.itranswarp.bitcoin.script;

import java.util.HashMap;
import java.util.Map;

import com.itranswarp.bitcoin.script.op.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.itranswarp.bitcoin.BitcoinException;
import com.itranswarp.bitcoin.util.ClasspathUtils;

/**
 * Script ops: https://en.bitcoin.it/wiki/Script
 * 
 * @author liaoxuefeng
 */
public class Ops {

	final Log Log = LogFactory.getLog(getClass());

	public static Op getOp(Integer code) {
		return OPS.get(code);
	}

	// holds all ops:
	static final Map<Integer, Op> OPS = scanOps();

	static Map<Integer, Op> scanOps() {
		Map<Integer, Op> map = new HashMap<>();
		try {
			/*for (Class<?> clazz : ClasspathUtils.getClasses(Ops.class.getPackage().getName() + ".op")) {
				System.out.println("-------------" + clazz);
				//Op op = (Op) clazz.newInstance();
				com.itranswarp.bitcoin.script.op.Op2Drop op2Drop = new Op2Drop();
				//com.itranswarp.bitcoin.script.op.Op2Drop op2Drop = (com.itranswarp.bitcoin.script.op.Op2Drop)clazz.newInstance();
				map.put(op2Drop.code, op2Drop);
				//map.put(op.code, op);
			}*/
			Op2Drop op2Drop = new Op2Drop();
			map.put(op2Drop.code, op2Drop);

			Op2Dup op2Dup = new Op2Dup();
			map.put(op2Dup.code, op2Dup);

			Op3Dup op3Dup = new Op3Dup();
			map.put(op3Dup.code, op3Dup);

			OpCheckSig opCheckSig = new OpCheckSig();
			map.put(opCheckSig.code, opCheckSig);

			OpCheckSigVerify opCheckSigVerify = new OpCheckSigVerify();
			map.put(opCheckSigVerify.code, opCheckSigVerify);

			OpDrop opDrop = new OpDrop();
			map.put(opDrop.code, opDrop);

			OpDup opDup = new OpDup();
			map.put(opDup.code, opDup);

			OpEqual opEqual = new OpEqual();
			map.put(opEqual.code, opEqual);

			OpEqualVerify opEqualVerify = new OpEqualVerify();
			map.put(opEqualVerify.code, opEqualVerify);

			OpFromAltStack opFromAltStack = new OpFromAltStack();
			map.put(opFromAltStack.code, opFromAltStack);

			OpHash160 opHash160 = new OpHash160();
			map.put(opHash160.code, opHash160);

			OpHash256 opHash256 = new OpHash256();
			map.put(opHash256.code, opHash256);

			OpNip opNip = new OpNip();
			map.put(opNip.code, opNip);

			OpNop opNop = new OpNop();
			map.put(opNop.code, opNop);

			OpOver opOver = new OpOver();
			map.put(opOver.code, opOver);

			OpReturn opReturn = new OpReturn();
			map.put(opReturn.code, opReturn);

			OpSwap opSwap = new OpSwap();
			map.put(opSwap.code, opSwap);

			OpToAltStack opToAltStack = new OpToAltStack();
			map.put(opToAltStack.code, opToAltStack);

			OpVerify opVerify = new OpVerify();
			map.put(opVerify.code, opVerify);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new BitcoinException(e);
		}
		return map;
	}

}
