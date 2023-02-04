package com.fooddelivery.service1.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.service1.dao.OrderDao;
import com.fooddelivery.service1.domain.Order;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
public class Service1Application {

	@Autowired
    private OrderDao orderDao;

    @GetMapping
    public List<Order> fetchOrders() {
        return orderDao.getOrders().stream().
                sorted(Comparator.comparing(Order::getPrice)).collect(Collectors.toList());
    }
	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}

}
