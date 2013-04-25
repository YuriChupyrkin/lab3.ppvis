package Server.Controller;

import Server.Model.Data;
import Server.Parsers.DOMPars;
import Server.Parsers.SAXPars;
import Server.View.MainFrame;

public class Adapter {

	private MainFrame mainFrame;
	private Data data;
	private DOMPars domPars;
	private SAXPars saxPars;
	private LoaderSaver loaderSaver;
	
	public Adapter(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		data = new Data(this);
		
		loaderSaver = new LoaderSaver(this);
		domPars = new DOMPars(this);
		//saxPars = new SAXPars(this);		
	}
	
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public Data getData() {
		return data;
	}
	
	public DOMPars getDomPars() {
		return domPars;
	}
	
	public LoaderSaver getLoaderSaver() {
		return loaderSaver;
	}
}
