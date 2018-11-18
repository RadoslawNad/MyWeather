package com.myweather;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.myweather.domain.WeatherObject;
import com.myweather.domain.repository.historyDao.HistoryDaoImpl;
import com.myweather.service.HistoryService;
import com.myweather.util.HibernateUtil;


public class ClientTest {

	
	
	public static void main(String[] args) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();

	    WeatherObject wo=new WeatherObject();
	    wo.setStationName("Lubartow");
	    HistoryDaoImpl hd=new HistoryDaoImpl();
	    hd.getHistory();
	    


	}

}
