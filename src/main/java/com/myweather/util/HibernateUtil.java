package com.myweather.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	private static Logger logger = LogManager.getLogger(HibernateUtil.class);

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create registry
				registry = new StandardServiceRegistryBuilder().configure()
						.build();

				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);

				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();
				//sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
				
				logger.info("HibernateUtil/getSessionFactory(): Session Factory created");
			} catch (Exception e) {

				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
				logger.error("HibernateUtil/getSessionFactory(): Exception while initializing hibernate util: "+e);	
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
