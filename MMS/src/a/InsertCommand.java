package a;

import java.util.Scanner;

import com.naver.MemberDTO;

import kr.co.ca.Command;

public class InsertCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("ID를 입력하세요.");
		String id = sc.nextLine();
		
		System.out.println("NAME을 입력하세요.");
		String name = sc.nextLine();
		
		System.out.println("AGE를 입력하세요.");
		String sAge = sc.nextLine();
		int age = Integer.parseInt(sAge);
		
		MemberDTO dto = new MemberDTO(id, name, age);
		
		MemberDTO dao = new MemberDTO();
		
		
		
		
	}

}
