package com.xebia.mowitnow.application;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import com.xebia.mowitnow.application.model.Coordinates;
import com.xebia.mowitnow.application.model.Instruction;
import com.xebia.mowitnow.application.model.Mower;
import com.xebia.mowitnow.application.model.Orientation;

import junit.framework.TestCase;

public class SetupTest extends TestCase {
	
	protected Coordinates coordinatesMax;
	protected List<Mower> mowers;
	protected Path path;
	
	@Before
	protected void setUp() throws Exception {

		mowers = new ArrayList<Mower>();
		setMower1();
		setMower2();
		coordinatesMax = new Coordinates(5, 5);
		path = Paths.get("ressources/test/files/fileTest.txt");
	}
	
	protected List<Instruction> setInstructionMower1() {
		
		List<Instruction> instructions = new ArrayList<>();
		instructions.add(Instruction.G);
		instructions.add(Instruction.A);
		instructions.add(Instruction.G);
		instructions.add(Instruction.A);
		instructions.add(Instruction.G);
		instructions.add(Instruction.A);
		instructions.add(Instruction.G);
		instructions.add(Instruction.A);
		instructions.add(Instruction.A);

		return instructions;
	}
	
	protected List<Instruction> setInstructionMower2() {
		
		List<Instruction> instructions = new ArrayList<>();
		instructions.add(Instruction.A);
		instructions.add(Instruction.A);
		instructions.add(Instruction.D);
		instructions.add(Instruction.A);
		instructions.add(Instruction.A);
		instructions.add(Instruction.D);
		instructions.add(Instruction.A);
		instructions.add(Instruction.D);
		instructions.add(Instruction.D);
		instructions.add(Instruction.A);

		return instructions;
	}

	private void setMower1() {
		
		Mower mower = new Mower();
		mower.setCoordinates(new Coordinates(1, 2));
		mower.setOrientation(Orientation.N);
		mower.setInstructions(setInstructionMower1());
		mowers.add(mower);
	}
	
	private void setMower2() {
		
		Mower mower = new Mower();
		mower.setCoordinates(new Coordinates(3, 3));
		mower.setOrientation(Orientation.E);

		mower.setInstructions(setInstructionMower2());
		mowers.add(mower);
	}

}
