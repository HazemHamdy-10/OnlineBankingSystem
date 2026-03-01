package com.mycompany.my_projct_java;

import java.util.Scanner;

public class My_projct_java {

    public static void main(String[] args)
    {
        
        Scanner input = new Scanner(System.in);
        System.out.println(" Name projct : Personal Budget Management System");
        
        
        System.out.println("\n" +
        " -> Personal Budget Management System\n" +
        " -> This program calculates total expenses, remaining balance,\n" +
        " -> expense percentages, and ranks expenses from highest to lowest\n" +
        " -> to help users manage their monthly budget.\n ");
        
        final String DEVELO = "Developed by : Mahmoud Ahmed Hassan";
        System.out.println(DEVELO);

        // قراءة البيانات من المستخدم
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your monthly income: ");
        double income = input.nextDouble();

        System.out.print("Enter food expenses: ");
        double food = input.nextDouble();

        System.out.print("Enter transport expenses: ");
        double transport = input.nextDouble();

        System.out.print("Enter bills expenses: ");
        double bills = input.nextDouble();

        System.out.print("Enter Shopping expenses: ");
        double Shopping = input.nextDouble();

        System.out.print("Enter Entertainment expenses: ");
        double entertainment = input.nextDouble();

        System.out.print("Enter Education expenses: ");
        double education = input.nextDouble();

        System.out.print("Enter Health expenses: ");
        double health = input.nextDouble();

        // احسب المجموع والمبلغ المتبقي 
        double totalExpenses = food + transport + bills + Shopping + entertainment + education + health;
        double remaining = income - totalExpenses;

        // احسب النسب المئوية لكل نوع من المصاريف
        double foodPercent = (food / totalExpenses) * 100;
        double transportPercent = (transport / totalExpenses) * 100;
        double billsPercent = (bills / totalExpenses) * 100;
        double shoppingPercent = (Shopping / totalExpenses) * 100;
        double entertainmentPercent = (entertainment / totalExpenses) * 100;
        double educationPercent = (education / totalExpenses) * 100;
        double healthPercent = (health / totalExpenses) * 100;
        
        // اعرض التقرير الشهري
        System.out.println("\n===== Monthly Report =====");
        System.out.println("Name: " + name);
        System.out.println("Total Expenses: " + totalExpenses);
        if (totalExpenses < income)
        {
            System.out.println("Remaining Balance: " + remaining);
        }
        else
        System.out.println("Warning! You are overspending! Money You Owe:  " + remaining);

        
        // اعرض النسب المئوية للمصاريف
        System.out.println("\n===== Expense Percentages =====");
        System.out.println("Food: " + foodPercent + "%");
        System.out.println("Transport: " + transportPercent + "%");
        System.out.println("Bills: " + billsPercent + "%");
        System.out.println("Shopping: " + shoppingPercent + "%");
        System.out.println("Entertainment: " + entertainmentPercent + "%");
        System.out.println("Education: " + educationPercent + "%");
        System.out.println("Health: " + healthPercent + "%");
        
         // تقييم إدارة الميزانية
        if (remaining < 0) {
        System.out.println("Warning! You are spending more than your income!");

        
         System.out.println("\n===== Expense Analysis =====");

        if (food > transport && food > bills && food > Shopping && food > entertainment && food > education && food > health) {
        System.out.println("You spend most of your money on Food. Try to reduce eating outside."); 
        
        } else if (transport > food && transport > bills && transport > Shopping && transport > entertainment && transport > education && transport > health) {
        System.out.println("Transport is your highest expense. Try to reduce transportation costs.");
        }
        else if (bills > food && bills > transport && bills > Shopping && bills > entertainment && bills > education && bills > health) {
        System.out.println("Bills are taking most of your income. Try to manage utilities wisely.");
        }
        else if (Shopping > food && Shopping > transport && Shopping > bills && Shopping > entertainment && Shopping > education && Shopping > health) {
        System.out.println("Shopping is your highest expense. Try to reduce unnecessary purchases.");
        }
        else if (entertainment > food && entertainment > transport && entertainment > bills && entertainment > Shopping && entertainment > education && entertainment > health) {
        System.out.println("Entertainment is your highest expense. Try to reduce leisure spending.");
        }
        else if (education > food && education > transport && education > bills && education > Shopping && education > entertainment && education > health) {
        System.out.println("Education is your highest expense. Make sure it is well planned.");
        }
        else if (health > food && health > transport && health > bills && health > Shopping && health > entertainment && health > education) {
        System.out.println("Health is your highest expense. Keep it necessary and budgeted.");
        }
        else {
        System.out.println("Your expenses are balanced.");
        }

        } else {
        System.out.println("Good job! You are managing your budget well.");
    
    }
        // نعرف مصفوفة فيها كل المصاريف  &علشان ارتب المصاريف من الاصغر للاكبر 
        double [] expenses =  {food,transport,bills,Shopping,entertainment, education, health };
        String [] categories = {"Food","Transport","Bills","Shopping","entertainment"," Education ", "Health"};
        
        for (int i = 0; i <expenses.length -1;i++)
        {
          for (int j = i + 1 ; j < expenses.length;j++ )
          {
            if (expenses[j] > expenses[i])
                {
                        double tempValue = expenses[i];
                        expenses [i] = expenses[j];
                        expenses[j] = tempValue;
                        
                        String tempCategory = categories[i];
                        categories[i] = categories[j];
                        categories[j] = tempCategory;
                        
                }
          }
          
        }
        
        // عرض المصاريف بعد الترتيب
        System.out.println("\n===== Expenses Ranked =====");
        
        for (int i = 0; i < expenses.length; i++)
        {   
            System.out.println((i+1) + ". " + categories[i] + ": " + expenses[i] + " (" + (expenses[i]/income*100) + "%)");
        }

        System.out.println("\nThank you for using our program! Keep exploring and have a great day! - Developed Mahmoud Ahmad Hassan");
        input.close();
        }
}