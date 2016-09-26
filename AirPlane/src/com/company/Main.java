package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        String command = s.nextLine();
        System.out.println(getPosition(command));
    }

    public static String getPosition(String command){
        {

            if (command.length() == 0) {
                return ("(999,999)");
            }

            char arr[] = command.toCharArray();
            int i = 0;
            int len = arr.length;
            char c;
            int x = 0, y = 0;

            Stack<Character> data = new Stack<>();

            while (i < len){
                c = arr[i];
                switch (c){
                    case 'X':
                        if (!data.isEmpty()) {
                            data.pop();
                            while (!data.isEmpty() && Character.isDigit(data.peek())) {
                                data.pop();
                            }
                        }
                        break;
                    case 'U' :
                    case 'L' :
                    case 'D' :
                    case 'R' :
                        data.push(c);
                        break;
                    default:
                        if(Character.isDigit(c)) {
                            if (Integer.parseInt(c+"") == 0){
                                i++;
                            }else{
                                data.push(c);
                            }
                            break;
                        }
                        else {
                            return ("(999, 999)");
                        }
                }
                i++;
            }

            while (!data.isEmpty()){
                String ct = "0";
                c = data.pop();
                int num = 0;
                while (!data.isEmpty() && Character.isDigit(data.peek())) {
                    ct += data.pop();
                }
                num = Integer.parseInt(ct);
                if (num == 0)
                    num = 1;
                switch (c){
                    case 'L':
                        x -= num;
                        break;
                    case 'R':
                        x += num;
                        break;
                    case 'U':
                        y += num;
                        break;
                    case 'D':
                        y -= num;
                        break;
                }

            }
            return ("(" + x + "," + y + ")");
        }
    }
}
