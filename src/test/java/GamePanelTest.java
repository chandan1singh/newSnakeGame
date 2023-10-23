
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

public class GamePanelTest {

    GamePanel gp = new GamePanel(1000, 1000);

    @Test
    public void mainTesting() {
        Main.chooseCustomSize(25, 1200, 800);
        Main.chooseScreenSize(Main.loadProperties("Main.properties"));
    }

    @Test
    public void assignVariablestest() {
        gp.assignVariables();
        assertEquals(25, gp.percent);
        assertEquals(75, gp.percent2);
        assertEquals(3, gp.lengthOfSnake);
        assertEquals(0, gp.moves);
        assertEquals(0, gp.score);
        assertEquals(150, gp.delay);
        assertEquals(24, gp.OriginX);
        assertEquals(10, gp.OriginY);
        assertEquals(74, gp.OriginY2);
        assertEquals(55, gp.Rheight);
        assertEquals(18, gp.font1);
        assertEquals(14, gp.font2);
        assertEquals(30, gp.height2);
        assertEquals(50, gp.height3);
        assertEquals(100, gp.w1);
        assertEquals(40, gp.h1);
        assertEquals(100, gp.Sx0);
        assertEquals(75, gp.Sx1);
        assertEquals(50, gp.Sx2);
        assertEquals(100, gp.Sy0);
    }

    @Test
    public void testEnemy() {
        gp.newEnemy();
        gp.resetGame();
    }

    int[] xPos = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525,
            550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 850 };
    int[] yPos = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550,
            575, 600, 625 };

    @Test
    public void saveData() throws Exception {
        int[] snakeX = { 25, 50, 75 };
        int[] snakeY = { 75, 100, 125 };
        int enemyX = 75;
        int enemyY = 125;
        int moves = 12;
        int score = 47;
        int lengthOfSnake = 10;
        boolean left = false;
        boolean right = true;
        boolean up = false;
        boolean down = false;
        gp.saveData(snakeX, snakeY, enemyX, enemyY, moves, score, lengthOfSnake, left, right, up, down);
    }

    @Test
    public void getingData() throws Exception {
        gp.getData();
    }

    // @Test
    // public void deletingData() throws Exception {
    // gp.deleteData();
    // }

    @Test
    public void collidesWithBodyTest() {
        gp.collidesWithBody();

    }

    @Test
    public void collidesWithEnemyTest() {
        gp.collidesWithEnemy();
    }

    private ArrayList<GameState> gameStates = new ArrayList<>();

    @Test
    public void addToArray() {
        int[] snakexlength = { 25, 50, 75, 100 };
        int[] snakeylength = { 50, 75, 100, 125 };
        int enemyX = 25;
        int enemyY = 50;
        int moves = 4;
        int score = 1;
        int lengthOfSnake = 4;
        boolean left = false;
        boolean right = true;
        boolean up = false;
        boolean down = false;
        gameStates.add(new GameState(snakexlength.clone(), snakeylength.clone(), enemyX, enemyY, moves, score,
                lengthOfSnake, left, right, up, down));
    }

    @Test
    public void newEnemyTest() {
        gp.newEnemy();
    }
}

// import java.util.ArrayList;
//
// import org.junit.Test;
//
/// **
// * Project Name : sonarqube-example
// * Developer : Chandan Singh
// * Version : 1.0.0
// * Date : Oct/1/2023
// * Time : 8:59 AM
// * Description :
// **/
//
// public class GamePanelTest {
//
// int[] xPos = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325,
// 350, 375, 400, 425, 450, 475, 500, 525,
// 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 850 };
// int[] yPos = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350,
// 375, 400, 425, 450, 475, 500, 525, 550,
// 575, 600, 625 };
//
// GamePanel gp = new GamePanel(1000,1000);
//
// @Test
// public void SaveData() throws Exception {
// int[] snakeX = { 25, 50, 75 };
// int[] snakeY = { 75, 100, 125 };
// int enemyX = 75;
// int enemyY = 125;
// int moves = 12;
// int score = 47;
// int lengthOfSnake = 10;
// boolean left = false;
// boolean right = true;
// boolean up = false;
// boolean down = false;
// gp.saveData(snakeX, snakeY, enemyX, enemyY, moves, score, lengthOfSnake,
// left, right, up, down);
//
// }
//
// @Test
// public void getingData() throws Exception {
// gp.getData();
// }
//
// @Test
// public void collidesWithBodyTest() {
//// int[] snakexlength = {
//// 50, 75, 100, 50, 150
//// };
//// int[] snakeylength = {
//// 50, 75, 100, 50, 150
//// };
// gp.collidesWithBody();
//
// }
//
// @Test
// public void collidesWithEnemyTest() {
// // GamePanelMethods gp = new GamePanelMethods();
//// int[] snakexlength = {
//// 50, 75, 100, 50, 150
//// };
//// int[] snakeylength = {
//// 50, 75, 100, 50, 150
//// };
// gp.collidesWithEnemy();
// }
//
// private ArrayList<GameState> gameStates = new ArrayList<>();
//
// @Test
// public void addToArray() {
// int[] snakexlength = { 25, 50, 75, 100 };
// int[] snakeylength = { 50, 75, 100, 125 };
// int enemyX = 25;
// int enemyY = 50;
// int moves = 4;
// int score = 1;
// int lengthOfSnake = 4;
// boolean left = false;
// boolean right = true;
// boolean up = false;
// boolean down = false;
// gameStates.add(new GameState(snakexlength.clone(), snakeylength.clone(),
// enemyX, enemyY, moves, score,
// lengthOfSnake, left, right, up, down));
// }
//
//// @Test
//// public void TestAddtoArrayList() {
//// //GamePanelMethods gp = new GamePanelMethods();
//// gp.GameStateAddToArrayList();
//// }
//
//// @Test
//// public void TestPassword() {
//// password passwordManager = new password();
//// String password = passwordManager.getPassword();
//// assertEquals("chandan1singh",password);
//// }
////
//// @Test
//// public void TestConnection() throws Exception {
//// GamePanelMethods gp = new GamePanelMethods();
//// gp.Con();
//// }
//
// @Test
// public void newEnemyTest() {
// gp.newEnemy();
// }
//
// @Test
// public void RESetGame() {
// gp.resetGame();
// gp.restart();
// }
//
// }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
