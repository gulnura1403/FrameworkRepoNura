package com.prestashops.step_definitions;

import java.util.Locale;
import java.util.Map;

import com.prestashops.beans.User;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

/*
 * This class needs to be in same package as step definitiions
 * it will map the  datatable to our custom obj
 * we are doing transformation from data table to the custom class
 */

public class DataTableConfigurer implements TypeRegistryConfigurer{
	
	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}
	
	public void configureTypeRegistry (TypeRegistry typeRegistry) {
		typeRegistry.defineDataTableType(new DataTableType(User.class,
				
				new TableEntryTransformer<User>() {
			
			@Override
			public User transform(Map<String, String> row) throws Throwable {
				
				// these keys must match the data table
				String firstName = row.get("First Name");
				String lastName = row.get("Last Name");
				String address = row.get("Address");
				String company = row.get("Company");
				String city = row.get("City");
				return new User(firstName, lastName, address, company, city);
			}
				}));
	}
}
