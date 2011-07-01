package com.awscrud.service;

import java.util.List;

import com.awscrud.dao.SnowboardDAO;
import com.awscrud.dao.SnowboardDAOImpl;
import com.awscrud.domain.Snowboard;

public class SnowboardServiceImpl implements SnowboardService {

	SnowboardDAO snowboardDAO = new SnowboardDAOImpl();

	public boolean createSnowboard(Snowboard snowboard) throws Exception {
		return snowboardDAO.createSnowboard(snowboard);
	}
	
	public List<Snowboard> getAllSnowboards() throws Exception {
		return snowboardDAO.getAllSnowboards();
	}
	
	public void deleteSnowboardById(long snowboardId) throws Exception {
		snowboardDAO.deleteSnowboardById(snowboardId);
	}
	
	public boolean updateSnowboard(Long snowboardId, String fieldModified,
			String newValue) throws Exception {
		snowboardDAO.updateSnowboard(snowboardId, fieldModified,
				newValue);
		return false;
	}
	
/*
	public void updateSnowboard(Snowboard snowboard) throws Exception {
		snowboardDAO.updateSnowboard(snowboard);
	}

	public Snowboard getSnowboardById(int snowboardId) throws Exception {
		return snowboardDAO.getSnowboardById(snowboardId);
	}

	public void deleteSnowboard(Snowboard snowboard) throws Exception {
		snowboardDAO.deleteSnowboard(snowboard);
	}

	public int getTotalCountOfSnowboards() throws Exception {
		return snowboardDAO.getTotalCountOfSnowboards();
	}
*/
}