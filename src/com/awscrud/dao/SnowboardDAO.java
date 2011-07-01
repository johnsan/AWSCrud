package com.awscrud.dao;

import java.util.List;

import com.awscrud.domain.Snowboard;

public interface SnowboardDAO {
	
	public boolean createSnowboard(Snowboard snowboard) throws Exception;

	public List<Snowboard> getAllSnowboards() throws Exception;	
	
	public void deleteSnowboardById(long snowboardId) throws Exception;
	
	public boolean updateSnowboard(Long snowboardId, String fieldModified,
			String newValue) throws Exception;
/*
	public void updateSnowboard(Snowboard snowboard)throws Exception;

	public Snowboard getSnowboardById(int snowboardId)throws Exception;

	public void deleteSnowboard(Snowboard snowboard)throws Exception;

	public int getTotalCountOfSnowboards()throws Exception;
*/
}