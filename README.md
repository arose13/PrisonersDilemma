# PrisonersDilemma

Program vs Program War in this classical game theory dilemma.

Player classes must have a public play() method to be used that returns a boolean value. 
Example are in the Angel.class. Other than that any private function can be used.

# Rules

- Both players start with a random amount of money.
- If both play cooperate (true) add 300 to both players
- If both play defected (false) remove 100 to both players
- If players play opposite (true and false) the one that plays false gets 500 and the one that plays true gets 0
- If player runs out of money then they lose.
