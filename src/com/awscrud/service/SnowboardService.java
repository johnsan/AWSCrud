package com.awscrud.service;

import java.util.List;

import com.awscrud.domain.Snowboard;

public interface SnowboardService
{
	public boolean createSnowboard(Snowboard snowboard)throws Exception;

	public List<Snowboard> getAllSnowboards()throws Exception;
	
	public void deleteSnowboardById(long snowboardId)throws Exception;
/*
	public Snowboard getSnowboardById(int snowboardId)throws Exception;	
	
	public void updateSnowboard(Snowboard snowboard)throws Exception;

	public void deleteSnowboard(Snowboard snowboard)throws Exception;

	public int getTotalCountOfSnowboards()throws Exception;	
*/	
}