package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/cars")
	public String printCars(
			@RequestParam(value = "count", required = false) Integer countCars,
			ModelMap model) {
		CarServiceImpl carService = new CarServiceImpl();
		List<Car> list = carService.getCarList();
		if (countCars == null || countCars < 0 || countCars > list.size()) {
			countCars = list.size();
		}
		model.addAttribute("cars", list.stream().limit(countCars).toList());
		model.addAttribute("countCars", countCars);
		return "cars.html";
	}
	
}