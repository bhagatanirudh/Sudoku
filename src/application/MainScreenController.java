package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import java.util.HashSet;
import java.util.Set;
import javafx.event.ActionEvent;

public class MainScreenController {
	@FXML
	private TextField t1;
	@FXML
	private TextField t2;
	@FXML
	private TextField t3;
	@FXML
	private TextField t10;
	@FXML
	private TextField t11;
	@FXML
	private TextField t12;
	@FXML
	private TextField t13;
	@FXML
	private TextField t14;
	@FXML
	private TextField t15;
	@FXML
	private TextField t16;
	@FXML
	private TextField t17;
	@FXML
	private TextField t18;
	@FXML
	private TextField t4;
	@FXML
	private TextField t5;
	@FXML
	private TextField t6;
	@FXML
	private TextField t7;
	@FXML
	private TextField t8;
	@FXML
	private TextField t9;
	@FXML
	private TextField t27;
	@FXML
	private TextField t36;
	@FXML
	private TextField t45;
	@FXML
	private TextField t54;
	@FXML
	private TextField t63;
	@FXML
	private TextField t72;
	@FXML
	private TextField t81;
	@FXML
	private TextField t26;
	@FXML
	private TextField t35;
	@FXML
	private TextField t44;
	@FXML
	private TextField t53;
	@FXML
	private TextField t62;
	@FXML
	private TextField t71;
	@FXML
	private TextField t80;
	@FXML
	private TextField t25;
	@FXML
	private TextField t34;
	@FXML
	private TextField t43;
	@FXML
	private TextField t52;
	@FXML
	private TextField t61;
	@FXML
	private TextField t70;
	@FXML
	private TextField t79;
	@FXML
	private TextField t24;
	@FXML
	private TextField t33;
	@FXML
	private TextField t42;
	@FXML
	private TextField t51;
	@FXML
	private TextField t60;
	@FXML
	private TextField t69;
	@FXML
	private TextField t78;
	@FXML
	private TextField t23;
	@FXML
	private TextField t32;
	@FXML
	private TextField t41;
	@FXML
	private TextField t50;
	@FXML
	private TextField t59;
	@FXML
	private TextField t68;
	@FXML
	private TextField t77;
	@FXML
	private TextField t22;
	@FXML
	private TextField t31;
	@FXML
	private TextField t40;
	@FXML
	private TextField t49;
	@FXML
	private TextField t58;
	@FXML
	private TextField t67;
	@FXML
	private TextField t76;
	@FXML
	private TextField t21;
	@FXML
	private TextField t30;
	@FXML
	private TextField t39;
	@FXML
	private TextField t48;
	@FXML
	private TextField t57;
	@FXML
	private TextField t66;
	@FXML
	private TextField t75;
	@FXML
	private TextField t20;
	@FXML
	private TextField t29;
	@FXML
	private TextField t38;
	@FXML
	private TextField t47;
	@FXML
	private TextField t56;
	@FXML
	private TextField t65;
	@FXML
	private TextField t74;
	@FXML
	private TextField t19;
	@FXML
	private TextField t28;
	@FXML
	private TextField t37;
	@FXML
	private TextField t46;
	@FXML
	private TextField t55;
	@FXML
	private TextField t64;
	@FXML
	private TextField t73;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	
	// Event Listener on Button[#btn1].onAction
	@FXML
	public void SolveBoard(ActionEvent event) {
		btn1.setFont(new Font(24));
		TextField[][] myTextField = {
				{t1, t2, t3, t4, t5, t6, t7, t8, t9},
				{t10, t11, t12, t13, t14, t15, t16, t17, t18},
				{t19, t20, t21, t22, t23, t24, t25, t26, t27},
				{t28, t29, t30, t31, t32, t33, t34, t35, t36},
				{t37, t38, t39, t40, t41, t42, t43, t44, t45},
				{t46, t47, t48, t49, t50, t51, t52, t53, t54},
				{t55, t56, t57, t58, t59, t60, t61, t62, t63},
				{t64, t65, t66, t67, t68, t69, t70, t71, t72},
				{t73, t74, t75, t76, t77, t78, t79, t80, t81}};
		
		int[][] board = new int[9][9];
		for(int r=0; r<9; r++) {
			for(int c=0; c<9; c++) {
				try {
					if(!myTextField[r][c].getText().equals(""))
						board[r][c] = Integer.parseInt(myTextField[r][c].getText().trim());
					else
						board[r][c] = 0;
				}catch(NumberFormatException e) {
				}
			}
		}
		int[][] copyBoard = new int[9][9];
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				copyBoard[i][j] = board[i][j];
			}
		}
		

		if(checkValidBoard(board)) {
			if(solve(board, 0, 0)) {
				for(int r=0; r<9; r++) {
					for(int c=0; c<9; c++) {
						if(copyBoard[r][c] == 0) {
							myTextField[r][c].setStyle("-fx-background-color : rgb(204, 255, 204)");
							myTextField[r][c].setText("" + board[r][c]);
						}else {
							myTextField[r][c].setStyle("-fx-background-color : rgb(245, 137, 137)");
						}
				    }
				}
			}
		}else {
			Alert error = new Alert(Alert.AlertType.WARNING);
			error.setTitle("Invalid inputs");
			error.setContentText("Inputs are not valid!!");
			error.showAndWait();
		}

	}
	// Event Listener on Button[#btn2].onAction
	@FXML
	public void ResetBoard(ActionEvent event) {
		TextField[][] myTextField = {
				{t1, t2, t3, t4, t5, t6, t7, t8, t9},
				{t10, t11, t12, t13, t14, t15, t16, t17, t18},
				{t19, t20, t21, t22, t23, t24, t25, t26, t27},
				{t28, t29, t30, t31, t32, t33, t34, t35, t36},
				{t37, t38, t39, t40, t41, t42, t43, t44, t45},
				{t46, t47, t48, t49, t50, t51, t52, t53, t54},
				{t55, t56, t57, t58, t59, t60, t61, t62, t63},
				{t64, t65, t66, t67, t68, t69, t70, t71, t72},
				{t73, t74, t75, t76, t77, t78, t79, t80, t81}};
		for(int r=0; r<9; r++) {
			for(int c=0; c<9; c++) {
				myTextField[r][c].setText("");
				myTextField[r][c].setStyle("-fx-background-color : white");
			}
		}
	}
	
	public boolean isSafe(int[][] board, int row, int col, int number) {
       //column
       for(int i=0; i<board.length; i++) {
           if(board[i][col] == number) {
               return false;
           }
       }
       //row
       for(int j=0; j<board.length; j++) {
           if(board[row][j] == number) {
               return false;
           }
       }
       //grid
       int sr = 3 * (row/3);
       int sc = 3 * (col/3);
       for(int i=sr; i<sr+3; i++) {
           for(int j=sc; j<sc+3; j++) {
               if(board[i][j] == number) {
                   return false;
               }
           }
       }
       return true;
	}
	  
	public boolean solve(int[][] board, int row, int col) {
       if(row == board.length) {
           return true;
       }
       int nrow = 0;
       int ncol = 0;
      
       if(col == board.length - 1) {
           nrow = row + 1;
           ncol = 0;
       } else {
           nrow = row;
           ncol = col + 1;
       }
      
       if(board[row][col] != 0) {
           if(solve(board, nrow, ncol)) {
               return true;
           }
       } else {
           //fill the place
           for(int i=1; i<=9; i++) {
               if(isSafe(board, row, col, i)) {
                   board[row][col] = i;
                   if(solve(board, nrow, ncol))
                       return true;
                   else
                        board[row][col] = 0;
               }
           }
       }           
       return false;
   }
	
	  // Function to check if a row is valid.
	  public boolean validRow(int row, int [][] board){
		  int temp[] = board[row];
		  Set<Integer>set = new HashSet<Integer>(); 
		  for(int value : temp) {
			  if(value < 0 || value > 9){
				  return false;
			  }
			  else if(value != 0){				// Checking for repeated values.
				  if(set.add(value) == false) {
					  return false;
				  }
			  }
		  }
		  return true;
	  }
	  // Function to check if a column is valid.
	  public boolean validColumn(int col, int [][] board){
		  Set<Integer>set = new HashSet<Integer>(); 
		  for (int i =0 ; i< 9; i++) {
			  if(board[i][col] < 0 || board[i][col] > 9){
				  return false;
			  }
			  else if (board[i][col] != 0){			 // Checking for repeated values.
				  if (set.add(board[i][col]) == false) {
					  return false;
				  }
			  }
		  }
		  return true;
	  }
	 // Function to check if all the subsquares are valid.
	  public boolean validSubsquares(int [][] board){
		  for (int row = 0 ; row < 9; row += 3) {
			  for (int col = 0; col < 9; col += 3) {
				  Set<Integer>set = new HashSet<Integer>(); 
				  for(int r = row; r < row+3; r++) {
					  for(int c= col; c < col+3; c++){
						  if (board[r][c] < 0 || board[r][c] > 9){
							  return false;
						  }
						  else if (board[r][c] != 0){
							  if (set.add(board[r][c]) == false) {
								  return false;
							  }
						  }
					  }
				  }
			  }   
		  }
		  return true;
	  }
	  //Function to check if the board invalid.
	  public boolean checkValidBoard(int [][] board){
		  for (int i =0 ; i< 9; i++) {
			  boolean res1 = validRow(i, board);
		      boolean res2 = validColumn(i, board);
		      if(res1 == false || res2 == false) {
		    	  return false;
		      }
		  }
		  boolean res3 = validSubsquares(board);
		  if(!res3) {
			  return false;
		  }
		  return true;
	  }
}
