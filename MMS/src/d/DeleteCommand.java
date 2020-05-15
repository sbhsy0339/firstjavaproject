package d;

import java.util.Scanner;

import com.naver.MemberDAO;

import kr.co.ca.Command;

public class DeleteCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("ID를 입력하세요.");
		String id = sc.nextLine();
		
		MemberDAO dao = new MemberDAO();
		dao.delete(id);
		
		
	}

}
