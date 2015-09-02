import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

class Plagiarism {
	String filename1;
	String filename2;
	String content1;
	String content2;
	
	Plagarism(String filename1, String filename2) {
		this.filename1 = filename1;
		this.filename2 = filename2;
		content1 = this.extractContent(filename1);
		content2 = this.extractContent(filename2);
	}

	public String extractContent(String filename) {
		StringBuffer content = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = br.readLine()) != null) {
				content.append(line);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return content.toString();
	}

	public int calcPlagarismPercent() {
		int percent;
		int count1 = 0;
		int commonWordCount = 0;
		StringTokenizer st = new StringTokenizer(content1,
									".><:&();{}, \t\n\"");
		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			count1++;
			if (content2.contains(word)) {
				commonWordCount++;
			}
		}
		percent = (commonWordCount * 100)/count1;
		return percent;
	}
}