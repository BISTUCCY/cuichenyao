package com.example.ex1calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity  {
    private static int check_function = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        int mCurrentOrientation = getResources().getConfiguration().orientation;
//        if(mCurrentOrientation == Configuration.ORIENTATION_PORTRAIT)
//        {
//            Intent i = getIntent();
//            setContentView(R.layout.activity_main);
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        }else
//        {
//            Intent i = new Intent(MainActivity.this,MainActivity2.class);
//            setContentView(R.layout.activity_main);
//            startActivity(i);
//        }
        final TextView textblock=(TextView) findViewById(R.id.cal);
        Button btn0=(Button)findViewById(R.id.bt_0);
        Button btn1=(Button)findViewById(R.id.bt_1);
        Button btn2=(Button)findViewById(R.id.bt_2);
        Button btn3=(Button)findViewById(R.id.bt_3);
        Button btn4=(Button)findViewById(R.id.bt_4);
        Button btn5=(Button)findViewById(R.id.bt_5);
        Button btn6=(Button)findViewById(R.id.bt_6);
        Button btn7=(Button)findViewById(R.id.bt_7);
        Button btn8=(Button)findViewById(R.id.bt_8);
        Button btn9=(Button)findViewById(R.id.bt_9);

        Button btnplus=(Button)findViewById(R.id.bt_plus);
        Button btnminus=(Button)findViewById(R.id.bt_minus);
        Button btntime=(Button)findViewById(R.id.bt_time);
        Button btndiv=(Button)findViewById(R.id.bt_divide);

        Button btnclear=(Button)findViewById(R.id.bt_clear);
        Button btnbackspace=(Button)findViewById(R.id.bt_backspace);

        Button btnpoint=(Button)findViewById(R.id.bt_point);
        Button btnpercent=(Button)findViewById(R.id.bt_percent);
        Button btnequal=(Button)findViewById(R.id.bt_equal);

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String currentText = (String)textblock.getText();
                int tag = (Integer)view.getTag();
                switch(tag){
                    case 11:
                        currentText += "+";
                        break;
                    case 22:
                        currentText += "-";
                        break;
                    case 33:
                        currentText += "*";
                        break;
                    case 44:
                        currentText += "/";
                        break;

                    case 55:
                        currentText = "";
                        break;
                    case 66:
                        if(currentText.length()>0)
                        {
                            currentText=currentText.substring(0,currentText.length()-1);
                            break;
                        }
                        break;

                    case 77:
                        currentText += ".";
                        break;
                    case 88:
                        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
                        Matcher isNum = pattern.matcher(currentText);
                        if(!isNum.matches())
                        {
                            break;
                        }else
                        {
                            double num = Double.parseDouble(currentText);
                            num=num/100;
                            NumberFormat numberFormat = NumberFormat.getInstance();
                            numberFormat.setMaximumFractionDigits(15);
                            numberFormat.setGroupingUsed(false);
                            currentText = numberFormat.format(num);
                            break;
                        }

                    case 99:
                        if(currentText.substring(currentText.length()-1).equals(")")&&check_function!=0) {
                            currentText = currentText.substring(0, currentText.length() - 1);
                        }
                        currentText = run(currentText);
                        break;
                    case 0:
                        currentText += "0";
                        break;
                    case 1:
                        currentText += "1";
                        break;
                    case 2:
                        currentText += "2";
                        break;
                    case 3:
                        currentText += "3";
                        break;
                    case 4:
                        currentText += "4";
                        break;
                    case 5:
                        currentText += "5";
                        break;
                    case 6:
                        currentText += "6";
                        break;
                    case 7:
                        currentText += "7";
                        break;
                    case 8:
                        currentText += "8";
                        break;
                    case 9:
                        currentText += "9";
                        break;
                }
                textblock.setText(currentText);
            }
        };
//        btn0.setTag(0);
//        btn0.setOnClickListener(listener);
//        btn1.setTag(1);
//        btn1.setOnClickListener(listener);
//        btn2.setTag(2);
//        btn2.setOnClickListener(listener);
//        btn3.setTag(3);
//        btn3.setOnClickListener(listener);
//        btn4.setTag(4);
//        btn4.setOnClickListener(listener);
//        btn5.setTag(5);
//        btn5.setOnClickListener(listener);
//        btn6.setTag(6);
//        btn6.setOnClickListener(listener);
//        btn7.setTag(7);
//        btn7.setOnClickListener(listener);
//        btn8.setTag(8);
//        btn8.setOnClickListener(listener);
//        btn9.setTag(9);
//        btn9.setOnClickListener(listener);
//
//        btnplus.setTag(11);
//        btnplus.setOnClickListener(listener);
//        btnminus.setTag(22);
//        btnminus.setOnClickListener(listener);
//        btntime.setTag(33);
//        btntime.setOnClickListener(listener);
//        btndiv.setTag(44);
//        btndiv.setOnClickListener(listener);
//
//        btnclear.setTag(55);
//        btnclear.setOnClickListener(listener);
//        btnbackspace.setTag(66);
//        btnbackspace.setOnClickListener(listener);
//
//        btnpoint.setTag(77);
//        btnpoint.setOnClickListener(listener);
//        btnpercent.setTag(88);
//        btnpercent.setOnClickListener(listener);
//        btnequal.setTag(99);
//        btnequal.setOnClickListener(listener);
    }
