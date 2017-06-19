/**
 * Created by young on 6/18/17.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

public class GuessNum {

    // main frame
    JFrame frame;
    // the panel containing drop-down menus
    JPanel numbers;
    // drop-down menus
    JComboBox tenThousands;
    JComboBox thousands;
    JComboBox hundreds;
    JComboBox tens;
    JComboBox ones;
    // indicator status
    JTextField status;
    // random number from 00000 to 99999
    Random randomizer;
    int randomNum;
    // button that resets the game
    JButton reset;

    public GuessNum() {
        this.randomizer = new Random();
        this.randomNum = this.randomizer.nextInt(100000);
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        this.frame = new JFrame("Guess the Number!");
        this.frame.setLayout(new BorderLayout());

        this.numbers = new JPanel(new GridBagLayout());

        this.tenThousands = new JComboBox(numbers);
        this.tenThousands.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                compareGuess(tenThousands.getSelectedIndex(), thousands.getSelectedIndex(), hundreds.getSelectedIndex()
                            ,tens.getSelectedIndex(), ones.getSelectedIndex());
            }
        });
        this.thousands = new JComboBox(numbers);
        this.thousands.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                compareGuess(tenThousands.getSelectedIndex(), thousands.getSelectedIndex(), hundreds.getSelectedIndex()
                            ,tens.getSelectedIndex(), ones.getSelectedIndex());
            }
        });
        this.hundreds = new JComboBox(numbers);
        this.hundreds.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                compareGuess(tenThousands.getSelectedIndex(), thousands.getSelectedIndex(), hundreds.getSelectedIndex()
                            ,tens.getSelectedIndex(), ones.getSelectedIndex());
            }
        });
        this.tens = new JComboBox(numbers);
        this.tens.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                compareGuess(tenThousands.getSelectedIndex(), thousands.getSelectedIndex(), hundreds.getSelectedIndex()
                            ,tens.getSelectedIndex(), ones.getSelectedIndex());
            }
        });
        this.ones = new JComboBox(numbers);
        this.ones.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                compareGuess(tenThousands.getSelectedIndex(), thousands.getSelectedIndex(), hundreds.getSelectedIndex()
                            ,tens.getSelectedIndex(), ones.getSelectedIndex());
            }
        });

        this.numbers.add(this.tenThousands);
        this.numbers.add(this.thousands);
        this.numbers.add(this.hundreds);
        this.numbers.add(this.tens);
        this.numbers.add(this.ones);

        this.status = new JTextField("Welcome to the Game!");
        this.status.setOpaque(true);

        this.reset = new JButton("Reset the Game!");
        this.reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GuessNum g = new GuessNum();
            }
        });
        this.reset.setVisible(false);

        this.frame.add(this.numbers, BorderLayout.NORTH);
        this.frame.add(this.status, BorderLayout.SOUTH);
        this.frame.add(this.reset, BorderLayout.CENTER);
        this.frame.pack();
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    private void compareGuess(int tenThousands, int thousands, int hundreds, int tens, int ones) {
        // modify numbers to match the place
        int newTenThousands = tenThousands * 10000;
        int newThousands = thousands * 1000;
        int newHundreds = hundreds * 100;
        int newTens = tens * 10;
        // the guess number
        int guess = newTenThousands + newThousands + newHundreds + newTens + ones;
        // comparing the guess to actual number
        if (guess > this.randomNum) {
            this.status.setText("Your guess is GREATER than the actual number.");
        }
        else if (guess < this.randomNum) {
            this.status.setText("Your guess is LESS than the actual number.");
        }
        else if (guess == this.randomNum) {
            // FIX RESET BUTTON
            this.status.setText("Your guess MATCHES the actual number!");
            this.reset.setVisible(true);
        }
    }

    public static void main(String[] args) {
        GuessNum g = new GuessNum();
    }

}
