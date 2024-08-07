package com.ghada.ninjagoldgame.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@RequestMapping("/activities")
	public String activities() {
		return "activities.jsp";
	}

	@RequestMapping("/")
	public String index(HttpSession session, @RequestParam(value = "farm", required = false) String farm,
			@RequestParam(value = "cave", required = false) String cave,
			@RequestParam(value = "house", required = false) String house,
			@RequestParam(value = "quest", required = false) String quest) {
		int gold = 0;
		ArrayList<String> activities = new ArrayList<String>();

		SimpleDateFormat date = new SimpleDateFormat("MMMM d Y h:mm a");

		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", gold);
			session.setAttribute("activities", activities);
		} else {
			gold = (int) session.getAttribute("gold");
			activities = (ArrayList<String>) session.getAttribute("activities");
		}

		if (farm != null) {
			int randomGoldForFarm = new Random().nextInt(11) + 10;
			gold += randomGoldForFarm;
			activities.add(0,
					"You entered a farm and earned " + randomGoldForFarm + " gold. (" + date.format(new Date()) + ")");
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold);
			return "redirect:/";
		}

		if (cave != null) {
			int randomGoldForCave = new Random().nextInt(6) + 5;
			gold += randomGoldForCave;
			activities.add(0,
					"You entered a cave and earned " + randomGoldForCave + " gold. (" + date.format(new Date()) + ")");
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold);
			return "redirect:/";
		}

		if (house != null) {
			int randomGoldForHouse = new Random().nextInt(4) + 2;
			gold += randomGoldForHouse;
			activities.add(0, "You entered a house and earned " + randomGoldForHouse + " gold. ("
					+ date.format(new Date()) + ")");
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold);
			return "redirect:/";
		}

		if (quest != null) {
			int randomGoldForQuest = new Random().nextInt(101) - 50;
			gold += randomGoldForQuest;
			if (randomGoldForQuest >= 0) {
				activities.add(0, "You completed a quest and earned " + randomGoldForQuest + " gold. ("
						+ date.format(new Date()) + ")");
			} else {
				activities.add(0, "You failed a quest and lost " + (randomGoldForQuest * -1) + " gold. ("
						+ date.format(new Date()) + ")");
			}
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold);
			return "redirect:/";
		}

		return "index.jsp";
	}

}
