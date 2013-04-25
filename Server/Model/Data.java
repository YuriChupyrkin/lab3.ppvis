package Server.Model;

import Server.Controller.Adapter;

public class Data {

	private Adapter adapter;
	
	public Data(Adapter adapter) {
		super();
		this.adapter = adapter;
	}

	
	
	public Adapter getAdapter() {
		return adapter;
	}
}
