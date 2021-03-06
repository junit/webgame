package com.pwrd.war.gameserver.item.msg;

import com.pwrd.war.core.msg.MessageType;
import com.pwrd.war.gameserver.common.msg.CGMessage;
import com.pwrd.war.gameserver.item.handler.ItemHandlerFactory;

/**
 * 扩充背包需要多少元宝
 * 
 * @author CodeGenerator, don't modify this file please.
 */
public class CGSpandBagGold extends CGMessage{
	
	/** 数量 */
	private int number;
	/** 背包1，仓库5 */
	private int bagType;
	
	public CGSpandBagGold (){
	}
	
	public CGSpandBagGold (
			int number,
			int bagType ){
			this.number = number;
			this.bagType = bagType;
	}
	
	@Override
	protected boolean readImpl() {
		number = readInteger();
		bagType = readInteger();
		return true;
	}
	
	@Override
	protected boolean writeImpl() {
		writeInteger(number);
		writeInteger(bagType);
		return true;
	}
	
	@Override
	public short getType() {
		return MessageType.CG_SPAND_BAG_GOLD;
	}
	
	@Override
	public String getTypeName() {
		return "CG_SPAND_BAG_GOLD";
	}

	public int getNumber(){
		return number;
	}
		
	public void setNumber(int number){
		this.number = number;
	}

	public int getBagType(){
		return bagType;
	}
		
	public void setBagType(int bagType){
		this.bagType = bagType;
	}

	@Override
	public void execute() {
		ItemHandlerFactory.getHandler().handleSpandBagGold(this.getSession().getPlayer(), this);
	}
}