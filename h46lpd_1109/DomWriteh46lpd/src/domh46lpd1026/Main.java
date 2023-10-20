package domh46lpd1026;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Main {

	public static void main(String[] args) {
		DomWriteh46lpd domWriteh46lpd = new DomWriteh46lpd();
		try {
			domWriteh46lpd.write();
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}

}
