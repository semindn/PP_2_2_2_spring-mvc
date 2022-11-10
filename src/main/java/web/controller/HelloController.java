package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

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
		Car car1 = new Car("model1", "color1", 101);
		Car car2 = new Car("model2", "color2", 102);
		Car car3 = new Car("model3", "color3", 103);
		Car car4 = new Car("model4", "color4", 104);
		Car car5 = new Car("model5", "color5", 105);
		List<Car> list = new ArrayList<>();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		list.add(car4);
		list.add(car5);
		if (countCars == null || countCars < 0 || countCars > list.size()) {
			countCars = list.size();
		}
		model.addAttribute("cars", list.stream().limit(countCars).toList());
		model.addAttribute("countCars", countCars);
		return "cars.html";
	}
	
}