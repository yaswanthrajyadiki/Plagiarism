class PlagiarismDemo {
	public static void main(String[] args) {
		String filename1 = "Document1.txt";
		String filename2 = "Document2.txt";
		Plagarism p = new Plagarism(filename1, filename2);
		System.out.println(p.calcPlagarismPercent() + "%");
	}
}