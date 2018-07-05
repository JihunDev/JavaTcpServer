import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class csvFileRoad {
	public static List<String> Road(String Uri) {
		List<String> tmpLineList = new ArrayList<String>();
		BufferedReader br = null;

		System.out.println(timeChk.getTime() + " " + Uri);
		System.out.println(timeChk.getTime() + " File Road Start");

		try {
			br = Files.newBufferedReader(Paths.get(Uri));
			Charset.forName("UTF-8");
			String line = "";

			for (int i = 0; (line = br.readLine()) != null; i++) {
				/* Fist Tag Name Pass */
				if (i == 0) {
					continue;
				}
				/* Value List Add*/
				tmpLineList.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println(timeChk.getTime() + " File Road End");

		return tmpLineList;
	}
}
