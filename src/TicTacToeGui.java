import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGui extends JFrame {
    private Container panel;
    private String currentPlayer;
    private JButton [] [] board;
    private boolean hasWinner;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private JMenuItem newGame;

    public TicTacToeGui () {
        //calls jframe
        super();
        panel = getContentPane();
        panel.setLayout(new GridLayout(3,3));
        setTitle("Tic Tac Toe");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        currentPlayer = "x";
        board = new JButton[3][3];
        hasWinner = false;
        intializeBoard();
        intializeMenuBar();
    }
    private void intializeMenuBar() {
      JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetBoard();
            }
        });
        JMenuItem quit = new JMenuItem("Rage Quit (Reset)");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuBar.add(file);
        file.add(quit);
        file.add(newGame);
        setJMenuBar(menuBar);


    }
    private void resetBoard() {
        currentPlayer = "x";
        hasWinner = false;
        //sets all columns and rows to empty string to clear board.
        for(int i = 0; i<3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j].setText("");
            }
        }
    }
    private void intializeBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                JButton btn = new JButton();
                btn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,100));
                board[i][j] = btn;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //returns who clicked the button and casts it into jbutton
                        if(((JButton)e.getSource()).getText().equals("") &&
                                !hasWinner) {
                            btn.setText(currentPlayer);
                            hasWinner();
                            togglePlayer();
                        }
                    }
                });
                panel.add(btn);
            }
        }
    }
    //to switch from play x and o's turns
    private void togglePlayer() {
        if(currentPlayer.equals("x")) {
            currentPlayer = "o";


        }
        else
            currentPlayer = "x";
    }
    private void hasWinner() {

            if(board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
                hasWinner = true;
            }
            else if(board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)) {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
                hasWinner = true;
            }
            else if(board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
                hasWinner = true;
            }
            else if(board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
                hasWinner = true;
            }
            else if(board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
                hasWinner = true;
            }
            else if(board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)) {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
                hasWinner = true;
            }
            else if(board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)) {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
                hasWinner = true;
            }
            else if(board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
                hasWinner = true;
            }
    }
}

