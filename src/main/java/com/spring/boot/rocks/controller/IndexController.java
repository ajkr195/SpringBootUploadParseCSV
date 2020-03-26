package com.spring.boot.rocks.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.spring.boot.rocks.model.AppUser;

@Controller
public class IndexController {

	@GetMapping("/")
	public String homePage() {
		return "index";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/uploadcsv")
	public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a CSV file to upload.");
			model.addAttribute("status", false);
		} else {

			try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

				CsvToBean<AppUser> csvToBean = new CsvToBeanBuilder(reader).withType(AppUser.class)
						.withIgnoreLeadingWhiteSpace(true).build();
				
				List<AppUser> appUsersList = csvToBean.parse();
				
				model.addAttribute("appuserslist", appUsersList);
				model.addAttribute("status", true);

			} catch (Exception ex) {
				model.addAttribute("message", "An error occurred while loading and parsing the CSV file.");
				model.addAttribute("status", false);
			}
		}
		return "csvuploadstatus";
	}

	@GetMapping("/contact")
	public String contactPage() {
		return "contact";
	}

	@GetMapping("/about")
	public String aboutPage() {
		return "about";
	}
}
