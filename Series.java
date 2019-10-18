package sommerjobb2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class Series {
	
	private String title;
	private Collection<String> seriesTypes = new ArrayList<>();
	private final String ID;
	
	public Series(String title, String... seriesTypes) {
		if(seriesTypes == null) {
			throw new IllegalArgumentException("A series needs a type");
		}
		
		this.ID = UUID.randomUUID().toString();
		this.title = title;
		
		Collection<String> types = Arrays.stream(seriesTypes).collect(Collectors.toList());
		this.seriesTypes.addAll(types);
		
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
	
	public String getTitle() {
		return this.title;
	}
	
	public Collection<String> getSeriesTypes() {
		return this.seriesTypes;
	}
}
