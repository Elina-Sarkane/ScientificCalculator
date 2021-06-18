import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

   JFrame frame;
   JTextField textField;
   //izveido skaitļu pogas
    //create ArrayList for number buttons
   JButton[] numberButtons = new JButton[10];
   //izveido funkciju pogas
    //create Arraylist for function buttons
   JButton[] functionButtons = new JButton[26];

   JButton additionButton, subtractionButton, multiplicationButton, divisionButton,
           decimalButton, equalsButton, deleteButton, clearButton, negativeButton,
           leftBracketButton, rightBracketButton, factorialButton, lnButton, logButton,
           squareOfTenButton, squareOfXAndYButton, squareRootButton, squareOfTwoButton,
           oneDividedByButton, absoluteValueButton, expButton, modButton, piButton, eButton, secondButton;

   JPanel panel;

   Font numberFont = new Font("Times New Roman", Font.BOLD,30);
   Font functionFont = new Font("Times New Roman", Font.PLAIN,20);

   double num1 = 0, num2 = 0, result = 0;
   char operator;
   String operator1;

   Calculator(){

       //kalkulatora rāmis
       //calculator frame
       frame = new JFrame("Scientific calculator");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(455, 655);
       frame.setLayout(null);
       frame.setResizable(false);
       ImageIcon calculator = new ImageIcon("calculator.png");
       frame.setIconImage(calculator.getImage());

       //textField rādīs skaitļus un rezultātu = kā menu bar
       //textField = will show all numbers and results, when clicking on them
       textField = new JTextField();
       textField.setBounds(50, 25, 335, 50);
       textField.setFont(numberFont);
       textField.setEditable(false);
       textField.setBorder(BorderFactory.createBevelBorder(0));
       textField.setBackground(new Color(255, 255, 255));
       
       //izveido visu pogu nosaukumus
       //create all button titles

       //pirmā rinda
       //first row
       secondButton = new JButton("2nd");
       piButton = new JButton("π");
       eButton = new JButton("e");
       clearButton = new JButton("C");
       deleteButton = new JButton("Del");

       //otrā rinda
       //second row
       squareOfTwoButton = new JButton("x2");
       oneDividedByButton = new JButton("1/x");
       absoluteValueButton = new JButton("|x|");
       expButton = new JButton("exp");
       modButton = new JButton("mod");

       //trešā rinda
       //third row
       squareRootButton = new JButton("2√x" );
       leftBracketButton = new JButton("(");
       rightBracketButton = new JButton(")");
       factorialButton = new JButton("n!");
       divisionButton = new JButton("/");

       //ceturtā rinda
       //fourth row
       squareOfXAndYButton = new JButton("xy");
       multiplicationButton = new JButton("*");

       //piektā rinda
       //fifth row
       squareOfTenButton = new JButton("10x");
       subtractionButton = new JButton("-");

       //sestā rinda
       //sixth row
       logButton = new JButton("log");
       additionButton = new JButton("+");

       //septītā rinda
       //sevenths row
       lnButton = new JButton("ln");
       negativeButton = new JButton("(-)");
       decimalButton = new JButton(".");
       equalsButton = new JButton("=");

       //nosaka functionButton indeksus
       //create functionButton indexes
       functionButtons[0] = secondButton;
       functionButtons[1] = piButton;
       functionButtons[2] = eButton;
       functionButtons[3] = clearButton;
       functionButtons[4] = deleteButton;

       functionButtons[5] = squareOfTwoButton;
       functionButtons[6] = oneDividedByButton;
       functionButtons[7] = absoluteValueButton;
       functionButtons[8] = expButton;
       functionButtons[9] = modButton;

       functionButtons[10] = squareRootButton;
       functionButtons[11] = leftBracketButton;
       functionButtons[12] = rightBracketButton;
       functionButtons[13] = factorialButton;
       functionButtons[14] = divisionButton;

       functionButtons[15] = squareOfXAndYButton;
       functionButtons[16] = multiplicationButton;

       functionButtons[17] = squareOfTenButton;
       functionButtons[18] = subtractionButton;

       functionButtons[19] = logButton;
       functionButtons[20] = additionButton;

       functionButtons[21] = lnButton;
       functionButtons[22] = negativeButton;
       functionButtons[23] = subtractionButton;
       functionButtons[24] = decimalButton;
       functionButtons[25] = equalsButton;

       //cilpa priekš funkciju pogām = 26 reizes
       //loop for functionButtons = 26 times
       for (int i = 0; i<26; i++){
           functionButtons[i].addActionListener(this);
           functionButtons[i].setFont(functionFont);
           functionButtons[i].setFocusable(false);
           functionButtons[i].setBackground(new Color(220,220, 220));
           functionButtons[i].setBorder(BorderFactory.createBevelBorder(0));
       }

       //cilpa priekš ciparu pogām = 10 reizes
       //loop for numberButtons = 10 times
       for (int i = 0; i<10; i++){
           numberButtons[i] = new JButton(String.valueOf(i));
           numberButtons[i].addActionListener(this);
           numberButtons[i].setFont(numberFont);
           numberButtons[i].setFocusable(false);
           numberButtons[i].setBackground(new Color(180, 180, 180));
           numberButtons[i].setBorder(BorderFactory.createBevelBorder(0));
       }

       //izveido paneļa rāmi, kurš saturēs functionButton un numberButton
       //create panel frame, which contains functionButton and numberButton
       panel = new JPanel();
       panel.setBounds(0, 100, 440, 520);
       panel.setLayout(new GridLayout(7, 5, 10, 10));
       //panel.setBackground(Color.red);

       //deklarē pogas, kur kura atrodas pēc kārtas paneļa rāmī
       //put all buttons in the right places
       panel.add(secondButton);
       panel.add(piButton);
       panel.add(eButton);
       panel.add(clearButton);
       panel.add(deleteButton);

       panel.add(squareOfTwoButton);
       panel.add(oneDividedByButton);
       panel.add(absoluteValueButton);
       panel.add(expButton);
       panel.add(modButton);

       panel.add(squareRootButton);
       panel.add(leftBracketButton);
       panel.add(rightBracketButton);
       panel.add(factorialButton);
       panel.add(divisionButton);

       panel.add(squareOfXAndYButton);
       panel.add(numberButtons[7]);
       panel.add(numberButtons[8]);
       panel.add(numberButtons[9]);
       panel.add(multiplicationButton);

       panel.add(squareOfTenButton);
       panel.add(numberButtons[4]);
       panel.add(numberButtons[5]);
       panel.add(numberButtons[6]);
       panel.add(subtractionButton);

       panel.add(logButton);
       panel.add(numberButtons[1]);
       panel.add(numberButtons[2]);
       panel.add(numberButtons[3]);
       panel.add(additionButton);

       panel.add(lnButton);
       panel.add(negativeButton);
       panel.add(numberButtons[0]);
       panel.add(decimalButton);
       panel.add(equalsButton);

       frame.add(panel);
       frame.add(textField);
       frame.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<10; i++){
            //izveido opciju, kad uzspiež uz cipara, tas parādās textField lokācijā
            if (e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimalButton){
            textField.setText(textField.getText().concat("."));
            textField.setVisible(true);
        }
        if (e.getSource() == additionButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subtractionButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == multiplicationButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divisionButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == leftBracketButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '(';
            textField.setText("");
        }
        if (e.getSource() == rightBracketButton){
            num1 = Double.parseDouble(textField.getText());
            operator = ')';
            textField.setText("");
        }
        if (e.getSource() == factorialButton){
            num1 = Double.parseDouble(textField.getText());
            operator1 = "n!";
            textField.setText("");
        }
        if (e.getSource() == lnButton){
            num1 = Double.parseDouble(textField.getText());
            operator1 = "ln";
            textField.setText("");
        }
        if (e.getSource() == logButton){
            num1 = Double.parseDouble(textField.getText());
            operator1 = "log";
            textField.setText("");
        }
        if (e.getSource() == squareOfTenButton){
            num1 = Double.parseDouble(textField.getText());
            operator1 = "10x";
            textField.setText("");
        }
        if (e.getSource() == squareOfXAndYButton){
            num1 = Double.parseDouble(textField.getText());
            operator1 = "xy";
            textField.setText("");
        }
        if (e.getSource() == squareRootButton){
            num1 = Double.parseDouble(textField.getText());
            operator1 = "2√x";
            textField.setText("");
        }
        if (e.getSource() == squareOfTwoButton){
            num1 = Double.parseDouble(textField.getText());
            operator1 = "x2";
            textField.setText("");
        }
        if (e.getSource() == oneDividedByButton){
            num1 = Double.parseDouble(textField.getText());
            operator1 = "1/x";
            textField.setText("");
        }
        if (e.getSource() == absoluteValueButton){
            num1 = Double.parseDouble(textField.getText());
            operator1 = "|x|";
            textField.setText("");
        }
        if (e.getSource() == expButton){
            num1 = Double.parseDouble(textField.getText());
            operator1 = "exp";
            textField.setText("");
        }
        if (e.getSource() == modButton){
            num1 = Double.parseDouble(textField.getText());
            operator1 = "mod";
            textField.setText("");
        }
        if (e.getSource() == piButton){
            num1 = Double.parseDouble(textField.getText());
            operator1 = "π";
            textField.setText("");
        }
        if (e.getSource() == eButton){
            num1 = Double.parseDouble(textField.getText());
            operator1 = "e";
            textField.setText("");
        }
        if (e.getSource() == secondButton){
            num1 = Double.parseDouble(textField.getText());
            operator1 = "2nd";
            textField.setText("");
        }


        //showing the results

        //works
        if (e.getSource()==equalsButton){
            num2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }
        if (e.getSource() == squareRootButton){
            result = Math.sqrt(num1);
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == squareOfTwoButton){
            result = num1*num1;
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == oneDividedByButton){
            result = 1/num1;
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == absoluteValueButton){
            if(num1 <= 0){
                result = -num1;
            }else {
                result = num1;
            }
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == clearButton){
            textField.setText("");
        }
        if (e.getSource() == deleteButton){
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i<string.length()-1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if (e.getSource() == negativeButton){
            double temporarily = Double.parseDouble(textField.getText());
            temporarily*=-1;
            textField.setText(String.valueOf(temporarily));
        }

        //doesn't work
        if (e.getSource() == leftBracketButton){

            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == rightBracketButton){

            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == factorialButton){

            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == lnButton){

            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == logButton){
            result = Math.log(num1);
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == squareOfTenButton){

            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == squareOfXAndYButton){
            // result = Math.pow(num1, num2);
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == expButton){

            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == modButton){

            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == piButton){
            //piButton = 3.14159;
            //result = num1 * piButton;
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == eButton){

            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == secondButton){
            //its like a shift button
            textField.setText(String.valueOf(result));
        }
    }
}
