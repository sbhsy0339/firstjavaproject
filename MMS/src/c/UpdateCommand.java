package c;

import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class UpdateCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("수정할 아이디를 입력하세요.");
		String id = sc.nextLine();
		
		System.out.println("NAME을 입력하세요.");
		String name = sc.nextLine();
		
		System.out.println("AGE를 입력하세요.");
		int age = sc.nextInt();
		sc.nextLine();
		
		MemberDTO dto = new MemberDTO(id, name, age);
		
		MemberDAO dao = new MemberDAO();
		dao.update(dto);
	}

}
