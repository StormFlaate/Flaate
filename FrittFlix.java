

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import junit.framework.TestCase;

public class FrittFlix extends TestCase {

	private List<Customer> customers;
	private List<Series> shows;
	
	
	public FrittFlix() {
		this.customers = new ArrayList<>();
		this.shows = new ArrayList<>();
		
	}
	
	public List<Customer> getCustomers() {
		return this.customers;
	}
	
	public List<Series> getSeries() {
		return this.shows;
	}
	
	// REGISTER
	public boolean registerCustomer(String name, String... seriesTypes) {
		Customer currentCustomer = new Customer(name, seriesTypes);
		
		if(!this.customers.contains(currentCustomer)) {
			return this.customers.add(currentCustomer);
		} 
		return false;
	}
	
	// REGISTER
	public boolean registerSeries(String name, String... seriesTypes) {
		Series currentSeries = new Series(name, seriesTypes);
		
		if(!this.shows.contains(currentSeries)) {
			return this.shows.add(currentSeries);
		}
		return false;
	}
	
	// COLLECT
	public Customer getCustomerByID(String customerID) {
		
		List<Customer> valid = this.customers
				.stream()
				.filter(x -> (x.getID() == customerID))
				.collect(Collectors.toList());
		if(valid.size() != 1) {
			throw new IllegalStateException("This is not a valid state");
		}
		
		return valid.get(0);
	}
	
	
	public Collection<Customer> getCustomerBySeriesID(String seriesID) {
		
		Series currentSeries = this.getSeriesByID(seriesID);
		Collection<String> seriesTypes = currentSeries.getSeriesTypes();
		Collection<Customer> validCustomers = new ArrayList<>();
		
		for (Customer user : this.customers) {
			for(String types : seriesTypes) {
				if(user.getSeriesTypes()
				.stream()
				.anyMatch(x -> (x == types))) {
					validCustomers.add(user);
					break;
				}
			}
		}
				
		return validCustomers;
	}
	
	// Helpfunction to get series by ID
	private Series getSeriesByID(String seriesID) {
		List<Series> valid = this.shows
				.stream()
				.filter(x -> (x.getID() == seriesID))
				.collect(Collectors.toList());
		if(valid.size() != 1) {
			throw new IllegalStateException("This is not a valid state");
		}
		
		return valid.get(0);
	
	}
	
	public List<Series> getSeriesByType(String seriesType) {
		List<Series> validSeries = this.shows
				.stream()
				.filter(x -> (x.getSeriesTypes()
						.stream()
						.anyMatch(b -> (b == seriesType))))
				.sorted()
				.collect(Collectors.toList());
		
		
		return validSeries;
		
	}
	
	public Collection<Customer> getCustomersByDate(LocalDate date1, LocalDate date2) {
		
		Collection<Customer> validCustomers = this.customers
				.stream()
				.filter(customer -> (date1.isBefore(customer.getDate()) && date2.isAfter(customer.getDate())))
				.collect(Collectors.toList());
		
		return null;
	}
	
	
	public long getIntrestWeight(String customerID, String seriesID) {
		
		Series show = this.getSeriesByID(seriesID);
		Customer person = this.getCustomerByID(customerID);
		
		return person.getSeriesTypes()
				.stream()
				.filter(typea -> (
						show.getSeriesTypes()
						.stream()
						.anyMatch(typeb -> (typea.equals(typeb)))))
				.count();		
	}
	
	
	public Series getHighestIntrest() {
		
		Series max = this.shows.get(0);
		long maxValue = 0;
		
		for(Series series : this.shows) {
			long currentSeriesWeigth = 0;
			for(Customer person : this.customers) {
				long customerWeigth = this.getIntrestWeight(person.getID(), series.getID());
				currentSeriesWeigth += customerWeigth;
			}
			if(maxValue < currentSeriesWeigth) {
				maxValue = currentSeriesWeigth;
				max = series;
			}
		}
		return max;
	}
	
	
	
	
	
	
	
}
