import java.io.*;

public class Create {
    
    private final PERSON_NUMBER = 20000;
    
	public static void main(String[] args) throws IOException {
		FileOutputStream fout = new FileOutputStream(
				new File("C:\\Users\\as\\origindata.txt"));
		PrintStream p = new PrintStream(fout);//
		// p.println to write into txt file.
		String[] firstNameSet = new String[10];
		String[] lastNameSet = new String[10];
		// int age;
		firstNameSet[0] = "Zoey";
		firstNameSet[1] = "Barney";
		firstNameSet[2] = "Robin";
		firstNameSet[3] = "Alex";
		firstNameSet[4] = "Ted";
		firstNameSet[5] = "Harry";
		firstNameSet[6] = "Jamie";
		firstNameSet[7] = "Kevin";
		firstNameSet[8] = "Marvin";
		firstNameSet[9] = "Nancy";
		//////////////////////
		lastNameSet[0] = "Mosby";
		lastNameSet[1] = "Aldrin";
		lastNameSet[2] = "Case";
		lastNameSet[3] = "Wang";
		lastNameSet[4] = "James";
		lastNameSet[5] = "Donald";
		lastNameSet[6] = "Eric";
		lastNameSet[7] = "Stinson";
		lastNameSet[8] = "Poppy";
		lastNameSet[9] = "Randy";
		///////////////////////
		FileOutputStream fout1 = new FileOutputStream(
				new File("C:\\Users\\as\\dataOfNodeGender.txt"));
		PrintStream p1 = new PrintStream(fout1);// In p1 I use gender as a node
		
		////////////////
		

		// create age node
		FileOutputStream fout2 = new FileOutputStream(
				new File("C:\\Users\\as\\dataOfNodeAge.txt"));
		PrintStream p2 = new PrintStream(fout2);
		String ageNodes = "";
		
		
		// create age and gender
		FileOutputStream fout3 = new FileOutputStream(
				new File("C:\\Users\\as\\dataOfNodeAandG.txt"));
		PrintStream p3 = new PrintStream(fout3);
		
		//create age above gender
		FileOutputStream fout4 = new FileOutputStream(
				new File("C:\\Users\\as\\dataOfNodeAgeAboveGender.txt"));
		PrintStream p4 = new PrintStream(fout4);
		
		//create gender above age
		FileOutputStream fout5 = new FileOutputStream(
				new File("C:\\Users\\as\\dataOfNodeGenderAboveAge.txt"));
		PrintStream p5 = new PrintStream(fout5);

		for (int i = 0; i < 100; i++) {
			ageNodes = "create (A" + (i) + ":Age {age:" + (i) + "});";
			p2.println(ageNodes);
			p3.println(ageNodes);
			p4.println(ageNodes);
			p5.println(ageNodes);
		}
		
		// create gender node
		String genderNodes = "create (Male:Gender {name:'Male'})";
		p1.println(genderNodes);
		p3.println(genderNodes);
		p4.println(genderNodes);
		p5.println(genderNodes);
		genderNodes = "create (Female:Gender {name:'Female'})";
		p1.println(genderNodes);
		p3.println(genderNodes);
		p4.println(genderNodes);
		p5.println(genderNodes);
		for (int i = 0; i < PERSON_NUMBER; i++) {
			
			String firstname = firstNameSet[i % 10];
			String lastname = lastNameSet[(int) (100 * Math.random()) % 10];
			int age = (int) (99 * Math.random());
			double genderChoose = Math.random();
			String gender = (genderChoose > 0.5 ? "Male" : "Female");
			String query = "create (P" + (i + 1) + ":Person {name:'" + firstname + " " + lastname + "',age:" + age
					+ ",gender:'" + gender + "'})";
			p.println(query);
			
			//System.out.println(firstname + " "+lastname + " "+ gender + " "+ age);
			
			// create relation
			String query1 = "create (P" + (i + 1) + ":Person {name:'" + firstname + " " + lastname + "',age:" + age
					+ "})";
			p1.println(query1);
			String relation1 = "create (" + gender + ")-[:Has_Gender]->(P" + (i + 1) + ")";
			p1.println(relation1);
			
			
			String query2 = "create (P" + (i + 1) + ":Person {name:'" + firstname + " " + lastname + "',gender:'"
					+ gender + "'});";
			p2.println(query2);
			String relation2 = "create (A" + age + ")-[:Has_Age]->(P" + (i + 1) + ");";
			p2.println(relation2);
			
			//age and gender
			String query3 = "create (P" + (i + 1) + ":Person {name:'" + firstname + " " + lastname + "'})";
			p3.println(query3);
			String relation3 = "create (A" + age + ")-[:Has_Age]->(P" + (i + 1) + ")";
			p3.println(relation3);
			relation3 = "create (" + gender + ")-[:Has_Gender]->(P" + (i + 1) + ")";
			p3.println(relation3);
			
			//age above gender
			String query4 = "create (P" + (i + 1) + ":Person {name:'" + firstname + " " + lastname + "'})";
			p4.println(query4);
			String relation4 = "create (" + gender + ")-[:Has_Gender]->(P" + (i + 1) + ")";
			p4.println(relation4);
			relation4 = "create (A" + age + ")-[:AgeToGender]->(" + gender + ")";
			p4.println(relation4);
			
			//gender above age
			String query5 = "create (P" + (i + 1) + ":Person {name:'" + firstname + " " + lastname + "'})";
			p5.println(query5);
			String relation5 = "create (A" + age + ")-[:Has_Age]->(P" + (i + 1) + ")";
			p5.println(relation5);
			relation5 = "create (" + gender + ")-[:GenderToAge]->(A" + age + ")";
			p5.println(relation5);
			
		}
		p.close();
		p1.close();
		p2.close();
		p3.close();
		p4.close();
		p5.close();
	}
}
