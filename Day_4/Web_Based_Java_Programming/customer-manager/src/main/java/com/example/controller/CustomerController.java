package com.example.controller;

import com.example.customermanager.model.Customer;
import com.example.customermanager.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private final CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}

	// List all
	@GetMapping
	public String listCustomers(Model model) {
		model.addAttribute("customers", service.findAll());
		return "list";
	}

	// Show add form
	@GetMapping("/new")
	public String showCreateForm(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("title", "Add Customer");
		return "form";
	}

	// Save new or edited
	@PostMapping("/save")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", customer.getId() == null ? "Add Customer" : "Edit Customer");
			return "form";
		}
		service.save(customer);
		return "redirect:/customers";
	}

	// Show edit form
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Customer customer = service.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
		model.addAttribute("customer", customer);
		model.addAttribute("title", "Edit Customer");
		return "form";
	}

	// Delete
	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable("id") Long id) {
		service.deleteById(id);
		return "redirect:/customers";
	}
}
