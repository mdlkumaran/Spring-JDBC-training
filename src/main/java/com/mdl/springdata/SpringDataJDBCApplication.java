package com.mdl.springdata;

import com.mdl.springdata.dao.jdbcDaoImpl;
import com.mdl.springdata.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringDataJDBCApplication implements ApplicationRunner {

	@Autowired
	jdbcDaoImpl jdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJDBCApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		int count = jdbcDao.getCircleCount(1);
//		System.out.println("count:" +count);
//		String name = jdbcDao.getCircleForParam(1);
//		System.out.println("name:" +name);
//		Circle circle = jdbcDao.getCircleForId(1);
//		System.out.println("Circle_name: " + circle.getName());
//		List<Circle> allCircles = jdbcDao.getAllCirclesById(1);
//		System.out.println("count: " + allCircles.size());
//		List<Circle> allCircles = jdbcDao.getAllCircles();
//		System.out.println("allCircles_Count: " + allCircles.size());
//		jdbcDao.createTriangle();
//		jdbcDao.insertTriangle(1, "First Triangle");
//		int count = jdbcDao.triangleCount();
//		System.out.println("count:" +count);
		jdbcDao.insertCircle(3, "Fourth Triangle");
		int count = jdbcDao.getCircleCount();
		System.out.println("count:" +count);
	}
}
