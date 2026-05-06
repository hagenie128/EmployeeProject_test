package service;

import vo.EmployeeVO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeService {
    private static EmployeeService instance = new EmployeeService();
    private ArrayList<EmployeeVO> list;
    private EmployeeService() {
        list = new ArrayList<>();
        //파일 로드해서 리스트에 초기화
        loadToCSV();
    }

    public ArrayList<EmployeeVO> getList() {
        return list;
    }

    private void loadToCSV() {
        try(FileReader fr = new FileReader("employee.csv");
            BufferedReader br = new BufferedReader(fr)){

            while(true){
                String str = br.readLine();
                if(str == null) break;
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static EmployeeService getInstance() {
        if (instance == null)
            instance = new EmployeeService();
        return instance;
    }
}
