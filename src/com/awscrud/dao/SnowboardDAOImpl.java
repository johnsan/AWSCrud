package com.awscrud.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.awscrud.aws.S3StorageManager;
import com.awscrud.domain.Snowboard;
//import com.awscrud.utils.SimpleDBEntityManagerFactory;
import com.awscrud.utils.StageUtils;
import com.spaceprogram.simplejpa.EntityManagerFactoryImpl;

public class SnowboardDAOImpl implements SnowboardDAO {

	public static final String domain = "snowboard";
	
	private static Map<String, String> properties = new HashMap<String, String>();
    static {
        properties.put("lobBucketName", S3StorageManager.getKey().toLowerCase() + "-travellog-lob" + StageUtils.getResourceSuffixForCurrentStage());
    }
    
    private static EntityManagerFactoryImpl factory = new EntityManagerFactoryImpl("TravelLog" + StageUtils.getResourceSuffixForCurrentStage(), properties);

    private static final Logger log = Logger.getLogger(SnowboardDAOImpl.class.getName());

	public boolean createSnowboard(Snowboard snowboard) throws Exception {

		log.info("Creating snowboard... " +
				"Brand: " + snowboard.getBrand() + " " +
				"Model: " + snowboard.getModel() + " " +
				"Length: " + snowboard.getLength() + " " +
				"Genre: " + snowboard.getGenre());
		
		boolean sucess = true;
		
		EntityManager em = null;
        //Storage fails if id is an empty string, so nullify it
        if (snowboard.getId()!=null && snowboard.getId().equals("")) {
        	snowboard.setId(null);
        }
        try {
    		Long l = new Date().getTime();
    		String id = l.toString();
        	snowboard.setId(id);
        	
            em = factory.createEntityManager();
            em.persist(snowboard);

        } catch (Exception e){
        	System.out.println(e);
        	sucess = false;
        } finally {
            if (em!=null) {
                em.close();
            }
        }
			
		return sucess;
	}
	
	public List<Snowboard> getAllSnowboards() throws Exception {
		log.info("Retreiving snowboard list...");
		
		EntityManager em = null;

        try {    		
            em = factory.createEntityManager();
            Query query = em.createQuery("select s from com.awscrud.domain.Snowboard s");
            return (List<Snowboard>)query.getResultList();
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
	}
	
	public void deleteSnowboardById(long snowboardId) throws Exception {
		log.info("Deleting snowboard: " + snowboardId);
		
		EntityManager em = null;

        try {    		
            em = factory.createEntityManager();
            Query query = em.createQuery("select s from com.awscrud.domain.Snowboard s where s.id= :snowboardid");
            query.setParameter("snowboardid", snowboardId);
            List<Snowboard> snowboards = query.getResultList();
            Snowboard snowboard = (Snowboard) snowboards.get(0);
            em.remove(snowboard);
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
	}
/*
	public void updateSnowboard(Snowboard snowboard) throws Exception {

		EntityManager em = SimpleDBEntityManagerFactory.getEntityManager();
		em.persist(snowboard);
		em.close();

	}

	public Snowboard getSnowboardById(int snowboardId) throws Exception {
		EntityManager em = SimpleDBEntityManagerFactory.getEntityManager();
		Query q = em.createQuery("select o from Snowboard o where o.id= :snowboardid");
		q.setParameter("snowboardid", snowboardId);
		List<Snowboard> obs = q.getResultList();
		Snowboard snowboard = (Snowboard) obs.get(0);
		em.close();
		return snowboard;
	}

	public void deleteSnowboard(Snowboard snowboard) throws Exception {
		EntityManager em = SimpleDBEntityManagerFactory.getEntityManager();
		em.remove(snowboard);
		em.close();
	}

	public int getTotalCountOfSnowboards() throws Exception {
		EntityManager em = SimpleDBEntityManagerFactory.getEntityManager();
		Query q = em.createQuery("select o from Snowboard o");
		List<Snowboard> obs = q.getResultList();
		em.close();
		return obs.size();
	}
	*/

}