//    @Override
//    public void onConfigurationChanged(Configuration config)
//    {
//        int mCurrentOrientation = getResources().getConfiguration().orientation;
//        if(mCurrentOrientation == Configuration.ORIENTATION_PORTRAIT)
//        {
//            Intent i = getIntent();
//            setContentView(R.layout.activity_main);
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        }else
//        {
//            Intent i = new Intent(MainActivity.this,MainActivity2.class);
//            setContentView(R.layout.activity_main);
//            startActivity(i);
//        }
//    }
    public void setData(int tag)
    {
        check_function = tag;
    }
    public String run(String infix) {
        String suffix = toSuffix(infix);
        String result = calculate(suffix);
        return calculate(suffix);
    }
    private static final Map<Character,Integer> PRIORITY_MAP = new HashMap<>();
    private static final String OPERATOR = "*/+-()";
    static{
        PRIORITY_MAP.put('-', 1);
        PRIORITY_MAP.put('+', 1);
        PRIORITY_MAP.put('*', 2);
        PRIORITY_MAP.put('/', 2);
        PRIORITY_MAP.put('(', 0);
    }
    // 中缀表达式转换成后缀表达式
    private String toSuffix(String infix){
        List<String> suffix = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // 用于记录字符长度  例如100*2,则记录的len为3 到时候截取字符串的前三位就是数字
        int len = 0;
        for(int i = 0; i < infix.length(); i++){
            char ch = infix.charAt(i);

            // 数字
            if (Character.isDigit(ch) || ch == '.') {
                len++;
            } else if (OPERATOR.indexOf(ch) != -1) {
                // 符号之前的可以截取下来做数字
                if (len > 0) {
                    suffix.add(infix.substring(i-len, i));
                    len = 0;
                }
                // 将左括号放入栈中
                if (ch == '(') {
                    stack.push(ch);
                    continue;
                }
                if (!stack.isEmpty()) {
                    int size = stack.size() - 1;
                    boolean flag = false;

                    // 若当前ch为右括号，则栈里元素从栈顶一直弹出，直到弹出到左括号
                    while(size >= 0 && ch == ')' && stack.peek() != '('){
                        suffix.add(String.valueOf(stack.pop()));
                        size--;
                        flag = true;
                    }

                    // 若取得不是（）内的元素，并且当前栈顶元素的优先级>=对比元素 那就出栈插入队列
                    while(size >= 0 && !flag && PRIORITY_MAP.get(stack.peek()) >= PRIORITY_MAP.get(ch)){
                        suffix.add(String.valueOf(stack.pop()));
                        size--;
                    }
                }

                if (ch != ')') {
                    stack.push(ch);
                }else {
                    stack.pop();
                }
            }
            // 如果已经走到了中缀表达式的最后一位
            if (i == infix.length() - 1) {
                if (len > 0) {
                    suffix.add(infix.substring(i - len + 1, i + 1));
                }

                int size = stack.size() - 1;
                // 一直将栈内 符号全部出栈并且加入队列中
                while(size >= 0) {
                    suffix.add(String.valueOf(stack.pop()));
                    size--;
                }
            }
        }
        return suffix.toString().substring(1, suffix.toString().length()-1);
    }
    // 根据后缀表达式计算结果
    private String calculate(String suffix){
        String [] arr = suffix.split(",");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i].trim()) {
                case "+":
                    double a = Double.parseDouble(stack.pop()) + Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(a));
                    break;
                case "-":
                    double b = Double.parseDouble(stack.pop()) - Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(-b));
                    break;
                case "*":
                    double c = Double.parseDouble(stack.pop()) * Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(c));
                    break;
                case "/":
                    double first = Double.parseDouble(stack.pop());
                    double d = Double.parseDouble(stack.pop()) / first;
                    stack.push(String.valueOf(d));
                    break;
                default:
                    stack.push(arr[i].trim());
                    break;
            }
        }
        if(stack.size() == 1)
        {
            return stack.pop();
        }
        else
        {
            Toast.makeText(this,"Input Error",Toast.LENGTH_SHORT).show();
            return "";
        }
    }
}