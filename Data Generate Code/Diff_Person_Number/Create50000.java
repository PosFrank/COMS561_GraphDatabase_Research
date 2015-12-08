import java.io.*;

import com.sun.org.apache.xpath.internal.operations.And;

public class Create50000 {
	public static void main(String[] args) throws IOException {
		final int numberOfPeople = 50000;
		
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
		String URL = "C:\\Users\\yingw\\Desktop\\561\\Project\\";
		FileOutputStream fout = new FileOutputStream(
				new File(URL+"origindata.txt"));
		PrintStream p = new PrintStream(fout);//
		
		FileOutputStream fout1 = new FileOutputStream(
				new File(URL+"dataOfNodeGender.txt"));
		PrintStream p1 = new PrintStream(fout1);// In p1 I use gender as a node
		
		// create age node
		FileOutputStream fout2 = new FileOutputStream(
				new File(URL+"dataOfNodeAge.txt"));
		PrintStream p2 = new PrintStream(fout2);
		
		
		// create age and gender
		FileOutputStream fout3 = new FileOutputStream(
				new File(URL+"dataOfNodeAandG.txt"));
		PrintStream p3 = new PrintStream(fout3);
		
		//create age above gender
		FileOutputStream fout4 = new FileOutputStream(
				new File(URL+"dataOfNodeAgeAboveGender.txt"));
		PrintStream p4 = new PrintStream(fout4);
		
		//create gender above age
		FileOutputStream fout5 = new FileOutputStream(
				new File(URL+"dataOfNodeGenderAboveAge.txt"));
		PrintStream p5 = new PrintStream(fout5);

		String ageNodes = "";
		
		for (int i = 0; i < 100; i++) {
			ageNodes = "create (A" + (i) + ":Age {age:" + (i) + "});";
			
			p2.println(ageNodes);
			p3.println(ageNodes);
			p4.println(ageNodes);
			//p5.println(ageNodes);
			String ageGender = "create (A"+ (i) +"Male:Gender {name:'Male',age:"+ (i) +"});";
			p4.println(ageGender);
			ageGender = "create (A"+ (i) +"Female:Gender {name:'Female',age:"+ (i) +"});";
			p4.println(ageGender);
			String relation4 = "match (c:Age), (d:Gender) where c.age = "+i+" and d.name='Male' and c.age=d.age create (c)-[r:AgeToGender]->(d);";
			p4.println(relation4);
			relation4 = "match (c:Age), (d:Gender) where c.age = "+i+" and d.name='Female' and c.age=d.age create (c)-[r:AgeToGender]->(d);";
			p4.println(relation4);
		}
		for (int i = 0; i < 100; i++) {
			ageNodes = "create (A" + (i) + ":Age {age:" + (i) + "});";
			
			p2.println(ageNodes);
			p3.println(ageNodes);
			p4.println(ageNodes);
			//p5.println(ageNodes);
			String ageGender = "create (A"+ (i) +"Male:Gender {name:'Male',age:"+ (i) +"});";
			p4.println(ageGender);
			ageGender = "create (A"+ (i) +"Female:Gender {name:'Female',age:"+ (i) +"});";
			p4.println(ageGender);
			String relation4 = "create ((A"+(i)+")-[r:AgeToGender]->(A"+(i)+"Male);)";
			p4.println(relation4);
			relation4 = "create ((A"+(i)+")-[r:AgeToGender]->(A"+(i)+"Female);)";
			p4.println(relation4);
		}

		String genderNodes = "create (Male:Gender {name:'Male'});";
		p1.println(genderNodes);
		p3.println(genderNodes);
		//p4.println(genderNodes);
		p5.println(genderNodes);
		genderNodes = "create (Female:Gender {name:'Female'});";
		p1.println(genderNodes);
		p3.println(genderNodes);
		//p4.println(genderNodes);
		p5.println(genderNodes);
		
		for(int j = 0; j <100;j++) {
			String genderAge = "create (A"+ (j) +"Male:Age {name:'Male',age:"+ (j) +"});";
			p5.println(genderAge);
			genderAge = "create (A"+ (j) +"Female:Age {name:'Female',age:"+ (j) +"});";
			p5.println(genderAge);
			String relation5 = "create ((A"+(j)+"Male)-[r:AgeToGender]->(A"+(j)+");)";
			p5.println(relation5);
			relation5 = "create ((A"+(j)+"Female)-[r:AgeToGender]->(A"+(j)+");)";
			p5.println(relation5);
		}

		/*
		 * this for loop generate all the related neo4j node create query
		 */
		for (int i = 0; i <numberOfPeople; i++) {
			
			String firstname = firstNameSet[i % 10];
			String lastname = lastNameSet[(int) (100 * Math.random()) % 10];
			int age = (int) (99 * Math.random());
			double genderChoose = Math.random();
			String gender = (genderChoose > 0.5 ? "Male" : "Female");
			String query = "create (P" + (i + 1) + ":Person {ID"+(i+1)+", name:'" + firstname + " " + lastname + "',age:" + age
					+ ",gender:'" + gender + "'});";
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
			String relation4 = "create (A"+age + gender + ")-[:Has_Gender]->(P" + (i + 1) + ")";
			p4.println(relation4);
			
			//gender above age
			String query5 = "create (P" + (i + 1) + ":Person {name:'" + firstname + " " + lastname + "'})";
			p5.println(query5);
			String relation5 = "create (A" + age + gender+")-[:Has_Age]->(P" + (i + 1) + ")";
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
