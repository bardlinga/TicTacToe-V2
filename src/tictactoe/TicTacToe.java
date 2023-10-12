package tictactoe;

import javax.swing.*;

class Game {

    private final String[] cells = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};

    private void updateCells(int chosenCell, String playerSymbol){
        cells[chosenCell] = playerSymbol;
    }

    private String board(){
        return "     |     |     \n"+
                "  "+cells[0]+"  |  "+cells[1]+"  |  "+cells[2]+"  \n"+
                "-----|-----|-----\n"+
                "  "+cells[3]+"  |  "+cells[4]+"  |  "+cells[5]+"  \n"+
                "-----|-----|-----\n"+
                "  "+cells[6]+"  |  "+cells[7]+"  |  "+cells[8]+"  \n"+
                "     |     |     \n";
    }

    private Boolean filledCellsAreEqual(int cellA, int cellB, int cellC){
        return !cells[cellA].equals(" ")
                && cells[cellA].equals(cells[cellB])
                && cells[cellA].equals(cells[cellC]);
    }

    private Boolean checkWinCondition(){
        return filledCellsAreEqual(0, 1, 2)
                || filledCellsAreEqual(3, 4, 5)
                || filledCellsAreEqual(6, 7, 8)
                || filledCellsAreEqual(0, 3, 6)
                || filledCellsAreEqual(1, 4, 7)
                || filledCellsAreEqual(2, 5, 8)
                || filledCellsAreEqual(1, 4, 8)
                || filledCellsAreEqual(2, 4, 6);
    }

    private void printBoard(){
        System.out.println(board());
    }

    public void runGame(){

        printBoard();

        String player1Symbol = JOptionPane.showInputDialog("Player 1, choose a symbol");
        String player2Symbol = JOptionPane.showInputDialog("Player 2, choose a symbol");

        int chosenCell;
        String playerSymbol = "init-temporary";

        int i = 0;

        while(!checkWinCondition() && i < 9) {
            if(i % 2 == 0){
                playerSymbol = player1Symbol;
            } else{
                playerSymbol = player2Symbol;
            }
            chosenCell = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Player "+playerSymbol+", choose a space (1-9)"))-1;
            updateCells(chosenCell, playerSymbol);
            printBoard();
            i++;
        }
        JOptionPane.showMessageDialog(
                null,"The game is over! Player "+playerSymbol+" won!");
    }
}

public class TicTacToe {

    public static void main(String[] args){
        Game newGame = new Game();
        newGame.runGame();
    }
}

