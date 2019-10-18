package sommerjobb2020;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

public class Customer {

	private final String ID;
	private String name;
	private final LocalDate date;
	private Collection<String> seriesTypes = new ArrayList<>();
	
	
	public Customer(String name, String... seriesTypes) {
		this.ID = UUID.randomUUID().toString();
		this.date = java.time.LocalDate.now();
		this.name = name;
		if(seriesTypes != null) {
			Collection<String> types = Arrays.stream(seriesTypes)
					.collect(Collectors.toList());
			this.seriesTypes.addAll(types);
		}
	}
	
	public boolean addSeriesTypes(String type) {
		return this.seriesTypes.add(type);
	}
	
	public boolean removeSeriesTypes(String type) {
		return this.seriesTypes.remove(type);
	}
	
	// Getters
	public String getID() {
		return this.ID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public LocalDate getDate() {
		return this.getDate();
	}
	
	public Collection<String> getSeriesTypes() {
		return this.seriesTypes;
	}
}
