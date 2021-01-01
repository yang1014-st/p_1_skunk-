package myskunk.dl;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Controller {
	private char wants_to_roll;
	private Boolean wants_to_test = false;
	private char wants_to_roll_test;
	private String turn_result;
	

	
	public void run() {

		Game game = new Game();

		StdOut.println("Welcome to play Skunk!");
		ask_user_if_want_to_roll();

		if (wants_to_roll == 'y') {

			while (wants_to_roll == 'y') {
				game.continue_game();
			
				StdOut.println(game.get_message_after_each_roll());

				if (game.get_turn().getLastRoll().get_result_of_check_skunk() == "not skunk") {
					ask_user_if_want_to_roll();
				}

				else {
					end_game_with_skunk(game);
					StdOut.println(this.get_turn_result());
					break;
				}
			}
			
			if (wants_to_roll == 'n') {
				end_game_with_not_select_y(game);
				StdOut.println(this.get_turn_result());
			}
			
			
			

		} else {
			end_game_with_not_select_y(game);
			StdOut.println(this.get_turn_result());

		}

	}



	private void end_game_with_skunk(Game game) {
		game.end_game();
		turn_result =  "-----------------------------" +"\n"+ game.get_message_after_each_turn();
		
	}



	private void end_game_with_not_select_y(Game game) {
				
		game.end_game();
		turn_result =  "-----------------------------" +"\n"
		+"You did not select 'y'." + "\n"+ game.get_message_after_each_turn();
		
	}
	
	public String get_turn_result() {
		return turn_result;
	}


	
	private void ask_user_if_want_to_roll() {
		
		if (this.wants_to_test == false) {
			char wants_to_roll;
			try {

				StdOut.println("Do you want to roll? y or n =>");
				wants_to_roll = StdIn.readLine().toLowerCase().charAt(0);
				this.wants_to_roll = wants_to_roll;
			} catch (StringIndexOutOfBoundsException e) {

				this.wants_to_roll = 'n';
			}
		}
		else {
			wants_to_roll = wants_to_roll_test;
		}
		

	}

	public void ask_user_if_want_to_roll(Boolean wants_to_test, char wants_to_roll_test) {
		this.wants_to_test = wants_to_test;
		this.wants_to_roll_test = wants_to_roll_test;

	}

}
