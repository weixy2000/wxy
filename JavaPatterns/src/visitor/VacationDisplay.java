package visitor;

import java.awt.*;
import java.awt.event.*;

//swing classes
import javax.swing.*;

/**
 * 访问者模式(Visitor)：访问者模式的目的是封装一些施加于某种数据结构元素之上的操作。一旦这些操作需要修改的话，接受这个操作的数据结构可以保持不变。
 * 		访问者模式适用于数据结构相对未定的系统，它把数据结构和作用于结构上的操作之间的耦合解脱开，使得操作集合可以相对自由的演化。
 * 		访问者模式使得增加新的操作变的很容易，就是增加一个新的访问者类。访问者模式将有关的行为集中到一个访问者对象中，而不是分散到一个个的节点类中。
 * 		当使用访问者模式时，要将尽可能多的对象浏览逻辑放在访问者类中，而不是放到它的子类中。
 * 		访问者模式可以跨过几个类的等级结构访问属于不同的等级结构的成员类。
 */
public class VacationDisplay extends JxFrame
   implements ActionListener
{
   JawtList empList;
   JTextField total, btotal;
   JButton Vac;
   Employee[] employees;
//-----------------------------------------
  public VacationDisplay()
  {
     super("Vacation Display");
     JPanel jp = new JPanel();
     getContentPane().add(jp);
     jp.setLayout(new GridLayout(1,2));
     empList = new JawtList(10);
     jp.add(empList);
          
     createEmployees();
     
     Box box = Box.createVerticalBox();
     jp.add(box);
     total = new JTextField(5);
     total.setHorizontalAlignment(JTextField.CENTER);
     box.add(total);
     box.add(Box.createVerticalStrut(10));
     btotal = new JTextField(5);
     btotal.setHorizontalAlignment(JTextField.CENTER);
     box.add(btotal);
     box.add(Box.createVerticalStrut(10));
     Vac = new JButton("Vacations");
     box.add(Vac);
     Vac.addActionListener(this);
     setSize(300,200); 
     setVisible(true); 
     total.setText("  ");
     total.setBackground(Color.white);

  }
  //-----------------------------------------
  public void createEmployees()
  {
     employees = new Employee[7];
     int i = 0;
     employees[i++] =new Employee("Susan Bear",  55000, 12, 1);
     employees[i++] = new Employee("Adam Gehr",  150000, 9, 0);
     employees[i++] = new Employee("Fred Harris",  50000, 15, 2);
     employees[i++] = new Employee("David Oakley",  57000, 12, 2);
     employees[i++] = new Employee("Larry Thomas",  100000, 20, 6);
     Boss b = new Boss("Leslie Susi", 175000, 16,4);
     b.setBonusDays(12);
     Boss b1 = new Boss("Laurence Byerly", 35000, 17,6);
     b1.setBonusDays(17);
     employees[i++] = b;
     employees[i++] = b1;

     for ( i = 0; i < employees.length; i++)
     {
      empList.add(employees[i].getName());
     }
  }
 //----------------------------------------- 
  public void actionPerformed(ActionEvent e)
  {
    VacationVisitor vac = new VacationVisitor();
    BVacationVisitor bvac = new BVacationVisitor();
     for (int i = 0; i < employees.length; i++)
     {
      employees[i].accept(vac);
      employees[i].accept(bvac);
     }
     total.setText(new Integer(vac.getTotalDays()).toString());
     btotal.setText(new Integer(bvac.getTotalDays()).toString());
  }
  //-----------------------------------------
  static public void main(String argv[])
  {
     new VacationDisplay();
  }
}
