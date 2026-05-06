package controller;

import exception.EmployeeException;
import service.EmployeeService;
import vo.EmployeeVO;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchForNameController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("사원 정보 검색을 시작합니다.....");
        System.out.print("검색할 사원명 일부 : ");
        String name = sc.nextLine();

        try {
            ArrayList<EmployeeVO> list = EmployeeService.getInstance().searchForNameEmployee(name);
            // 검색 결과 출력
            list.forEach(item -> System.out.println(item));

            EmployeeService.getInstance().searchForNameEmployee(name).forEach(
                    item -> System.out.println(item));
        } catch (EmployeeException e) {
            throw new RuntimeException(e);
        }
    }
}
