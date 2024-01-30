package edu.pitt.cs;

import org.mockito.Mockito;

public interface RentACat {
	public static RentACat createInstance(InstanceType type) {
		switch (type) {
			case IMPL:
				return new RentACatImpl();
			case BUGGY:
				return new RentACatBuggy();
			case SOLUTION:
				return new RentACatSolution();
			case MOCK:
				RentACat rentACat = Mockito.mock(RentACat.class);
				Mockito.when(rentACat.listCats()).thenReturn("ID 1. Testcat /nID 2. Testcat2");
				Mockito.when(rentACat.returnCat(1)).thenReturn(true);
				Mockito.when(rentACat.rentCat(1)).thenReturn(true);
				Mockito.when(rentACat.renameCat(1, "ranamedCat")).thenReturn(true);
				return rentACat;
			default:
				assert (false);
				return null;
		}
	}

	// WARNING: You are not allowed to change any part of the interface.
	// That means you cannot add any method nor modify any of these methods.

	public boolean returnCat(int id);

	public boolean rentCat(int id);

	public boolean renameCat(int id, String name);

	public String listCats();

	public void addCat(Cat c);
}
