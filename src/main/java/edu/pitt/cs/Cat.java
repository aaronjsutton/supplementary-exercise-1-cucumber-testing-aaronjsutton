package edu.pitt.cs;

import org.mockito.*;

public interface Cat {
	public static Cat createInstance(InstanceType type, int id, String name) {
		switch (type) {
			case IMPL:
				return new CatImpl(id, name);
			case BUGGY:
				return new CatBuggy(id, name);
			case SOLUTION:
				return new CatSolution(id, name);
			case MOCK:
				Cat cat = Mockito.mock(CatImpl.class);
				Mockito.when(rentACat.listCats()).thenReturn("ID 1. Testcat /nID 2. Testcat2");
				Mockito.when(rentACat.returnCat(1)).thenReturn(true);
				Mockito.when(rentACat.rentCat(1)).thenReturn(true);
				Mockito.when(rentACat.renameCat(1, "ranamedCat")).thenReturn(true);
				return null;
			default:
				assert(false);
				return null;
		}
	}

	// WARNING: You are not allowed to change any part of the interface.
	// That means you cannot add any method nor modify any of these methods.
	
	public void rentCat();

	public void returnCat();

	public void renameCat(String name);

	public String getName();

	public int getId();

	public boolean getRented();

	public String toString();
}
