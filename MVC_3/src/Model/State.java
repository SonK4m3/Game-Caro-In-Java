package Model;
import View.*;

import java.util.*;

import Control.*;

public class State {
	// queue to store current state and next state
	Queue<Integer> state = new LinkedList<Integer>();
	
	// variable current flight's state
	int stateNumber = 0;
	
	// position swing in each state
	int[][] stateLeft   = {{0,0}, {1,0}, {2,0}, {3,0}, {1,-1}, {1,1}, {3,-1}, {3,1}};
	int[][] stateRight   = {{0,0}, {-1,0}, {-2,0}, {-3,0}, {-1,-1}, {-1,1}, {-3,-1}, {-3,1}};
	int[][] stateTop  = {{0,0}, {0,1}, {0,2}, {0,3}, {-1,1}, {1,1}, {-1,3}, {1,3}};
	int[][] stateBot = {{0,0}, {0,-1}, {0,-2}, {0,-3}, {-1,-1}, {1,-1}, {-1,-3}, {1,-3}};
	
	private Enemy enemy;
	
	public State(Enemy enemy) {
		this.enemy = enemy;
	}
	
	// function to get matrix of position 
	public int[][] getStateLeft(){
		return stateLeft;
	}
	
	public int[][] getStateRight(){
		return stateRight;
	}
	
	public int[][] getStateTop(){
		return stateTop;
	}
	
	public int[][] getStateBot(){
		return stateBot;
	}
	// state number
	public void setStateNumber(int num) {
		this.stateNumber = num;
	}
	
	public int getStateNumber() {
		if(isEmpty()) {
			stateNumber = 0;
		}
		else {
			stateNumber = state.peek();
		}
		return stateNumber;
	}
	
	// function to check all state flight can place
	public boolean checkStateFlight(int[][] mat) {
		//1. set flight's state position need check
		enemy.setSwing(mat);
		
		if(enemy.isOutOfBoard()) {
			//2. if can not stick, reset position
			enemy.initSwing();
			return false;
		}
		
		for(int i = 0; i < 8; i++) {
			if(enemy.getBoard().getVal(enemy.getSwingX(i), enemy.getSwingY(i)) != 0)
				return false;
		}
		
		return true;
	}
	
	public void setStateFlight() {
		state.clear();
		if(checkStateFlight(stateLeft))
			state.add(1);
		if(checkStateFlight(stateTop))
			state.add(2);
		if(checkStateFlight(stateRight))
			state.add(3);
		if(checkStateFlight(stateBot))
			state.add(4);
	}
	
	public Queue<Integer> getArrayState() {
		return state;
	}
	
	public boolean isEmpty() {
		return state.isEmpty();
	}
	
	public void changeState() {
		int tmp = state.poll();
		state.add(tmp);
	}

	public void reset() {
		state.clear();
		this.stateNumber = 0;
	}
	
	// print state
	public void print() {
		System.out.println("State: " + state);
		
	}
	
}
