package Application;

import Entities.Department;
import Entities.HourContract;
import Entities.Worker;
import Enums.Entities.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Digite o nome do departamento:");
        String departmentName = sc.nextLine();
        System.out.println("Insira os dados do trabalhador");
        System.out.println("Nome:");
        String WorkerName = sc.nextLine();
        System.out.println("Level: [JUNIOR/MID_LEVEL/SENIOR]");
        String workerLevel = sc.nextLine();
        System.out.println("Salário base:");
        double baseSallary = sc.nextDouble();

        Worker worker = new Worker(WorkerName, WorkerLevel.valueOf(workerLevel), baseSallary, new Department(departmentName));

        System.out.println("Quantos contratos esse trabalhador tem?");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Insira os dados do contrato nº " + i +":");
            System.out.print("Data (DD/MM/YYYY)");
            Date contractDate =  sdf.parse(sc.next());
            System.out.print("Valor por hora:");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duração por horas:");
            int hours = sc.nextInt();
            System.out.println();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Insira mês e ano para calcular a renda (MM/YYYY):");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Nome: " + worker.getName());
        System.out.println("Departamento: " + worker.getDepartment().getName());
        System.out.println("Renda do ano " + monthAndYear + ": R$" + String.format("%.2f", worker.income(year, month)));



        sc.close();
    }
}