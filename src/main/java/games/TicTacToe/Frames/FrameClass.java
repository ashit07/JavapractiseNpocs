package games.TicTacToe.Frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class FrameClass extends JFrame implements ActionListener {
  /**
  	 * 
  	 */
  private static final long serialVersionUID = 1L;
  JLabel jf = null;
  JButton[][] inputBoxes = new JButton[3][3];
  JTabbedPane welcome = null;
  JTabbedPane horizontal1 = null;
  JTabbedPane horizontal2 = null;
  JTabbedPane vertical1 = null;
  JTabbedPane vertical2 = null;
  JButton dummyForTest = null;
  ArrayList<JButton> buttonlist = new ArrayList<JButton>();
  Boolean playerFinished = false;
  Integer noOfTurns = 0;

  FrameClass() {
    declareVars();
    doSetbounds();
    setLayout(null);
    addItems();
    addActionListeners();
  }

  public void declareVars() {
    jf = new JLabel("Welcome to TicTacToe");
    System.out.println(inputBoxes.length);
    for (int i = 0; i < inputBoxes.length; i++) {
      for (int j = 0; j < inputBoxes.length; j++) {
        inputBoxes[i][j] = new JButton();
        buttonlist.add(inputBoxes[i][j]);
      }
    }
    dummyForTest = new JButton();
    welcome = new JTabbedPane();
    horizontal1 = new JTabbedPane();
    horizontal2 = new JTabbedPane();
    vertical1 = new JTabbedPane();
    vertical2 = new JTabbedPane();
  }

  public void doSetbounds() {
    jf.setBounds(200, 10, 200, 20);
    welcome.setBounds(0, 30, 600, 10);
    horizontal1.setBounds(0, 200, 600, 10);
    horizontal2.setBounds(0, 400, 600, 10);
    vertical1.setBounds(200, 30, 10, 600);
    vertical2.setBounds(400, 30, 10, 600);
    inputBoxes[0][0].setBounds(0, 40, 200, 160);
    // dummyForTest.setBounds(0, 40, 200, 160);
    inputBoxes[0][1].setBounds(210, 40, 190, 160);
    inputBoxes[0][2].setBounds(0, 410, 200, 160);
    inputBoxes[1][0].setBounds(0, 210, 200, 190);
    inputBoxes[1][1].setBounds(210, 210, 190, 190);
    inputBoxes[1][2].setBounds(210, 410, 190, 160);
    inputBoxes[2][0].setBounds(410, 40, 190, 160);
    inputBoxes[2][1].setBounds(410, 210, 190, 190);
    inputBoxes[2][2].setBounds(410, 410, 190, 160);
  }

  public void addItems() {
    add(jf);
    add(welcome);
    add(horizontal1);
    add(horizontal2);
    add(vertical1);
    add(vertical2);
    // add(dummyForTest);
    for (int i = 0; i < inputBoxes.length; i++) {
      for (int j = 0; j < inputBoxes.length; j++) {
        add(inputBoxes[i][j]);
      }
    }
  }

  public void addActionListeners() {
    for (int i = 0; i < inputBoxes.length; i++) {
      for (int j = 0; j < inputBoxes.length; j++) {
        inputBoxes[i][j].addActionListener(this);
      }
    }
    // System.out.println("Action Listeners Added");
  }

  public static void main(String[] args) {
    FrameClass fc = new FrameClass();
    fc.setSize(600, 600);
    fc.setVisible(true);
    fc.setLocation(300, 100);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    // System.out.println("Reaches here");
    JButton b = new JButton();
    if (e.getSource() instanceof JButton) {
      b = (JButton) e.getSource();
    }
    if ((b.getText()).equals("")) {
      b.setText("1");
      buttonlist.remove(b);
      playerFinished = true;
      noOfTurns++;
      // System.out.println("No of turns is "+noOfTurns);
      if (noOfTurns >= 3) {
        verifyWinner();
      }
    }
    if (playerFinished) {
      computerTurn(buttonlist);
      playerFinished = false;
    } else {

    }
  }

  private void computerTurn(ArrayList<JButton> arr) {
    Integer noOfCompTurns = 0;
    if (!arr.isEmpty()) {
      int len = arr.size();
      // System.out.println("In comp length is "+len);
      // System.out.println("In comp array is "+arr);
      int randomNumber = (int) ((len) * Math.random());
      JButton b = arr.get(randomNumber);
      if (b.getText().equals("")) {
        b.setText("0");
        buttonlist.remove(b);
        noOfCompTurns++;
      } else {
        computerTurn(arr);
      }
    }
  }

  private boolean verifyWinner() {
    int sum1 = -1;
    for (int i = 0; i < 3; i++) {
      int initialSum = 0;
      for (int j = 0; j < 3; j++) {
        initialSum = checksum(i, j, initialSum);
      }
      sum1 = initialSum - 1;
      System.out.println("For i= " + i + " Sum1 is " + sum1);
      if (sum1 == 2) {
        playerWins();
      } else if (sum1 == -1) {
        compWins();
      }
      sum1 = -1;
    }
    return false;
  }

  public int checksum(int i, int j, int sum) {
    if (!inputBoxes[i][j].getText().equals("")) {
      // System.out.println("inputBoxes["+i+"]["+j+"].getText() is " +inputBoxes[i][j].getText());
      sum = sum + (Integer.parseInt(inputBoxes[i][j].getText()));
      // System.out.println("sum is "+sum);
      return sum;
    } else {
      return -10;
    }
  }

  public void playerWins() {
    System.out.println("Player Wins");
    System.exit(0);
  }

  public void compWins() {
    System.out.println("Computer Wins");
    System.exit(0);
  }
}
